package com.nnikolov.jiradump;

import com.google.inject.Injector;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.guice.InjectorService;
import com.nnikolov.jiradump.guice.InjectorServiceImpl;
import com.nnikolov.jiradump.model.JiraFilterResult;
import com.nnikolov.jiradump.service.PersistenceService;

import static com.nnikolov.jiradump.exception.ExceptionMessages.CODE_3001_INTERRUPT_ISSUES_DUMP_UNEXPECTED;

/**
 * Initializes application components and initiates download
 * of the available jira issues
 */
public class Main {

    public static void main(String[] args) {

        ArgProcessor argumentProcessor = new ArgumentProcessor(args);
        InjectorService injectorService = InjectorServiceImpl.initAndGetInstance(argumentProcessor);
        Injector diInjector = injectorService.produceInjector();

        PersistenceService persistenceService = diInjector.getInstance(PersistenceService.class);
        EnvironmentConfiguration env = diInjector.getInstance(EnvironmentConfiguration.class);

        JiraFilterResult filterResult;
        try {
            System.out.println("Fetching initial page of filtered issues...");
            filterResult = persistenceService.getAsEntity(JiraFilterResult.class, env.getFilteredIssuesUrl());
            System.out.println(filterResult.getTotal() + " issues fetched from cloud server");
        } catch (Exception e) {
            System.out.println(CODE_3001_INTERRUPT_ISSUES_DUMP_UNEXPECTED);
            e.printStackTrace();
            return;
        }
        persistenceService.persistEntities(filterResult);
    }
}
