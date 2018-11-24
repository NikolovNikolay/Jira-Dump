package com.nnikolov.jiradump.model;

import javax.xml.bind.annotation.XmlElement;

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

    @XmlElement
    public IssueType getIssuetype() {
        return issuetype;
    }

    @XmlElement
    public IssuePriority getPriority() {
        return priority;
    }

    @XmlElement
    public String getSummary() {
        return summary;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    @XmlElement
    public Reporter getReporter() {
        return reporter;
    }

    @XmlElement
    public String getCreated() {
        return created;
    }

    @XmlElement
    public Comment getComment() {
        return comment;
    }

    public void setIssuetype(IssueType issuetype) {
        this.issuetype = issuetype;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
