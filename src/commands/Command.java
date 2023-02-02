package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public abstract class Command {

    private CollectionManager collectionManager;
    private CollectionPrinter collectionPrinter;

    public Command(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        this.collectionManager = collectionManager;
        this.collectionPrinter = collectionPrinter;
    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public CollectionPrinter getCollectionPrinter() {
        return collectionPrinter;
    }

    public abstract void execute(String[] args);
}
