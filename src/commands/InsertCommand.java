package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class InsertCommand extends Command {

    public InsertCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {

    }
}
