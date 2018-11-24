package com.nnikolov.jiradump.guice;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.env.XmlEnvironmentConfiguration;
import com.nnikolov.jiradump.service.IssuePersistService;
import com.nnikolov.jiradump.service.PersistenceService;
import com.nnikolov.jiradump.utils.IssuePersistenceProgressPrinter;
import com.nnikolov.jiradump.writers.Writer;
import com.nnikolov.jiradump.writers.XmlFileWriter;

/**
 * Guise module for when persisting json files
 */
public class XmlIssueDumpModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EnvironmentConfiguration.class).to(XmlEnvironmentConfiguration.class).asEagerSingleton();
        bind(Writer.class).to(XmlFileWriter.class);
        bind(IssuePersistenceProgressPrinter.class).toInstance(new IssuePersistenceProgressPrinter());
        bind(Gson.class).toInstance(new Gson());
        bind(PersistenceService.class).to(IssuePersistService.class);
    }
}
