package com.brandwatch.minibcr.common.domain;

public class Mention {

    private long id;
    private String text;

    public Mention(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Mention(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mention{" + "id=" + id + ", text='" + text + '\'' + '}';
    }
}
