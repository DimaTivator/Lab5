package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import collectionManagement.CommandsExecutor;
import collectionManagement.ScriptExecutor;

/**
 Class that executes the commands from a script file.
 */
public class ExecuteScriptCommand extends Command {

    /**
     The path to the script file.
     */
    private final String filePath;

    private CommandsExecutor commandsExecutor;

    /**
     Constructor with collection manager, collection printer, and file path arguments.
     @param collectionManager Collection manager that holds the collection.
     @param collectionPrinter Collection printer for printing collection information.
     @param filePath The path to the script file.
     */
    public ExecuteScriptCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter, CommandsExecutor commandsExecutor, String filePath) {
        super(collectionManager, collectionPrinter);
        this.filePath = filePath;
        this.commandsExecutor = commandsExecutor;
    }

    /**
     Executes the script commands from the file.
     @throws Exception If there are any errors while executing the script.
     */
    @Override
    public void execute() throws Exception {
        ScriptExecutor scriptExecutor = new ScriptExecutor(getCollectionManager(), getCollectionPrinter());
        scriptExecutor.executeScript(filePath, commandsExecutor);
    }
}
