package com.nnikolov.jiradump.model.abs;

/**
 * Marks the entity as having an alias key to be associated with a project
 */
public interface HasKey {

    /**
     * @return alias key from Atlassian public server
     */
    String getKey();
}
