package exceptioins.commandExceptions;

import auxiliaryClasses.ConsoleColors;

/**
 * Exception NoSuchCommandException is thrown when CommandExecutor can't find a parsed command in the command list
 */
public class NoSuchCommandException extends Exception {

    public NoSuchCommandException() {
        super(ConsoleColors.RED + "I don't have such command yet :(\nPlease try to enter a command again" + ConsoleColors.RESET);
    }

    public NoSuchCommandException(String message) {
        super(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
}
