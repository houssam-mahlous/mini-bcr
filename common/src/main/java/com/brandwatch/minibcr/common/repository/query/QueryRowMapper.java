package com.brandwatch.minibcr.common.repository.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.brandwatch.minibcr.common.domain.Query;

@Component
public class QueryRowMapper implements RowMapper<Query> {

    @Override
    public Query mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Query(resultSet.getLong("id"), resultSet.getString("definition"));
    }
}
