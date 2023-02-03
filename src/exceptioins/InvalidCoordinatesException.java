package exceptioins;

import auxiliaryClasses.ConsoleColors;

public class InvalidCoordinatesException extends RuntimeException {

    public InvalidCoordinatesException() {
        super(ConsoleColors.RED + "x coordinate must be < 487 and y coordinate must be > -704" + ConsoleColors.RESET);
    }
}
