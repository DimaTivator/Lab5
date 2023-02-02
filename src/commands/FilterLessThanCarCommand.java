package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class FilterLessThanCarCommand extends Command {

    public FilterLessThanCarCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {
        CollectionPrinter collectionPrinter = getCollectionPrinter();
        CollectionManager collectionManager = getCollectionManager();
        // TODO parsing args
    }
}
