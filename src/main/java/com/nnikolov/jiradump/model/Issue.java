package com.nnikolov.jiradump.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Representing an issue in the JIRA Platform
 */
@XmlRootElement
public class Issue extends IssueMeta {

    @XmlElement
    private String url;

    @XmlElement
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

    public void setParamUrl(String url) {
        this.url = url;
    }

    public void setParamFields(IssueFields fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return url.equals(issue.url) &&
                getKey().equals(issue.getKey()) &&
                getSelf().equals(issue.getSelf()) &&
                getId().equals(issue.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, fields, getId(), getKey(), getSelf());
    }
}
