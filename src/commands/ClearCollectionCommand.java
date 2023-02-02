package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class ClearCollectionCommand extends Command {

    public ClearCollectionCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {
        CollectionManager collectionManager = getCollectionManager();
        collectionManager.clearCollection();
    }
}
