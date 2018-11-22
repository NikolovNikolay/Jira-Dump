package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.model.abs.HasIdentifier;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * A basic JIRA entity that has identifier and is reused in
 * other entities context
 */
public abstract class BaseJiraEntity implements HasIdentifier {

    @XmlAttribute
    private String id;

    @XmlAttribute
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
