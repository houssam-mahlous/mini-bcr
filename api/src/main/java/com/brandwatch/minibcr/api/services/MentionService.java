package com.brandwatch.minibcr.api.services;

import com.brandwatch.minibcr.common.domain.Mention;
import com.brandwatch.minibcr.common.repository.MentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MentionService {

    @Autowired
    private MentionRepository mentionRepository;

    @PostConstruct
    public void initMentions(){
        mentionRepository.saveAll(Stream.of
                        (new Mention(1, "This is my first tweet"),
                                new Mention(2, "This is my second tweet"))
                .collect(Collectors.toList()));
    }

    public List<Mention> getMentions(){
        return mentionRepository.findAll();
    }
}
