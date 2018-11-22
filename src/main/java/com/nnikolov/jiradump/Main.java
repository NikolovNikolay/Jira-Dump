package com.nnikolov.jiradump;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.guice.XmlIssueDumpModule;
import com.nnikolov.jiradump.model.JiraFilterResult;
import com.nnikolov.jiradump.service.PersistenceService;

import static com.nnikolov.jiradump.ErrorMessages.CODE_3001_INTERRUPT_ISSUES_DUMP_UNEXPECTED;

/**
 * Downloads JIRA issues to json or xml files, depending on
 * user preferences
 */
public class Main {

    public static void main(String[] args) {

        Injector diInjector = Guice.createInjector(new XmlIssueDumpModule());
        PersistenceService persistenceService = diInjector.getInstance(PersistenceService.class);
        EnvironmentConfiguration env = diInjector.getInstance(EnvironmentConfiguration.class);

        JiraFilterResult filterResult;
        try {
            System.out.println("Fetching initial page of filtered issues...");
            filterResult = persistenceService.getAsEntity(JiraFilterResult.class, env.getIssueTypeFilteredIssuesUrl());
            System.out.println(filterResult.getTotal() + " issues fetched from cloud server");
        } catch (Exception e) {
            System.out.println(CODE_3001_INTERRUPT_ISSUES_DUMP_UNEXPECTED);
            e.printStackTrace();
            return;
        }
        persistenceService.persistEntities(filterResult);
    }
}
