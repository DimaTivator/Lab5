package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.Car;
import storedClasses.HumanBeing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterLessThanCarCommand extends Command {

    private final Car car;

    public FilterLessThanCarCommand(CollectionManager collectionManager, Car car) {
        super(collectionManager);
        this.car = car;
    }

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
