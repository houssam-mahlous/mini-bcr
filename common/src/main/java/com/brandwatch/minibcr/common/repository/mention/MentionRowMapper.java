package com.brandwatch.minibcr.common.repository.mention;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.brandwatch.minibcr.common.domain.Mention;

@Component
public class MentionRowMapper implements RowMapper<Mention> {

    @Override
    public Mention mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Mention(resultSet.getLong("id"), resultSet.getString("text"));
    }
}
