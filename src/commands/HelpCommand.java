package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class HelpCommand extends Command {

    public HelpCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {
        CollectionPrinter collectionPrinter = getCollectionPrinter();
        collectionPrinter.printHelp();
    }
}
