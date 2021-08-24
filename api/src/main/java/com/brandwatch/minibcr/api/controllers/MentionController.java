package com.brandwatch.minibcr.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Mention getMentionById(@PathVariable long id) {
        return mentionService.getMentionById(id);
    }

    @PostMapping("/mentions")
    public void saveQuery(@RequestParam("text") String text) {
        mentionService.saveMention(text);
    }

    @DeleteMapping("/mentions/{id}")
    public void deleteQuery(@PathVariable long id) {
        mentionService.deleteMentionById(id);
    }
}
