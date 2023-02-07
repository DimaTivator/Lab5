package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

/**
 * The RemoveKeyCommand class extends the Command class.
 * This class is used to remove a key-value pair from the collection using a specified key.
 */
public class RemoveKeyCommand extends Command {

    /**
     * The key of the key-value pair to be removed from the collection.
     */
    private final Long key;

    /**
     * Constructs a RemoveKeyCommand object with a CollectionManager object and a key.
     *
     * @param collectionManager The CollectionManager object that the command operates on.
     * @param key The key of the key-value pair to be removed from the collection.
     */
    public RemoveKeyCommand(CollectionManager collectionManager, Long key) {
        super(collectionManager);
        this.key = key;
    }

    /**
     * Removes a key-value pair from the collection using the specified key.
     */
    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.remove(key);
    }
}

