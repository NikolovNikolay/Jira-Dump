package com.nnikolov.jiradump.model;

/**
 * Marks an entity as such having information that can be
 * identified with in the JIRA Cloud Platform
 */
public interface HasIdentifier {

    /**
     * @return The id of the record from the JIRA Cloud Platform DB
     */
    String getId();

    /**
     * @return Link to detailed issue information from the JIRA Cloud API
     */
    String getSelf();
}
