package com.brandwatch.minibcr.common.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.brandwatch.minibcr.common.domain.Mention;

@Component
public class MentionRowMapper implements RowMapper<Mention> {

    @Override
    public Mention mapRow(ResultSet resultSet, int i) throws SQLException {
        Mention mention = new Mention();
        mention.setId(resultSet.getLong("id"));
        mention.setText(resultSet.getString("text"));
        return mention;
    }
}
