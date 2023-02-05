package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class InfoCommand extends Command {

    public InfoCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute() {

        CollectionManager collectionManager = getCollectionManager();

        System.out.println(ConsoleColors.GREEN + "Collection type: " + ConsoleColors.RESET +
                collectionManager.getCollection().getClass());

        System.out.println(ConsoleColors.GREEN + "Date of initialization: " + ConsoleColors.RESET +
                collectionManager.getCreationDate());

        System.out.println(ConsoleColors.GREEN + "Number of elements in collection: " + ConsoleColors.RESET +
                collectionManager.getCollection().size());

        System.out.println();
    }
}
