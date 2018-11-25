package com.nnikolov.jiradump.guice;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.env.JsonEnvironmentConfiguration;
import com.nnikolov.jiradump.service.IssuePersistService;
import com.nnikolov.jiradump.service.PersistenceService;
import com.nnikolov.jiradump.utils.IssuePersistenceProgressPrinter;
import com.nnikolov.jiradump.writers.JsonFileWriter;
import com.nnikolov.jiradump.writers.Writer;

/**
 * Guise module with components required for persisting json files
 */
public class JsonIssueDumpModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EnvironmentConfiguration.class).to(JsonEnvironmentConfiguration.class).asEagerSingleton();
        bind(Writer.class).to(JsonFileWriter.class);
        bind(IssuePersistenceProgressPrinter.class).toInstance(new IssuePersistenceProgressPrinter());
        bind(Gson.class).toInstance(new Gson());
        bind(PersistenceService.class).to(IssuePersistService.class);
    }
}
