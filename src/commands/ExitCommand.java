package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import io.consoleIO.ConfirmationReader;

public class ExitCommand extends Command {

    public ExitCommand() {}

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
