package com.brandwatch.minibcr.common.domain;

public class Query {

    private long id;

    private String definition;

    public Query(long id, String definition) {
        this.id = id;
        this.definition = definition;
    }

    public Query(String definition) {
        this.definition = definition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Query{" + "id=" + id + ", definition='" + definition + '\'' + '}';
    }
}
