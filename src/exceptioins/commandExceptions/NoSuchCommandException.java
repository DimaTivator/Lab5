package exceptioins.commandExceptions;

/**
 * Exception NoSuchCommandException is thrown when CommandExecutor can't find a parsed command in the command list
 */
public class NoSuchCommandException extends RuntimeException {

    public NoSuchCommandException() {
        super("I don't have such command yet :(\nPlease try to enter a command again");
    }

    public NoSuchCommandException(String message) {
        super(message);
    }
}
