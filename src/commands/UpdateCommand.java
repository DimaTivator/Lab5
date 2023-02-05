package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class UpdateCommand extends Command {

    public UpdateCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute() {

    }
}
