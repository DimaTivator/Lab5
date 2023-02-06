package collectionManagement;

import commands.*;
import storedClasses.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class CollectionPrinter is used to print info about the collection
 */
public class CollectionPrinter {

    private Map<String, String> commands = new LinkedHashMap<>();

    private void setCommands() {
        commands.put("help", "print available commands");
        commands.put("info", "print information about the collection (type, initialization date, number of items, etc.)");
        commands.put("show", "print all items of the collection in (key - value) format");
        commands.put("insert <key> <value>", "add new pair (key, value) to collection");
        commands.put("update <id> <element>", "update the value of a collection item whose id is equal to the specified one");
        commands.put("remove_key <key>", "remove the item with the specified key");
        commands.put("clear", "clear collection");
        commands.put("save", "saves collection to the xml file with the standard name");
        commands.put("save <file_name>", "saves collection to the xml file with the specified name");
        commands.put("execute_script <file_name>", "executes a script from the file with the specified name");
        commands.put("exit", "terminate the program (without saving to a file)");
        commands.put("remove_lower <element>", "remove all items less than the specified one from the collection");
        commands.put("replace_if_greater null <element>", "replace the value by key if the new value is greater than the old one");
        commands.put("remove_greater_key <key>", "remove from the collection all items whose key is greater than the specified one");
        commands.put("count_less_than_impact_speed <impactSpeed>", "print the number of elements whose impactSpeed field value is less than the specified one");
        commands.put("filter_less_than_car <car>", "print elements whose car field value is less than the specified one");
        commands.put("print_unique_mood", "print the unique values of the mood field of all items in the collection");
    }

    public Map<String, String> getCommands() {
        return commands;
    }

    public CollectionPrinter() {
        setCommands();
    }

    /**
     * Method printCollectionInfo prints the collection type, the date of initialization of collection and the number
     * elements in collection
     * @param collectionManager collectionManager
     */
    public void printCollectionInfo(CollectionManager collectionManager) {
        try {
            Command infoCommand = new InfoCommand(collectionManager, this);
            infoCommand.execute();
        } catch (Exception ignored) {}
    }

    /**
     * Method printCollection prints HashMap contents in (key - value) format,
     * where every pair (key - value) is printed on a separate line
     * @param collectionManager collectionManager
     */
    public void printCollection(CollectionManager collectionManager) {
        try {
            Command showCommand = new ShowCommand(collectionManager);
            showCommand.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method printUniqueMood prints the unique values of the mood field of all items in the collection
     * @param collectionManager the collection
     */
    public void printUniqueMood(CollectionManager collectionManager) {
        try {
            Command printUniqueMoodCommand = new PrintUniqueMoodCommand(collectionManager);
            printUniqueMoodCommand.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method counts and prints the number of elements whose impactSpeed field value is less than the specified one
     * @param collectionManager the collection
     * @param impactSpeed impactSpeed
     */
    public void countLessThanImpactSpeed(CollectionManager collectionManager, Double impactSpeed) {
        try {
            Command countLessThanImpactSpeedCommand = new CountLessThanImpactSpeedCommand(collectionManager, impactSpeed);
            countLessThanImpactSpeedCommand.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method counts and prints the number of elements whose car field value is less than the specified one
     * @param collectionManager the collection
     * @param car car
     */
    public void filterLessThanCar(CollectionManager collectionManager, Car car) {
        try {
            Command filterLessThanCarCommand = new FilterLessThanCarCommand(collectionManager, car);
            filterLessThanCarCommand.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveCollectionToFile(CollectionManager collectionManager) {
        try {
            Command saveCollectionToFileCommand = new SaveCollectionToFileCommand(collectionManager);
            saveCollectionToFileCommand.execute();
        } catch (Exception ignored) {}
    }

    public void saveCollectionToFile(CollectionManager collectionManager, String filePath) {
        try {
            Command saveCollectionToFileCommand = new SaveCollectionToFileCommand(collectionManager, filePath);
            saveCollectionToFileCommand.execute();
        } catch (Exception ignored) {}
    }

    /**
     * Method prints the list of available commands
     */
    public void printHelp() {
        try {
            Command helpCommand = new HelpCommand(this);
            helpCommand.execute();
        } catch (Exception ignored) {}
    }
}
