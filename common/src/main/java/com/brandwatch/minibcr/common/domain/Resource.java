package com.brandwatch.minibcr.common.domain;

import java.time.LocalDateTime;

/*
 * This class is used to represent crawled tweets
 */
public class Resource {

    private String resourceId;

    private String text;

    private String author;

    private LocalDateTime createdAt;

    public Resource(String resourceId, String text, String author, LocalDateTime createdAt) {
        this.resourceId = resourceId;
        this.text = text;
        this.author = author;
        this.createdAt = createdAt;
    }

    public Resource() {
    }

    @Override
    public String toString() {
        return "Resource{"
                + "resourceId='" + resourceId + '\''
                + ", text='" + text + '\''
                + ", author='" + author + '\''
                + ", createdAt=" + createdAt
                + "}";
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static class Builder {

        private String resourceId;

        private String text;

        private String author;

        private LocalDateTime createdAt;

        public Builder withId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Builder fromAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Resource build() {
            return new Resource(resourceId, text, author, createdAt);
        }
    }
}
