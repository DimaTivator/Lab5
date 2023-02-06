package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

public class ClearCollectionCommand extends Command {

    public ClearCollectionCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.clear();
    }
}
