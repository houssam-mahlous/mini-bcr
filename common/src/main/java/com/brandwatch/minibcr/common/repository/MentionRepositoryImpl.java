package com.brandwatch.minibcr.common.repository;

import com.brandwatch.minibcr.common.domain.Mention;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

@Repository
public class MentionRepositoryImpl extends JdbcDaoSupport implements MentionRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String MENTIONS_TABLE = "mention";
    private static final String ALL_FIELDS = " id, text";

    private final MentionRowMapper mentionRowMapper;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DataSource dataSource;

    public MentionRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, MentionRowMapper mentionRowMapper) {
        this.mentionRowMapper = mentionRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insert(Mention mention) {
        String sql = "INSERT INTO " +  MENTIONS_TABLE  +
                " (" + ALL_FIELDS + ") VALUES (:id, :text)" ;

        Map<String, Object> parameters = ImmutableMap.of(
                "id", mention.getId(),
                "text", mention.getText()
        );

        namedParameterJdbcTemplate.update(sql,parameters);
    }

    @Override
    public List<Mention> findAll() {
        String sql = "SELECT" + ALL_FIELDS + " FROM " + MENTIONS_TABLE;
        return namedParameterJdbcTemplate.query(sql, mentionRowMapper);
    }

    @Override
    public Mention findMentionById(long mentionId) {
        Mention mention = null;
        try{
            String sql = " SELECT " + ALL_FIELDS + " FROM " + MENTIONS_TABLE + " WHERE "
                    + " id = :mentionId ";
            mention = namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("mentionId", mentionId), mentionRowMapper);
        }
        catch (EmptyResultDataAccessException exception){
            logger.info("Mention with id {} does not exist...", mentionId);
        }

        return mention;
    }


    @Override
    public void deleteMention(long mentionId) {
        String sql = " DELETE FROM " + MENTIONS_TABLE + " WHERE id = :mentionId ";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("mentionId", mentionId));
    }
}
