package com.brandwatch.minibcr.api.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Resets the mentions table in the local database
     * and populates it with dummy mentions.
     * TODO: Use a schema that can be run with docker
     */
    @PostConstruct
    public void initMentions() {
        mentionRepository.deleteAll(); //Temporary for now to reset the table in local db
        mentionRepository.save(new Mention("This is my first tweet"));
        mentionRepository.save(new Mention("This is my second tweet"));
    }

    public List<Mention> getMentions() {
        return mentionRepository.findAll();
    }

    public Mention getMentionById(Long id) {
        Mention mention = mentionRepository.findMentionById(id);
        if (mention == null) {
            throw new MentionNotFoundException(id);
        }
        return mention;
    }

    public void saveMention(String text) {
        if (StringUtils.isNotBlank(text)) {
            Mention mention = new Mention(text);
            mentionRepository.save(mention);
        } else {
            throw new RuntimeException("Mention is not defined");
        }
    }

    public void deleteMentionById(long id) {
        mentionRepository.deleteMention(id);
    }

}
