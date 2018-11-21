package com.nnikolov.jiradump.model;

/**
 * Wrapper over issue specific information
 */
public class IssueFields {

    private IssueType issuetype;
    private IssuePriority priority;
    private String summary;
    private String description;
    private Reporter reporter;
    private String created; // Using string, because Instant messes up the gson serializer
    private Comment comment;

    public IssueFields() {
    }

    public IssueType getIssuetype() {
        return issuetype;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public String getCreated() {
        return created;
    }

    public Comment getComment() {
        return comment;
    }
}
