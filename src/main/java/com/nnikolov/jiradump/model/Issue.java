package com.nnikolov.jiradump.model;

/**
 *
 */
public class Issue extends IssueMeta {

    private String summary;

    private String url;

    private IssueFields fields;

    public void buildUrl(String browseUrl) {
        url = browseUrl + getKey();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public IssueFields getFields() {
        return fields;
    }

    public void setFields(IssueFields fields) {
        this.fields = fields;
    }
}
