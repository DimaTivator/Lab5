package exceptions;

import auxiliaryClasses.ConsoleColors;

public class ParseException extends Exception {

    public ParseException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}
