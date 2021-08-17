package com.brandwatch.minibcr.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // Lombok: adds getters and setters
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
// This tells Hibernate to make a table out of this class
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;

    public Mention(String text) {
        this.text = text;
    }
}
