package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.HumanBeing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveLowerCommand extends Command {

    private final HumanBeing humanBeing;

    public RemoveLowerCommand(CollectionManager collectionManager, HumanBeing humanBeing) {
        super(collectionManager);
        this.humanBeing = humanBeing;
    }

    @Override
    public void execute() throws EmptyCollectionException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();

        if (data.isEmpty()) {
            throw new EmptyCollectionException();
        }

        Set<Long> keySet = new HashSet<>();

        data.forEach((key, value) -> {
            if (value.compareTo(humanBeing) < 0) {
                keySet.add(key);
            }
        });

        keySet.forEach(data::remove);
    }
}
