package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.model.abs.HasIcon;

import javax.xml.bind.annotation.XmlElement;

/**
 * Holds information for an issue type in JIRA
 */
public class IssuePriority extends BaseJiraEntity implements HasIcon {

    private String iconUrl;
    private String name;

    public IssuePriority() {
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    @Override
    public String getIconUrl() {
        return iconUrl;
    }
}
