package com.nnikolov.jiradump;

import static com.nnikolov.jiradump.OutputType.JSON;
import static com.nnikolov.jiradump.OutputType.XML;

public class ArgumentProcessor implements ArgProcessor {

    private String[] arguments;

    public ArgumentProcessor(String[] arguments) {
        this.arguments = arguments;
    }

    public OutputType resolveOutputType() throws NoOutputTypeDefinedException {
        if (arguments != null) {
            for (String argument : arguments) {
                if (argument.toUpperCase().equals(JSON.name())) {
                    return JSON;
                }
                if (argument.toUpperCase().equals(XML.name())) {
                    return XML;
                }
            }
        }
        throw new NoOutputTypeDefinedException();
    }
}
