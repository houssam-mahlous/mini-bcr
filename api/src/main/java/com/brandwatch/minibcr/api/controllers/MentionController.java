package com.brandwatch.minibcr.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brandwatch.minibcr.api.services.MentionService;
import com.brandwatch.minibcr.common.domain.Mention;

@RestController
public class MentionController {

    private final MentionService mentionService;

    public MentionController(MentionService mentionService) {
        this.mentionService = mentionService;
    }

    @GetMapping("/mentions")
    public List<Mention> getMentions() {
        return mentionService.getMentions();
    }

    @GetMapping("/mentions/{id}")
    public Mention getMentionById(@PathVariable String id) {
        return mentionService.getMentionById(id);
    }

}
