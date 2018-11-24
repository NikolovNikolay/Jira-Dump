package com.nnikolov.jiradump.model;

import com.nnikolov.jiradump.model.abs.HasIcon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Holds specific information for issue type from the JIRA Cloud Platform
 */
@XmlRootElement
public class IssueType extends BaseJiraEntity implements HasIcon {

    @XmlElement
    private String description;

    @XmlElement
    private String iconUrl;

    @XmlElement
    private String name;

    @XmlElement
    private boolean subtask;

    @XmlElement
    private long avatarId;

    public IssueType() {
    }

    public String getDescription() {
        return description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getName() {
        return name;
    }

    public boolean isSubtask() {
        return subtask;
    }

    public long getAvatarId() {
        return avatarId;
    }

    public void setPropDescription(String description) {
        this.description = description;
    }

    public void setPropIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setPropName(String name) {
        this.name = name;
    }

    public void setPropSubTask(boolean subtask) {
        this.subtask = subtask;
    }

    public void setPropAvatarId(long avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueType issueType = (IssueType) o;
        return subtask == issueType.subtask &&
                avatarId == issueType.avatarId &&
                description.equals(issueType.description) &&
                iconUrl.equals(issueType.iconUrl) &&
                name.equals(issueType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, iconUrl, name, subtask, avatarId);
    }
}
