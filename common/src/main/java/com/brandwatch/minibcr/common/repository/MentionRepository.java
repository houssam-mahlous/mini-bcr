package com.brandwatch.minibcr.common.repository;

import com.brandwatch.minibcr.common.domain.Mention;

import java.util.List;

public interface MentionRepository{
    void insert(Mention mention);

    List<Mention> findAll();

    Mention findMentionById(long mentionId);

    void deleteMention(long mentionId);
}
