package com.nnikolov.jiradump.model.abs;

/**
 * Marks an entity as such having information that can be
 * identified with in the JIRA Cloud Platform
 */
public interface HasIdentifier {

    /**
     * @return the id of the record from the public Atlassian cloud platform
     */
    String getId();

    /**
     * @return link to detailed issue information from from the public Atlassian cloud platform
     */
    String getSelf();
}
