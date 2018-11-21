package com.nnikolov.jiradump.model;

/**
 * Detailed information for a comment
 */
public class CommentDetails {

    private CommentAuthor author;
    private String body;

    public CommentDetails() {
    }

    public CommentAuthor getAuthor() {
        return author;
    }

    /**
     * @return text body of the comment
     */
    public String getBody() {
        return body;
    }
}
