package com.nnikolov.jiradump.env;

/**
 * Provides API resource endpoint addresses
 */
public interface ApiInfoHolder {

    /**
     * @return JIRA latest api base address
     */
    String getLatestApiUrl();

    /**
     * filtered public issues from JIRA with default pagination configuration
     *
     * @return get address string
     */
    String getIssueTypeFilteredIssuesUrl();

    /**
     * Returns paginated public issues result
     *
     * @param startAt    start index for start of page
     * @param maxResults maximum results per page
     * @return get address string
     */
    String getIssueTypeFilteredIssuesUrl(int startAt, int maxResults);

    /**
     * @return base web issue browse address
     */
    String getWebBrowseBaseUrl();
}
