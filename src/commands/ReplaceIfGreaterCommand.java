package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

public class ReplaceIfGreaterCommand extends Command {

    private final Long key;
    private final HumanBeing value;

    public ReplaceIfGreaterCommand(CollectionManager collectionManager, Long key, HumanBeing value) {
        super(collectionManager);
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        if (value.compareTo(data.get(key)) > 0) {
            data.put(key, value);
        }
    }
}
