package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.HumanBeing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The RemoveGreaterKeyCommand class extends the Command class.
 * This class is used to remove all key-value pairs in the collection where the key is greater than the input key.
 */
public class RemoveGreaterKeyCommand extends Command {

    /**
     * The input key to compare with the keys in the collection.
     */
    private final Long inputKey;

    /**
     * Constructs a RemoveGreaterKeyCommand object with a CollectionManager object and an input key.
     *
     * @param collectionManager The CollectionManager object that the command operates on.
     * @param inputKey The input key to compare with the keys in the collection.
     */
    public RemoveGreaterKeyCommand(CollectionManager collectionManager, Long inputKey) {
        super(collectionManager);
        this.inputKey = inputKey;
    }

    /**
     * Removes all key-value pairs in the collection where the key is greater than the input key.
     * Throws an EmptyCollectionException if the collection is empty.
     *
     * @throws EmptyCollectionException If the collection is empty.
     */
    @Override
    public void execute() throws EmptyCollectionException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();

        if (data.isEmpty()) {
            throw new EmptyCollectionException();
        }

        /*
         * A set to store the keys that are greater than the input key.
         */
        Set<Long> keySet = new HashSet<>();

        data.forEach((key, value) -> {
            if (key.compareTo(inputKey) > 0) {
                keySet.add(key);
            }
        });

        keySet.forEach(data::remove);
    }
}

