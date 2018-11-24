package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.model.abs.HasIcon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Holds information for an issue type in JIRA
 */
@XmlRootElement
public class IssuePriority extends BaseJiraEntity implements HasIcon {

    @XmlElement
    String iconUrl;

    @XmlElement
    String name;

    public IssuePriority() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String getIconUrl() {
        return iconUrl;
    }

    public void setPropIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setPropName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuePriority priority = (IssuePriority) o;
        return iconUrl.equals(priority.iconUrl) &&
                name.equals(priority.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iconUrl, name);
    }
}
