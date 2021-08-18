package com.brandwatch.minibcr.api.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandwatch.minibcr.common.domain.Query;
import com.brandwatch.minibcr.common.repository.QueryRepository;

@Service
public class QueryService {
    
    @Autowired
    private QueryRepository queryRepository;

    /**
     * Resets the queries table in the local database
     * and populates it with dummy queries.
     * TODO: Use a schema that can be run with docker
     */
    @PostConstruct
    public void initQueries() {
        queryRepository.deleteAll(); //Temporary for now to reset the table in local db
        queryRepository.save(new Query("this AND is AND first"));
        queryRepository.save(new Query("this AND is AND second"));
    }

    public List<Query> getQueries() {
        return queryRepository.findAll();
    }

    public Query getQueryById(Long id) {
        return queryRepository.findQueryById(id);
    }

    public void saveQuery(String text) {
        if (StringUtils.isNotBlank(text)) {
            Query query = new Query(text);
            queryRepository.save(query);
        } else {
            throw new RuntimeException("Query is not defined");
        }
    }

    public void deleteQueryById(long id) {
        queryRepository.deleteQuery(id);
    }

}
