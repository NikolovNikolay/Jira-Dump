package com.nnikolov.jiradump.helpers;

import com.nnikolov.jiradump.model.Issue;
import com.nnikolov.jiradump.model.IssuePriority;
import com.nnikolov.jiradump.model.IssueType;

import java.util.Random;

import static com.nnikolov.jiradump.utils.StringUtils.getRandomLengthString;
import static com.nnikolov.jiradump.utils.StringUtils.getSafeString;

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
        issue.setPropKey(getSafeString(5));
        issue.setParamUrl(getRandomLengthString());
        issue.setParamId(getRandomLengthString());
        issue.setParamSelf(getRandomLengthString());
        return issue;
    }

    static IssueType buildIssueType() {
        IssueType issueType = new IssueType();
        issueType.setPropDescription(getRandomLengthString());
        issueType.setPropName(getRandomLengthString());
        issueType.setParamId(getRandomLengthString());
        issueType.setParamSelf(getRandomLengthString());
        issueType.setPropIconUrl(getRandomLengthString());
        issueType.setPropSubTask(false);
        issueType.setPropAvatarId(new Random().nextLong());
        return issueType;
    }

    static IssuePriority buildIssuePriority() {
        IssuePriority priority = new IssuePriority();
        priority.setPropIconUrl(getRandomLengthString());
        priority.setPropName(getRandomLengthString());
        priority.setParamId(getRandomLengthString());
        priority.setParamSelf(getRandomLengthString());
        return priority;
    }
}
