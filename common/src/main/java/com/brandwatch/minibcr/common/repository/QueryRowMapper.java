package com.brandwatch.minibcr.common.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brandwatch.minibcr.common.domain.Query;

public class QueryRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Query query = new Query();
        query.setId(resultSet.getLong("id"));
        query.setDefinition(resultSet.getString("definition"));
        return query;
    }
}
