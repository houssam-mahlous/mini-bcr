package com.brandwatch.minibcr.api.controllers;

import com.brandwatch.minibcr.api.services.MentionService;
import com.brandwatch.minibcr.common.domain.Mention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MentionController {
    @Autowired
    private MentionService mentionService;

    @GetMapping("/mentions")
    public List<Mention> getMentions(){
        return mentionService.getMentions();
    }
}
