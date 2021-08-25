package com.brandwatch.minibcr.storage.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.brandwatch.minibcr.common.domain.Mention;
import com.brandwatch.minibcr.common.repository.mention.MentionRepository;

@Service
public class MentionStoreService {

    private static final Logger log = LoggerFactory.getLogger(MentionStoreService.class);
    private final MentionRepository mentionRepository;

    public MentionStoreService(MentionRepository mentionRepository) {
        this.mentionRepository = mentionRepository;
    }

    /**
     * Saves the given mention to a Solr document.
     *
     * @param mention mention to be saved
     */
    public void saveMention(Mention mention) {
        mentionRepository.save(mention);
        log.info("Saved mention with contents: ", mention.getText());
    }

}
