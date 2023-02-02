package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;

public class ExitCommand extends Command {

    public ExitCommand(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        super(collectionManager, collectionPrinter);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("The program will end without saving the data\nWrite \"Y\" to confirm or any other word " +
                "to undo");
        // TODO confirmation of exit
        System.exit(0);
    }
}
