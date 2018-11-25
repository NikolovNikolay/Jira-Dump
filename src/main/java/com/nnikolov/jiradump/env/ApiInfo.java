package com.nnikolov.jiradump.env;

/**
 * Provides API resource endpoint addresses
 */
public interface ApiInfo {

    /**
     * @return Atlassian latest public issue tracking server address
     */
    String getLatestApiUrl();

    /**
     * Filters issues from public JIRA with default pagination configuration
     *
     * @return get address string
     */
    String getFilteredIssuesUrl();

    /**
     * Filters issues from public JIRA with default pagination configuration
     * with custom pagination settings
     *
     * @param startAt    start index for start of page
     * @param maxResults maximum results per page
     * @return get address url string
     */
    String getFilteredIssuesUrl(int startAt, int maxResults);

    /**
     * @return browsing base address
     */
    String getWebBrowseBaseUrl();
}
