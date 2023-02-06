package exceptions;

import auxiliaryClasses.ConsoleColors;

public class NoSuchKeyException extends Exception {

    public NoSuchKeyException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}
