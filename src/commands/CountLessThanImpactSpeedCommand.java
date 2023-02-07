package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.HumanBeing;

import java.util.Map;

/**
 * CountLessThanImpactSpeedCommand class is a concrete implementation of the Command abstract class.
 * It counts the number of elements in the collection whose `impactSpeed` is less than the specified `impactSpeed`.
 */
public class CountLessThanImpactSpeedCommand extends Command {

    private final Double impactSpeed;

    /**
     * Constructs a CountLessThanImpactSpeedCommand with the specified CollectionManager and impact speed.
     *
     * @param collectionManager the CollectionManager to be used
     * @param impactSpeed the impact speed to be used as a comparison value
     */
    public CountLessThanImpactSpeedCommand(CollectionManager collectionManager, Double impactSpeed) {
        super(collectionManager);
        this.impactSpeed = impactSpeed;
    }

    /**
     * Executes the command, counting the number of elements in the collection whose `impactSpeed` is less than the specified `impactSpeed`.
     *
     * @throws EmptyCollectionException if the collection is empty
     */
    @Override
    public void execute() throws EmptyCollectionException {
        CollectionManager collectionManager = getCollectionManager();
        Map<Long, HumanBeing> data = collectionManager.getCollection();

        if (data.isEmpty()) {
            throw new EmptyCollectionException();
        }

        int counter = 0;
        for (HumanBeing value : data.values()) {
            if (value.getImpactSpeed() < impactSpeed) {
                counter++;
            }
        }

        System.out.println("The number of objects whose impactSpeed field value is less than the specified one is " +
                ConsoleColors.GREEN + counter + ConsoleColors.RESET);
    }
}
