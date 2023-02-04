package commands;

import collectionManagement.CollectionManager;
import storedClasses.HumanBeing;

import java.util.Map;

public class ShowCommand extends Command {

    public ShowCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(String[] args) {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.forEach((key, value) -> System.out.println(key + ":\n" + value));
    }
}
