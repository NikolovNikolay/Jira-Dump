package com.nnikolov.jiradump.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Base information of an user in the Atlassian platform
 */
public abstract class BaseUser {

    private String name;

    public BaseUser() {
    }

    /**
     * @return username of a user
     */
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
