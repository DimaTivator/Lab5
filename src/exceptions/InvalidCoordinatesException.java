package exceptions;

import auxiliaryClasses.ConsoleColors;

public class InvalidCoordinatesException extends Exception {

    public InvalidCoordinatesException() {
        super(ConsoleColors.RED + "x coordinate must be < 487 and y coordinate must be > -704\n" + ConsoleColors.RESET);
    }

    public InvalidCoordinatesException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}
