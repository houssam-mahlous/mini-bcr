package com.brandwatch.minibcr.api.exceptions;

public class MentionNotFoundException extends RuntimeException {
    private final long id;

    public MentionNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
