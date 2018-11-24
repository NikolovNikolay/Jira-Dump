package com.nnikolov.jiradump.exception;

import static com.nnikolov.jiradump.exception.ExceptionMessages.INJECTOR_SERVICE_ALREADY_INITIALIZED_DEFAULT;

public class InjectorServiceAlreadyInitializedException extends RuntimeException {

    public InjectorServiceAlreadyInitializedException() {
        super(INJECTOR_SERVICE_ALREADY_INITIALIZED_DEFAULT);
    }
}
