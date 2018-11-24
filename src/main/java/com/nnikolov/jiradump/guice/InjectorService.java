package com.nnikolov.jiradump.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;


public interface InjectorService {

    /**
     * Builder method for constructing a Guice injector
     *
     * @return Guice injector
     */
    Injector produceInjector();

    /**
     * Factory method for providing a Guice module
     *
     * @return Guice module
     */
    AbstractModule produceModule();
}
