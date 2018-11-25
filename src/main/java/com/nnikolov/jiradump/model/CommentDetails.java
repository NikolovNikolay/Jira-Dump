package com.nnikolov.jiradump.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Detailed information for a comment
 */
public class CommentDetails {

    private CommentAuthor author;
    private String body;

    public CommentDetails() {
    }

    /**
     * @return author of an issue
     */
    @XmlElement
    public CommentAuthor getAuthor() {
        return author;
    }

    /**
     * @return text body of the comment
     */
    @XmlElement
    public String getBody() {
        return body;
    }
}
