package com.nnikolov.jiradump.model;

/**
 * Meta-information about a JIRA issue, so it can be easily identified and
 * points to full issue information via {@link HasIdentifier#getSelf()}
 */
public class IssueMeta extends BaseJiraEntity implements HasKey {

    private String key;

    public IssueMeta() {
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
