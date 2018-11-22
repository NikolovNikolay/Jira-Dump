package com.nnikolov.jiradump.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representing an issue in the JIRA Platform
 */
@XmlRootElement
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

    @XmlElement
    public String getUrl() {
        return url;
    }

    @XmlElement
    public IssueFields getFields() {
        return fields;
    }
}
