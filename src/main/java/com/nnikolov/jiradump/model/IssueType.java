package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.model.abs.HasIcon;

import javax.xml.bind.annotation.XmlElement;

/**
 * Holds specific information for issue type from the JIRA Cloud Platform
 */
public class IssueType extends BaseJiraEntity implements HasIcon {

    private String description;
    private String iconUrl;
    private String name;
    private boolean subtask;
    private long avatarId;

    public IssueType() {
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    @XmlElement
    public String getIconUrl() {
        return iconUrl;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public boolean isSubtask() {
        return subtask;
    }

    @XmlElement
    public long getAvatarId() {
        return avatarId;
    }
}
