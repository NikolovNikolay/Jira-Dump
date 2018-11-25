package com.nnikolov.jiradump;

import com.nnikolov.jiradump.enums.OutputType;
import com.nnikolov.jiradump.exception.NoOutputTypeDefinedException;

import static com.nnikolov.jiradump.enums.OutputType.JSON;
import static com.nnikolov.jiradump.enums.OutputType.XML;

public class ArgumentProcessor implements ArgProcessor {

    private String[] arguments;

    ArgumentProcessor(String[] arguments) {
        this.arguments = arguments;
    }

    /**
     * Can resolve JSON and XML output type. Else {@link NoOutputTypeDefinedException}
     * is thrown
     *
     * @return first occurrence of and output type
     * @throws NoOutputTypeDefinedException when null or empty arguments list
     *                                      or no output type found
     */
    public OutputType resolveOutputType() throws NoOutputTypeDefinedException {
        if (arguments != null) {
            for (String argument : arguments) {
                if (argument.toUpperCase().equals(JSON.name())) {
                    return JSON;
                } else if (argument.toUpperCase().equals(XML.name())) {
                    return XML;
                }
            }
        }
        throw new NoOutputTypeDefinedException();
    }
}
