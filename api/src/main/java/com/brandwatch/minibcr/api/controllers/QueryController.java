package com.brandwatch.minibcr.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brandwatch.minibcr.api.services.QueryService;
import com.brandwatch.minibcr.common.domain.Query;

@RestController
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/queries")
    public List<Query> getQueries() {
        return queryService.getQueries();
    }

    @GetMapping("/queries/{id}")
    public Query getQueryById(@PathVariable long id) {
        return queryService.getQueryById(id);
    }

    @PostMapping("/queries")
    public void saveQuery(@RequestParam("text") String text) {
        queryService.saveQuery(text);
    }

    @DeleteMapping("/queries/{id}")
    public void deleteQuery(@PathVariable long id) {
        queryService.deleteQueryById(id);
    }
}
