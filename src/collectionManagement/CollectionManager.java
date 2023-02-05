package collectionManagement;

import commands.Command;
import commands.InsertCommand;
import storedClasses.HumanBeing;

import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionManager {

    private final java.time.LocalDate creationDate;

    private Map<Long, HumanBeing> data = new LinkedHashMap<>();

    public CollectionManager() {
        creationDate = java.time.LocalDate.now();
    }

    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Method returns the collection
     */
    public Map<Long, HumanBeing> getCollection() {
        return data;
    }

    public void setCollection(LinkedHashMap<Long, HumanBeing> collection) {
        data = collection;
    }

    /**
     * Method inserts to the collection a new pair (key - value)
     * @param key key
     * @param value value
     */
    public void insertElement(Long key, HumanBeing value) {
        try {
            Command insertCommand = new InsertCommand(this, key, value);
            insertCommand.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method updates the value in the collection by the specified key
     * @param key key
     * @param value new value
     */
    public void updateValueByKey(Long key, HumanBeing value) {

    }

    /**
     * Method removes from the collection the pair by the specified key
     * @param key key
     */
    public void removeByKey(Long key) {

    }

    /**
     * Method clears the collection
     */
    public void clearCollection() {

    }

    /**
     * Method removes from the collection all items which value is less than the specified one
     * @param value value
     */
    public void removeLower(HumanBeing value) {

    }

    /**
     * Method replaces the value by the key if the new value is greater than the old one
     * @param key key
     * @param value value
     */
    public void replaceIfGreater(Long key, HumanBeing value) {

    }

    /**
     * Method removes from the collection all items which key is greater than the specified one
     * @param key key
     */
    public void removeGreaterKey(Long key) {

    }
}
