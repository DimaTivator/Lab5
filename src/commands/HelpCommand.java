package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

import java.util.Map;

public class HelpCommand extends Command {

    public HelpCommand(CollectionPrinter collectionPrinter) {
        super(collectionPrinter);
    }

    @Override
    public void execute(String[] args) {
        CollectionManager collectionManager = getCollectionManager();
        CollectionPrinter collectionPrinter = getCollectionPrinter();
        Map<String, String> commands = collectionPrinter.getCommands();
        commands.forEach((key, value) -> {
            System.out.println(ConsoleColors.GREEN + key + ConsoleColors.RESET + ": " + value);
        });
    }
}
