package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import exceptions.OccupiedKeyException;
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
    public void execute() throws OccupiedKeyException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        if (data.containsKey(key)) {
            throw new OccupiedKeyException("Collection already contains the object with this key!\n" +
                    "Please try to enter another key");
        }
        data.put(key, value);
    }
}
