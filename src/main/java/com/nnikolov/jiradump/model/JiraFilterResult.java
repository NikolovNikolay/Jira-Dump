package com.nnikolov.jiradump.model;

import java.util.List;

/**
 * Result from a JIRA's issue search.
 */
public class JiraFilterResult {

    private int total;
    private int startAt;
    private int maxResults;
    private List<IssueMeta> issues;

    public JiraFilterResult() {
    }

    /**
     * @return all issues that meet the search criteria
     */
    public int getTotal() {
        return total;
    }

    /**
     * JIRA search API offers pagination by default. By default start index is 0.
     *
     * @return the start index of the result set.
     */
    public int getStartAt() {
        return startAt;
    }

    /**
     * JIRA search API offers pagination by default. By default maximum result size is 50.
     *
     * @return the maximum amount of result issues per page
     */
    public int getMaxResults() {
        return maxResults;
    }

    /**
     * @return meta-information about issues
     */
    public List<IssueMeta> getIssues() {
        return issues;
    }
}
