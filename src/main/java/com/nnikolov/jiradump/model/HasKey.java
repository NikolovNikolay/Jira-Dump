package com.nnikolov.jiradump.model;

/**
 * Marks the entity as having an alias key to be associated with a project
 */
public interface HasKey {

    /**
     * @return alias key from JIRA Cloud API
     */
    String getKey();
}
