package commands;

import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.HumanBeing;

import java.util.Map;

public class ShowCommand extends Command {

    public ShowCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws EmptyCollectionException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();

        if (data.isEmpty()) {
            throw new EmptyCollectionException();
        }

        data.forEach((key, value) -> System.out.println(key + ":\n" + value));
    }
}
