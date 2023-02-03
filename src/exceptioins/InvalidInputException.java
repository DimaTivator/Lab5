package exceptioins;

import auxiliaryClasses.ConsoleColors;

public class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}
