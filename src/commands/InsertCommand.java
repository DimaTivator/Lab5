package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

/**
 * InsertCommand is a class that extends the Command class and provides an implementation for
 * inserting an element into the collection.
 */
public class InsertCommand extends Command {

    /**
     * The key of the element that needs to be inserted
     */
    private final Long key;

    /*
     * The value of the element that needs to be inserted
     */
    private final HumanBeing value;

    /**
     * Constructor for the InsertCommand class
     *
     * @param collectionManager the CollectionManager instance to get the collection from
     * @param key the key of the element to be inserted
     * @param value the value of the element to be inserted
     */
    public InsertCommand(CollectionManager collectionManager, Long key, HumanBeing value) {
        super(collectionManager);
        this.key = key;
        this.value = value;
    }

    /**
     * The method overrides the execute method from the Command class and provides an implementation
     * to insert the element into the collection.
     */
    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.put(key, value);
    }
}
