package com.brandwatch.minibcr.common.repository.query;

import java.util.List;

import com.brandwatch.minibcr.common.domain.Query;

public interface QueryRepository {

    void save(Query query);

    List<Query> findAll();

    Query findQueryById(long queryId);

    void deleteQuery(long queryId);

    void deleteAll();
}
