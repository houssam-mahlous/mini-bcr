package com.brandwatch.minibcr.api.exceptions;

public class QueryNotFoundException extends RuntimeException {

    private final long id;

    public QueryNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
