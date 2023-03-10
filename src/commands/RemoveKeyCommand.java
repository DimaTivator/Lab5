package commands;

import collectionManagement.CollectionManager;
import exceptions.commandExceptions.InvalidArgumentsException;
import storedClasses.HumanBeing;

import java.util.Map;

/**
 * The RemoveKeyCommand class extends the Command class.
 * This class is used to remove a key-value pair from the collection using a specified key.
 */
public class RemoveKeyCommand extends CommandTemplate {

    /**
     * Constructs a RemoveKeyCommand object with a CollectionManager object and a key.
     *
     * @param collectionManager The CollectionManager object that the command operates on.
     */
    public RemoveKeyCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void setArg(String arg) throws InvalidArgumentsException {
        try {
            Long key = Long.parseLong(arg);
            super.setArg(String.valueOf(key));
        } catch (NumberFormatException e) {
            throw new InvalidArgumentsException("The key must be a number! Please Try to enter a command again");
        }
    }

    /**
     * Removes a key-value pair from the collection using the specified key.
     */
    @Override
    public void execute() {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();
        data.remove(Long.parseLong(getArg()));
    }
}

