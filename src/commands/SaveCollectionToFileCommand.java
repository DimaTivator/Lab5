package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class SaveCollectionToFileCommand extends Command {

    public SaveCollectionToFileCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {

    }
}
