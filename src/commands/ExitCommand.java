package commands;

import auxiliaryClasses.ConsoleColors;
import io.consoleIO.ConfirmationReader;

/**
 This class represents the "exit" command in the program
 */
public class ExitCommand extends Command {

    /**
     Constructor for the {@code ExitCommand} class
     */
    public ExitCommand() {}

    /**
     This method overrides the execute method from the {@code Command} class
     Prompts the user for confirmation before exiting the program and terminating the process
     */
    @Override
    public void execute() {
        System.out.println("The program will end without saving the data");
        ConfirmationReader confirmationReader = new ConfirmationReader();
        String confirmation = confirmationReader.readObjectFromConsole();
        if (confirmation.equals("Y")) {
            System.out.println(ConsoleColors.PURPLE + "Bye!" + ConsoleColors.RESET);
            System.exit(0);
        }
    }
}
