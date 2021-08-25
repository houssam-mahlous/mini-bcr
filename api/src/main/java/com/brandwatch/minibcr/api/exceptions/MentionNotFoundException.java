package com.brandwatch.minibcr.api.exceptions;

public class MentionNotFoundException extends RuntimeException {
    private final String id;

    public MentionNotFoundException(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
