package com.nnikolov.jiradump.model;

/**
 * A basic JIRA entity that has identifier and is reused in
 * other entities context
 */
public abstract class BaseJiraEntity implements HasIdentifier {

    private String id;
    private String self;

    /**
     * @return Id of the specific entity in the JIRA Cloud Platform DB
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * @return URI reference to the resource via the JIRA Cloud Platform API
     */
    @Override
    public String getSelf() {
        return self;
    }
}
