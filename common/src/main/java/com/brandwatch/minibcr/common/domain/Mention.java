package com.brandwatch.minibcr.common.domain;

import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.fasterxml.jackson.annotation.JsonFormat;

//the annotation @SolrDocument marks this class as a type that can be stored in solr database using Sping data
//we should specifiy the collection in the database where this document will be stored in
@SolrDocument(collection = "mentions")
public class Mention {

    @Id
    @Indexed(name = "id", type = "string")
    private String mentionId;

    @Indexed(name = "queryId", type = "string")
    private long queryId;

    @Indexed(name = "text", type = "string")
    private String text;

    @Indexed(name = "fromUser", type = "string")
    private String fromUser;

    @Indexed(name = "createdAt", type = "string")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdAt;

    private Mention(String mentionId, long queryId, String text, String fromUser, Instant createdAt) {
        this.mentionId = mentionId;
        this.queryId = queryId;
        this.text = text;
        this.fromUser = fromUser;
        this.createdAt = createdAt;
    }

    public Mention() {

    }

    public String getMentionId() {
        return mentionId;
    }

    public String getText() {
        return text;
    }

    public long getQueryId() {
        return queryId;
    }

    public String getFromUser() {
        return fromUser;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mention mention = (Mention) o;
        return queryId == mention.queryId
                && Objects.equals(mentionId, mention.mentionId)
                && Objects.equals(text, mention.text)
                && Objects.equals(fromUser, mention.fromUser)
                && Objects.equals(createdAt, mention.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentionId, text, queryId, fromUser, createdAt);
    }

    public static class Builder {

        private String mentionId;
        private long queryId;
        private String text;
        private String fromUser;
        private Instant createdAt;

        public Builder withMentionId(String mentionId) {
            this.mentionId = mentionId;
            return this;
        }

        public Builder withQueryId(long queryId) {
            this.queryId = queryId;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Builder fromUser(String fromUser) {
            this.fromUser = fromUser;
            return this;
        }


        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Mention build() {
            return new Mention(mentionId, queryId, text, fromUser, createdAt);
        }
    }
}

