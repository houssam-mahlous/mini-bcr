package com.brandwatch.minibcr.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.brandwatch.minibcr.api.exceptions.EmptyQueryException;
import com.brandwatch.minibcr.api.exceptions.MentionNotFoundException;
import com.brandwatch.minibcr.api.exceptions.QueryNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {QueryNotFoundException.class})
    public ResponseEntity<String> queryNotFoundException(QueryNotFoundException ex) {
        String message = "Query with ID: " + ex.getId() + " does not exist.";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MentionNotFoundException.class})
    public ResponseEntity<String> mentionNotFoundException(MentionNotFoundException ex) {
        String message = "Mention with ID: " + ex.getId() + " does not exist.";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EmptyQueryException.class})
    public ResponseEntity<String> emptyQueryException() {
        String message = "Query cannot be null.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
