package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.model.abs.HasIdentifier;
import com.nnikolov.jiradump.model.abs.HasKey;

import javax.xml.bind.annotation.XmlElement;

/**
 * Meta-information about a JIRA issue, so it can be easily identified and
 * points to full issue information via {@link HasIdentifier#getSelf()}
 */
public class IssueMeta extends BaseJiraEntity implements HasKey {

    @XmlElement
    private String key;

    public IssueMeta() {
    }

    @Override
    public String getKey() {
        return key;
    }

    public void setPropKey(String key) {
        this.key = key;
    }
}
