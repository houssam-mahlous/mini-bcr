package com.brandwatch.minibcr.common.repository.mention;

import java.util.List;

import com.brandwatch.minibcr.common.domain.Mention;

public interface MentionRepository {

    void save(Mention mention);

    List<Mention> findAll();

    Mention findMentionById(long mentionId);

    void deleteMention(long mentionId);

    void deleteAll();
}
