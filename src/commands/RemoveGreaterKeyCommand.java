package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.HumanBeing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveGreaterKeyCommand extends Command {

    private final Long inputKey;

    public RemoveGreaterKeyCommand(CollectionManager collectionManager, Long inputKey) {
        super(collectionManager);
        this.inputKey = inputKey;
    }

    @Override
    public void execute() throws EmptyCollectionException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();

        if (data.isEmpty()) {
            throw new EmptyCollectionException();
        }

        Set<Long> keySet = new HashSet<>();

        data.forEach((key, value) -> {
            if (key.compareTo(inputKey) > 0) {
                keySet.add(key);
            }
        });

        keySet.forEach(data::remove);
    }
}
