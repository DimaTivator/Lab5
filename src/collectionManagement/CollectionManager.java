package collectionManagement;

import commands.*;
import storedClasses.HumanBeing;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * CollectionManager is a class that stores a collection of {@link storedClasses.HumanBeing} objects.
 * The class is responsible for managing the collection, adding, updating, removing and replacing elements.
 * It also provides methods for removing elements by key, removing elements with a greater key, and clearing the collection.
 * The class is designed to use the command pattern to execute actions on the collection.
 */

public class CollectionManager {

    /**
     * The creation date of the collection.
     */
    private final java.time.LocalDate creationDate;

    /**
     * The collection of {@link storedClasses.HumanBeing} objects.
     */
    private Map<Long, HumanBeing> data = new LinkedHashMap<>();

    /**
     * Constructs a new CollectionManager and sets the creation date to the current date.
     */
    public CollectionManager() {
        creationDate = java.time.LocalDate.now();
    }

    /**
     * Gets the creation date of the collection.
     *
     * @return the creation date of the collection.
     */
    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Gets the collection of {@link storedClasses.HumanBeing} objects.
     *
     * @return the collection of {@link storedClasses.HumanBeing} objects.
     */
    public Map<Long, HumanBeing> getCollection() {
        return data;
    }

    /**
     * Sets the collection of {@link storedClasses.HumanBeing} objects.
     *
     * @param collection the collection to set.
     */
    public void setCollection(LinkedHashMap<Long, HumanBeing> collection) {
        data = collection;
    }

    /**
     * Inserts a {@link storedClasses.HumanBeing} object into the collection with the specified key.
     *
     * @param key the key to use for the insertion.
     * @param value the {@link storedClasses.HumanBeing} object to insert.
     */
//    public void insertElement(Long key, HumanBeing value) {
//        try {
//            CommandTemplate insertCommand = new InsertCommand(this, key, value);
//            insertCommand.execute();
//        } catch (Exception ignored) {}
//    }
//
//    /**
//     * Updates the value in the collection for the specified key.
//     *
//     * @param id the id to use for the update.
//     * @param newValue the new {@link storedClasses.HumanBeing} object to update.
//     */
//    public void updateValueById(Long id, HumanBeing newValue) {
//        try {
//            CommandTemplate updateCommand = new UpdateCommand(this, id, newValue);
//            updateCommand.execute();
//        } catch (Exception ignored) {}
//    }
//
//    /**
//     * Removes the value from the collection for the specified key.
//     *
//     * @param key the key to use for the removal.
//     */
//    public void removeByKey(Long key) {
//        try {
//            CommandTemplate removeKeyCommand = new RemoveKeyCommand(this, key);
//            removeKeyCommand.execute();
//        } catch (Exception ignored) {}
//    }
//
//    /**
//     * Clears the collection.
//     * Creates a ClearCollectionCommand object and executes it.
//     * Any exception thrown is caught and ignored.
//     */
//    public void clearCollection() {
//        try {
//            CommandTemplate clearCollectionCommand = new ClearCollectionCommand(this);
//            clearCollectionCommand.execute();
//        } catch (Exception ignored) {}
//    }
//
//    /**
//     * Removes all elements in the collection that have a key less than the specified value.
//     * Creates a RemoveLowerCommand object and executes it.
//     * Any exception thrown is printed to the console.
//     *
//     * @param value the specified value to compare keys against
//     */
//    public void removeLower(HumanBeing value) {
//        try {
//            CommandTemplate removeLowerCommand = new RemoveLowerCommand(this, value);
//            removeLowerCommand.execute();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /**
//     * Replaces the value of the element with the specified key if it is greater than the current value.
//     * Creates a ReplaceIfGreaterCommand object and executes it.
//     * Any exception thrown is caught and ignored.
//     *
//     * @param key the key of the element to replace
//     * @param value the new value to replace the current value with
//     */
//    public void replaceIfGreater(Long key, HumanBeing value) {
//        try {
//            CommandTemplate replaceIfGreaterCommand = new ReplaceIfGreaterCommand(this, key, value);
//            replaceIfGreaterCommand.execute();
//        } catch (Exception ignored) {}
//    }
//
//    /**
//     * Removes all elements in the collection that have a key greater than the specified value.
//     * Creates a RemoveGreaterKeyCommand object and executes it.
//     * Any exception thrown is printed to the console.
//     *
//     * @param key the specified key to compare keys against
//     */
//    public void removeGreaterKey(Long key) {
//        try {
//            CommandTemplate removeGreaterKeyCommand = new RemoveGreaterKeyCommand(this, key);
//            removeGreaterKeyCommand.execute();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
