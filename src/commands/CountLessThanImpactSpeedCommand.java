package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.HumanBeing;

import java.util.Map;

public class CountLessThanImpactSpeedCommand extends Command {

    private final Double impactSpeed;

    public CountLessThanImpactSpeedCommand(CollectionManager collectionManager, Double impactSpeed) {
        super(collectionManager);
        this.impactSpeed = impactSpeed;
    }

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
