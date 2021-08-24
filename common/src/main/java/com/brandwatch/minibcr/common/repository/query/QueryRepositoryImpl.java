package com.brandwatch.minibcr.common.repository.query;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brandwatch.minibcr.common.domain.Query;

@Repository
public class QueryRepositoryImpl implements QueryRepository {

    private static final String QUERY_TABLE = "queries";
    private static final String ALL_FIELDS = "id, definition";
    private static final Logger logger = LoggerFactory.getLogger(QueryRepositoryImpl.class);
    private final QueryRowMapper queryRowMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public QueryRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, QueryRowMapper queryRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.queryRowMapper = queryRowMapper;
    }

    @Override
    public void save(Query query) {
        String sql = "INSERT INTO " + QUERY_TABLE + "(definition) VALUES (:definition)";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("definition", query.getDefinition()));
    }

    @Override
    public List<Query> findAll() {
        String sql = "SELECT " + ALL_FIELDS + " FROM " + QUERY_TABLE;
        return namedParameterJdbcTemplate.query(sql, queryRowMapper);
    }

    @Override
    public Query findQueryById(long queryId) {
        Query query = null;
        try {
            String sql = " SELECT " + ALL_FIELDS + " FROM " + QUERY_TABLE + " WHERE "
                    + " id = :queryId ";
            query = namedParameterJdbcTemplate.queryForObject(sql,
                    new MapSqlParameterSource("queryId", queryId), queryRowMapper);
        } catch (EmptyResultDataAccessException exception) {
            logger.info("Query with id {} does not exist...", queryId);
        }

        return query;
    }

    @Override
    public void deleteQuery(long queryId) {
        String sql = " DELETE FROM " + QUERY_TABLE + " WHERE id = :queryId ";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("queryId", queryId));
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM " + QUERY_TABLE;
        namedParameterJdbcTemplate.getJdbcTemplate().update(sql);
    }
}
