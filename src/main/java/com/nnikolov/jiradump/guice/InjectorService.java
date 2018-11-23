package com.nnikolov.jiradump.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nnikolov.jiradump.ArgProcessor;
import com.nnikolov.jiradump.NoOutputTypeDefinedException;
import com.nnikolov.jiradump.OutputType;

public class InjectorService {

    private ArgProcessor argumentProcessor;

    public InjectorService(ArgProcessor argumentProcessor) {
        this.argumentProcessor = argumentProcessor;
    }

    public Injector produceInjector() {
        try {
            OutputType outputType = argumentProcessor.resolveOutputType();
            switch (outputType) {
                case JSON:
                    return Guice.createInjector(new JsonIssueDumpModule());
                case XML:
                default:
                    return Guice.createInjector(new XmlIssueDumpModule());
            }
        } catch (NoOutputTypeDefinedException e) {
            System.out.println(e.getMessage());
            System.out.println("Preparing default xml output");
            return Guice.createInjector(new XmlIssueDumpModule());
        }
    }
}
