package com.nnikolov.jiradump.model;

/**
 * A basic JIRA entity that has identifier and is reused in
 * other entities context
 */
public class BaseJiraEntity implements HasIdentifier {

    private String id;
    private String self;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getSelf() {
        return self;
    }
}
