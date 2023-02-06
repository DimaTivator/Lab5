package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

public class InsertCommand extends Command {

    private final Long key;
    private final HumanBeing value;

    public InsertCommand(CollectionManager collectionManager, Long key, HumanBeing value) {
        super(collectionManager);
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.put(key, value);
    }
}
