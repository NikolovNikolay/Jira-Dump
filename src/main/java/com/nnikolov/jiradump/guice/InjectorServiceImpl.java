package com.nnikolov.jiradump.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nnikolov.jiradump.ArgProcessor;
import com.nnikolov.jiradump.enums.OutputType;
import com.nnikolov.jiradump.exception.InjectorServiceAlreadyInitializedException;
import com.nnikolov.jiradump.exception.NoOutputTypeDefinedException;

/**
 * Wrapper over Guice injector that manages and produces
 * Guice components
 */
public class InjectorServiceImpl implements InjectorService {

    private static InjectorService instance;

    public static InjectorService getInstance() {
        return instance;
    }

    public static InjectorService initAndGetInstance(ArgProcessor argumentProcessor) {
        if (instance != null) {
            throw new InjectorServiceAlreadyInitializedException();
        }
        instance = new InjectorServiceImpl(argumentProcessor);
        return instance;
    }

    private ArgProcessor argumentProcessor;

    private InjectorServiceImpl(ArgProcessor argumentProcessor) {
        this.argumentProcessor = argumentProcessor;
    }

    public Injector produceInjector() {

        AbstractModule module = produceModule();
        if (module == null) {
            return null;
        }

        return Guice.createInjector(module);
    }

    public AbstractModule produceModule() {
        try {
            OutputType outputType = argumentProcessor.resolveOutputType();
            switch (outputType) {
                case XML:
                    return new XmlIssueDumpModule();
                case JSON:
                default:
                    return new JsonIssueDumpModule();
            }
        } catch (NoOutputTypeDefinedException e) {
            System.out.println(e.getMessage());
            System.out.println("Preparing default json output");
            return new JsonIssueDumpModule();
        } catch (NullPointerException e) {
            System.out.println("Injector service module could not be initialized due to null ArgProcessor.");
            throw e;
        }
    }
}
