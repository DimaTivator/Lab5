package commands;

public class ExitCommand implements Command {

    public final CommandType type = CommandType.OTHER_COMMANDS;

    @Override
    public void execute() {
        System.out.println("The program will end without saving the data\nWrite \"Y\" to confirm or any other word " +
                "to undo");
        // TODO confirmation of exit
        System.exit(0);
    }
}
