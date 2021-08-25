package com.brandwatch.minibcr.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brandwatch.minibcr.api.exceptions.MentionNotFoundException;
import com.brandwatch.minibcr.common.domain.Mention;
import com.brandwatch.minibcr.common.repository.mention.MentionRepository;

@Service
public class MentionService {

    private final MentionRepository mentionRepository;

    public MentionService(MentionRepository mentionRepository) {
        this.mentionRepository = mentionRepository;
    }

    public List<Mention> getMentions() {
        return mentionRepository.readAllMentions();
    }

    public Mention getMentionById(String id) {
        Mention mention = mentionRepository.findByMentionId(id);
        if (mention == null) {
            throw new MentionNotFoundException(id);
        }
        return mention;
    }

}
