package com.nnikolov.jiradump.model;

/**
 * Base information of an user in the JIRA platform
 */
public abstract class BaseUser {

    private String name;

    public BaseUser() {
    }

    /**
     * @return username of a user
     */
    public String getName() {
        return name;
    }
}
