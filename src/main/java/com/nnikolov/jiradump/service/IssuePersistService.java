package com.nnikolov.jiradump.service;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.model.Issue;
import com.nnikolov.jiradump.model.IssueMeta;
import com.nnikolov.jiradump.model.JiraFilterResult;
import com.nnikolov.jiradump.utils.IssuePersistenceProgressPrinter;
import com.nnikolov.jiradump.writers.Writer;

import static com.nnikolov.jiradump.exception.ExceptionMessages.*;

/**
 * Takes care of fetching issues and persisting them in files.
 */
public class IssuePersistService implements PersistenceService {

    private EnvironmentConfiguration env;
    private Writer writer;
    private IssuePersistenceProgressPrinter printer;
    private Gson gson;

    @Inject
    public IssuePersistService(
            EnvironmentConfiguration environmentConfiguration,
            Writer writer,
            IssuePersistenceProgressPrinter printer,
            Gson gson) {
        this.env = environmentConfiguration;
        this.writer = writer;
        this.printer = printer;
        this.gson = gson;
        System.out.println("Initializing issue persistence service");
    }

    @Override
    public <T> T getAsEntity(Class<T> clazz, String url) throws UnirestException {
        HttpResponse<String> response = Unirest.get(url).asString();
        return gson.fromJson(response.getBody(), clazz);
    }

    @Override
    public void persistEntities(JiraFilterResult filterResult) {
        printer.printStart();
        int totalSaved = 0;
        boolean hasMoreToSave = true;
        int total = filterResult.getTotal();
        int maxResult;
        int startAt;

        while (hasMoreToSave) {
            total = filterResult.getTotal();
            maxResult = filterResult.getMaxResults();
            startAt = filterResult.getStartAt() + filterResult.getMaxResults();

            for (IssueMeta issueMeta : filterResult.getIssues()) {
                try {
                    Issue issue = getAsEntity(Issue.class, issueMeta.getSelf());
                    issue.buildUrl(env.getWebBrowseBaseUrl());
                    writer.write(issue.getKey(), Issue.class, issue);
                    totalSaved++;
                    printer.printProgress(totalSaved, total);
                } catch (UnirestException e) {
                    System.out.println(CODE_3002_FETCH_ISSUE_CALL_FAILED);
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println(CODE_3004_PARSE_ISSUE_FAILED);
                    e.printStackTrace();
                }
            }
            startAt += maxResult;

            if (totalSaved >= filterResult.getTotal()) {
                hasMoreToSave = false;
            } else {
                try {
                    printer.printNextPage();
                    filterResult = getAsEntity(JiraFilterResult.class, env.getFilteredIssuesUrl(startAt, maxResult));
                } catch (UnirestException e) {
                    System.out.println(CODE_3003_FETCH_ISSUE_CALL_FAILED);
                    e.printStackTrace();
                    break;
                }
            }
        }

        if (!hasMoreToSave) {
            printer.printDone();
        } else {
            printer.printDoneWithComment(totalSaved, total);
        }
    }
}
