package commands;

import auxiliaryClasses.ConsoleColors;
import collectionManagement.CollectionManager;
import exceptions.EmptyCollectionException;
import storedClasses.HumanBeing;
import storedClasses.Mood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintUniqueMoodCommand extends Command {

    public PrintUniqueMoodCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws EmptyCollectionException {
        Map<Long, HumanBeing> data = getCollectionManager().getCollection();

        if (data.isEmpty()) {
            throw new EmptyCollectionException();
        }

        Map<Mood, Integer> moodsCounter = new HashMap<>();

        data.forEach((key, value) -> {
            if (moodsCounter.containsKey(value.getMood())) {
                moodsCounter.put(value.getMood(), moodsCounter.get(value.getMood()) + 1);
            } else {
                moodsCounter.put(value.getMood(), 1);
            }
        });

        List<Mood> uniqueMoodList = new ArrayList<>();

        moodsCounter.forEach((key, value) -> {
            if (value == 1) {
                uniqueMoodList.add(key);
            }
        });

        if (uniqueMoodList.isEmpty()) {
            System.out.println("There is no unique moods in collection :(");
        } else {
            System.out.println(ConsoleColors.GREEN + "The list of unique moods of HumanBeing objects from the collection: " + ConsoleColors.RESET);
            uniqueMoodList.forEach(System.out::println);
        }
    }
}
