package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.HasIcon;

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

    public String getDescription() {
        return description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getName() {
        return name;
    }

    public boolean isSubtask() {
        return subtask;
    }

    public long getAvatarId() {
        return avatarId;
    }
}
