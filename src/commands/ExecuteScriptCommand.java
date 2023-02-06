package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import io.fileIO.in.ScriptExecutor;


public class ExecuteScriptCommand extends Command {

    private final String filePath;

    public ExecuteScriptCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter, String filePath) {
        super(collectionManager, collectionPrinter);
        this.filePath = filePath;
    }

    @Override
    public void execute() throws Exception {
        ScriptExecutor scriptExecutor = new ScriptExecutor(getCollectionManager(), getCollectionPrinter());
        scriptExecutor.executeScript(filePath);
    }
}
