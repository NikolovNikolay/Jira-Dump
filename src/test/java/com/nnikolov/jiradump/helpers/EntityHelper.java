package com.nnikolov.jiradump.helpers;

import com.nnikolov.jiradump.model.Issue;
import com.nnikolov.jiradump.model.IssuePriority;
import com.nnikolov.jiradump.model.IssueType;

import java.util.Random;

import static com.nnikolov.jiradump.utils.StringUtils.getRandomContentString;

public class EntityHelper {


    public static Object buildEntity(Class<?> type) {

        if (type == Issue.class) {
            return buildIssue();
        } else if (type == IssueType.class) {
            return buildIssueType();
        } else if (type == IssuePriority.class) {
            return buildIssuePriority();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    static Issue buildIssue() {
        Issue issue = new Issue();
        issue.setPropKey(getRandomContentString(5));
        issue.setParamUrl(getRandomContentString(null));
        issue.setParamId(getRandomContentString(null));
        issue.setParamSelf(getRandomContentString(0));
        return issue;
    }

    static IssueType buildIssueType() {
        IssueType issueType = new IssueType();
        issueType.setPropDescription(getRandomContentString(null));
        issueType.setPropName(getRandomContentString(null));
        issueType.setParamId(getRandomContentString(0));
        issueType.setParamSelf(getRandomContentString(null));
        issueType.setPropIconUrl(getRandomContentString(null));
        issueType.setPropSubTask(false);
        issueType.setPropAvatarId(new Random().nextLong());
        return issueType;
    }

    static IssuePriority buildIssuePriority() {
        IssuePriority priority = new IssuePriority();
        priority.setPropIconUrl(getRandomContentString(null));
        priority.setPropName(getRandomContentString(null));
        priority.setParamId(getRandomContentString(0));
        priority.setParamSelf(getRandomContentString(null));
        return priority;
    }
}
