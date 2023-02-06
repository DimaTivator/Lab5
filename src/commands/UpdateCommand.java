package commands;

import collectionManagement.CollectionManager;
import exceptions.NoSuchKeyException;
import storedClasses.HumanBeing;

import java.util.Map;

public class UpdateCommand extends Command {

    private final Long key;
    private final HumanBeing newValue;

    public UpdateCommand(CollectionManager collectionManager, Long key, HumanBeing newValue) {
        super(collectionManager);
        this.key = key;
        this.newValue = newValue;
    }

    @Override
    public void execute() throws NoSuchKeyException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.put(key, newValue);
    }
}
