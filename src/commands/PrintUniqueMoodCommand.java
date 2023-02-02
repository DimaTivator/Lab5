package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class PrintUniqueMoodCommand extends Command {

    public PrintUniqueMoodCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {

    }
}
