package com.brandwatch.minibcr.common.repository.mention;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brandwatch.minibcr.common.domain.Mention;

@Repository
public class MentionRepositoryImpl implements MentionRepository {

    private static final String MENTIONS_TABLE = "mentions";
    private static final String ALL_FIELDS = " id, text";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MentionRowMapper mentionRowMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MentionRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            MentionRowMapper mentionRowMapper) {
        this.mentionRowMapper = mentionRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void save(Mention mention) {
        String sql = "INSERT INTO " + MENTIONS_TABLE + "(text) VALUES (:text)";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("text", mention.getText()));
    }

    @Override
    public List<Mention> findAll() {
        String sql = "SELECT" + ALL_FIELDS + " FROM " + MENTIONS_TABLE;
        return namedParameterJdbcTemplate.query(sql, mentionRowMapper);
    }

    @Override
    public Mention findMentionById(long mentionId) {
        Mention mention = null;
        try {
            String sql = " SELECT " + ALL_FIELDS + " FROM " + MENTIONS_TABLE + " WHERE "
                    + " id = :mentionId ";
            mention = namedParameterJdbcTemplate.queryForObject(sql,
                    new MapSqlParameterSource("mentionId", mentionId), mentionRowMapper);
        } catch (EmptyResultDataAccessException exception) {
            logger.info("Mention with id {} does not exist...", mentionId);
        }

        return mention;
    }

    @Override
    public void deleteMention(long mentionId) {
        String sql = " DELETE FROM " + MENTIONS_TABLE + " WHERE id = :mentionId ";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("mentionId", mentionId));
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM " + MENTIONS_TABLE;
        namedParameterJdbcTemplate.getJdbcTemplate().update(sql);
    }
}
