package com.nnikolov.jiradump.model;

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
    public CommentDetails[] getComments() {
        return comments;
    }
}