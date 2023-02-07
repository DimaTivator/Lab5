package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

/**
 * The ReplaceIfGreaterCommand class extends the Command class.
 * This class is used to replace the value in the collection associated with a specified key with the specified value
 * if the value is greater than the current value.
 */
public class ReplaceIfGreaterCommand extends Command {

    /**
     * The key of the key-value pair to be replaced.
     */
    private final Long key;
    /**
     * The value to be replaced with.
     */
    private final HumanBeing value;

    /**
     * Constructs a ReplaceIfGreaterCommand object with a CollectionManager object, a key, and a value.
     *
     * @param collectionManager The CollectionManager object that the command operates on.
     * @param key The key of the key-value pair to be replaced.
     * @param value The value to be replaced with.
     */
    public ReplaceIfGreaterCommand(CollectionManager collectionManager, Long key, HumanBeing value) {
        super(collectionManager);
        this.key = key;
        this.value = value;
    }

    /**
     * Replaces the value in the collection associated with the specified key with the specified value
     * if the value is greater than the current value.
     */
    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        if (value.compareTo(data.get(key)) > 0) {
            data.put(key, value);
        }
    }
}

