package collectionManagement;

import storedClasses.HumanBeing;

import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionManager {

    private Map<Integer, HumanBeing> data = new LinkedHashMap<>();

    /**
     * Method returns the collection
     */
    public Map<Integer, HumanBeing> getCollection() {
        return data;
    }

    /**
     * Method inserts to the collection a new pair (key - value)
     * @param key key
     * @param value value
     */
    public void insertElement(int key, HumanBeing value) {

    }

    /**
     * Method updates the value in the collection by the specified key
     * @param key key
     * @param value new value
     */
    public void updateValueByKey(int key, HumanBeing value) {

    }

    /**
     * Method removes from the collection the pair by the specified key
     * @param key key
     */
    public void removeByKey(int key) {

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
    public void replaceIfGreater(int key, HumanBeing value) {

    }

    /**
     * Method removes from the collection all items which key is greater than the specified one
     * @param key key
     */
    public void removeGreaterKey(int key) {

    }
}
