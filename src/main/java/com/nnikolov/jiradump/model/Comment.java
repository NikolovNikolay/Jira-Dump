package com.nnikolov.jiradump.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * A comment section in JIRA issue
 */
public class Comment {

    private CommentDetails[] comments;

    public Comment() {
    }

    /**
     * @return meta-information about comments
     */
    @XmlElement
    public CommentDetails[] getComments() {
        return comments;
    }
}