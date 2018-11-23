package com.nnikolov.jiradump.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nnikolov.jiradump.ArgProcessor;
import com.nnikolov.jiradump.OutputType;

public class InjectorSerivce {

    private ArgProcessor argumentProcessor;

    public InjectorSerivce(ArgProcessor argumentProcessor) {
        this.argumentProcessor = argumentProcessor;
    }

    public Injector produceInjector() {
        OutputType outputType = argumentProcessor.resolveOutputType();
        if (outputType == OutputType.XML) {
            return Guice.createInjector(new XmlIssueDumpModule());
        } else if (outputType == OutputType.JSON) {
            return Guice.createInjector(new JsonIssueDumpModule());
        } else {
            return null;
        }
    }
}
