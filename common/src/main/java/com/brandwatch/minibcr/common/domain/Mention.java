package com.brandwatch.minibcr.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity// This tells Hibernate to make a table out of this class
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    private String text;

    public Mention(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Mention(String text) {
        this.text = text;
    }

    public Mention() {
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Mention{" + "id=" + id + ", text='" + text + '\'' + '}';
    }
}
