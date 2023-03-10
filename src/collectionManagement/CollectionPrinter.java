package collectionManagement;

import commands.*;
import storedClasses.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 The CollectionPrinter class is responsible for printing information about the collection and its elements.
 It contains a map of available commands and their descriptions, and methods for printing collection information,
 unique mood values, elements with impact speed less than a specified value, elements with car less than a specified value,
 saving collection to file, and printing help information.
 */
public class CollectionPrinter {

    /**
     * A map of available commands and their descriptions.
     */
    private Map<String, String> commands = new LinkedHashMap<>();

    /**
     * Fills the commands map with available commands and their descriptions.
     */
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

    /**
     * Returns the map of available commands and their descriptions.
     *
     * @return the map of available commands and their descriptions
     */
    public Map<String, String> getCommands() {
        return commands;
    }

    /**
     * Constructor that calls setCommands method.
     */
    public CollectionPrinter() {
        setCommands();
    }

    /**
     * Prints information about the collection: type of collection, date of initialization and th number of objects in it
     */
//    public void printCollectionInfo(CollectionManager collectionManager) {
//        try {
//            CommandTemplate infoCommand = new InfoCommand(collectionManager, this);
//            infoCommand.execute();
//        } catch (Exception ignored) {}
//    }

    /**
     * Method prints the collection managed by the {@code collectionManager} object.
     * @param collectionManager the collection manager that manages the collection to print the unique moods of the elements
     */
//    public void printCollection(CollectionManager collectionManager) {
//        try {
//            CommandTemplate showCommand = new ShowCommand(collectionManager);
//            showCommand.execute();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /**
//     * The {@code printUniqueMood} method prints the unique moods of the elements in the collection managed by the
//     * {@code collectionManager} object.
//     * @param collectionManager the collection manager that manages the collection to print the unique moods of the elements
//     */
//    public void printUniqueMood(CollectionManager collectionManager) {
//        try {
//            CommandTemplate printUniqueMoodCommand = new PrintUniqueMoodCommand(collectionManager);
//            printUniqueMoodCommand.execute();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /**
//     * The {@code countLessThanImpactSpeed} method counts the number of elements in the collection managed by the
//     * {@code collectionManager} object that have impact speed less than the specified {@code impactSpeed}.
//     * @param collectionManager the collection manager that manages the collection to count the number of elements with impact speed less than the specified value
//     * @param impactSpeed the maximum impact speed to consider when counting elements
//     */
//    public void countLessThanImpactSpeed(CollectionManager collectionManager, Double impactSpeed) {
//        try {
//            CommandTemplate countLessThanImpactSpeedCommand = new CountLessThanImpactSpeedCommand(collectionManager, impactSpeed);
//            countLessThanImpactSpeedCommand.execute();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /**
//     * The {@code filterLessThanCar} method filters the elements in the collection managed by the
//     * {@code collectionManager} object that have specifications less than those of the specified {@code car}.
//     * @param collectionManager the collection manager that manages the collection to filter the elements with specifications less than those of the specified car
//     * @param car the car whose specifications will be used as a comparison to filter the elements in the collection
//     */
//    public void filterLessThanCar(CollectionManager collectionManager, Car car) {
//        try {
//            CommandTemplate filterLessThanCarCommand = new FilterLessThanCarCommand(collectionManager, car);
//            filterLessThanCarCommand.execute();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /**
//     Saves the current collection to a file using the default file path.
//     @param collectionManager the {@link CollectionManager} instance to use for saving the collection
//     */
//    public void saveCollectionToFile(CollectionManager collectionManager) {
//        try {
//            CommandTemplate saveCollectionToFileCommand = new SaveCollectionToFileCommand(collectionManager);
//            saveCollectionToFileCommand.execute();
//        } catch (Exception ignored) {}
//    }
//
//    /**
//     Saves the current collection to a file using the specified file path.
//     @param collectionManager the {@link CollectionManager} instance to use for saving the collection
//     @param filePath the file path to save the collection to
//     */
//    public void saveCollectionToFile(CollectionManager collectionManager, String filePath) {
//        try {
//            CommandTemplate saveCollectionToFileCommand = new SaveCollectionToFileCommand(collectionManager, filePath);
//            saveCollectionToFileCommand.execute();
//        } catch (Exception ignored) {}
//    }
//
//    /**
//     Prints the help message for the program.
//     */
//    public void printHelp() {
//        try {
//            CommandTemplate helpCommand = new HelpCommand(this);
//            helpCommand.execute();
//        } catch (Exception ignored) {}
//    }
}
