package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class ShowCommand extends Command {

    public ShowCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {

    }
}
