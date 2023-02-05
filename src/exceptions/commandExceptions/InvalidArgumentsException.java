package exceptions.commandExceptions;

import auxiliaryClasses.ConsoleColors;

public class InvalidArgumentsException extends Exception {

    public InvalidArgumentsException() {
        super(ConsoleColors.RED + "Something wrong with command arguments :(\nPlease try to enter a command again" + ConsoleColors.RESET);
    }

    public InvalidArgumentsException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}
