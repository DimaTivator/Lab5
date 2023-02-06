package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

public class RemoveKeyCommmand extends Command {

    private final Long key;

    public RemoveKeyCommmand(CollectionManager collectionManager, Long key) {
        super(collectionManager);
        this.key = key;
    }

    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.remove(key);
    }
}
