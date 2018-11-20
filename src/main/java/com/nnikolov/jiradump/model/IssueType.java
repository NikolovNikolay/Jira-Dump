package com.nnikolov.jiradump.model;

public class IssueType extends BaseJiraEntity {

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
