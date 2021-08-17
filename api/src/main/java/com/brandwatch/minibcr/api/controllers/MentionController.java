package com.brandwatch.minibcr.api.controllers;

import com.brandwatch.minibcr.api.services.MentionService;
import com.brandwatch.minibcr.common.domain.Mention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentionController {
    @Autowired
    private MentionService mentionService;

    @GetMapping("/mentions")
    public List<Mention> getMentions(){
        return mentionService.getMentions();
    }

    @GetMapping("/mentions/:id")
    public Mention getMentionById(@PathVariable long id){
        return mentionService.getMentionById(id);
    }

    @PostMapping("/mentions")
    public void saveQuery(@RequestParam("text") String text) {
        mentionService.insertMention(text);
    }

    @DeleteMapping("/mentions/{id}")
    public void deleteQuery(@PathVariable long id) {
        mentionService.deleteMentionById(id);
    }
}
