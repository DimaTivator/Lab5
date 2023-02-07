package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.Car;
import storedClasses.HumanBeing;

import java.util.Map;

/**
 * The FilterLessThanCarCommand class implements a command to filter the elements of the collection
 * whose car field value is less than the specified one.
 */
public class FilterLessThanCarCommand extends Command {

    /**
     The car to be compared with.
     */
    private final Car car;

    /**
     * Creates a new instance of the FilterLessThanCarCommand class.
     * @param collectionManager the CollectionManager instance to manage the collection.
     * @param car the car to be compared with.
     */
    public FilterLessThanCarCommand(CollectionManager collectionManager, Car car) {
        super(collectionManager);
        this.car = car;
    }

    /**
     * Executes the command to filter the elements of the collection
     * whose car field value is less than the specified one.
     * @throws EmptyCollectionException if the collection is empty.
     */
    @Override
    public void execute() throws EmptyCollectionException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();

        if (data.isEmpty()) {
            throw new EmptyCollectionException();
        }

        boolean found = false;
        for (HumanBeing value : data.values()) {
            if (value.getCar().compareTo(car) < 0) {
                System.out.println(value.getCar());
                found = true;
            }
        }

        if (!found) {
            System.out.println(ConsoleColors.RED +
                    "There are no objects whose car field value is less than the specified one" + ConsoleColors.RESET);
        }
    }
}
