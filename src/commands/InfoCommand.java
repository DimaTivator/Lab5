package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class InfoCommand extends Command {

    public InfoCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {

    }
}
