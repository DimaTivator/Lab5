package exceptions;

import auxiliaryClasses.ConsoleColors;

public class EmptyCollectionException extends Exception {

    public EmptyCollectionException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }

    public EmptyCollectionException() {
        super(ConsoleColors.RED + "Collection is empty :(" + ConsoleColors.RESET);
    }
}
