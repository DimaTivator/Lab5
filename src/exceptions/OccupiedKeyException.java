package exceptions;

import auxiliaryClasses.ConsoleColors;

public class OccupiedKeyException extends Exception {

    public OccupiedKeyException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}
