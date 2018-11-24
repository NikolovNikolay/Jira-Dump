package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.model.abs.HasIdentifier;

import javax.xml.bind.annotation.XmlElement;

/**
 * A basic JIRA entity that has identifier and is reused in
 * other entities context
 */
public abstract class BaseJiraEntity implements HasIdentifier {

    @XmlElement
    private String id;

    @XmlElement
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

    public void setParamId(String id) {
        this.id = id;
    }

    public void setParamSelf(String self) {
        this.self = self;
    }
}
