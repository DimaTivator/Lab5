package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {

    }
}
