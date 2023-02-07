package commands;

import collectionManagement.CollectionManager;
import exceptions.NoSuchKeyException;
import storedClasses.HumanBeing;

import java.util.Map;

/**
 The UpdateCommand class updates the value of an existing key in the collection.
 */
public class UpdateCommand extends Command {

    /**
     * The key to update the value of.
     */
    private final Long key;

    /**
     * The new value to set for the key.
     */
    private final HumanBeing newValue;
    /**
     * Constructs a new UpdateCommand instance.
     * @param collectionManager The CollectionManager to execute the command on.
     * @param key The key to update the value of.
     * @param newValue The new value to set for the key.
     */
    public UpdateCommand(CollectionManager collectionManager, Long key, HumanBeing newValue) {
        super(collectionManager);
        this.key = key;
        this.newValue = newValue;
    }
    /**
     * Executes the UpdateCommand. This method updates the value of an existing key in the collection.
     * @throws NoSuchKeyException If the specified key does not exist in the collection.
     */
    @Override
    public void execute() throws NoSuchKeyException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.put(key, newValue);
    }
}
