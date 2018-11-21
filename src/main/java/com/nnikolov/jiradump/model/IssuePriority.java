package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.HasIcon;

/**
 * Holds information for an issue type in JIRA
 */
public class IssuePriority extends BaseJiraEntity implements HasIcon {

    private String iconUrl;
    private String name;

    public IssuePriority() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String getIconUrl() {
        return iconUrl;
    }
}
