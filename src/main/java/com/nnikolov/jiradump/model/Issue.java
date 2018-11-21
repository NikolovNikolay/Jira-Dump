package com.nnikolov.jiradump.model;

/**
 * Representing an issue in the JIRA Platform
 */
public class Issue extends IssueMeta {

    private String url;
    private IssueFields fields;

    /**
     * Builds a link that can be opened in browser
     *
     * @param browseUrl url for review
     */
    public Issue buildUrl(String browseUrl) {
        url = browseUrl + getKey();
        return this;
    }

    public String getUrl() {
        return url;
    }

    public IssueFields getFields() {
        return fields;
    }
}
