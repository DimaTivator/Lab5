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
    public void execute() {
        CollectionManager collectionManager = getCollectionManager();
        CollectionPrinter collectionPrinter = getCollectionPrinter();
        Map<String, String> commands = collectionPrinter.getCommands();

        commands.forEach((key, value) -> {
            System.out.print(ConsoleColors.GREEN);
            for (int i = 0; i < key.length(); i++) {
                char letter = key.charAt(i);
                if (letter == '<') {
                    System.out.print(letter + ConsoleColors.PURPLE);
                } else if (letter == '>') {
                    System.out.print(ConsoleColors.GREEN + letter);
                } else {
                    System.out.print(letter);
                }
            }
            System.out.println(ConsoleColors.RESET + ": " + value);
        });
        System.out.println();
    }
}
