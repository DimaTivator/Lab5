package collectionManagement;

import StoredClasses.Car;
import StoredClasses.HumanBeing;

import java.util.Map;

/**
 * Class CollectionPrinter is used to print info about the collection
 */
public class CollectionPrinter {

    /**
     * Method printCollectionInfo prints the collection type, the date of initialization of collection and the number
     * elements in collection
     * @param collectionInfo a Map that contains the information about the collection
     */
    public void printCollectionInfo(Map<String, String> collectionInfo) {

    }

    /**
     * Method printCollection prints HashMap contents in (key - value) format,
     * where every pair (key - value) is printed on a separate line
     * @param data the collection
     */
    public void printCollection(Map<Integer, HumanBeing> data) {

    }

    /**
     * Method printUniqueMood prints the unique values of the mood field of all items in the collection
     * @param data the collection
     */
    public void printUniqueMood(Map<Integer, HumanBeing> data) {

    }

    /**
     * Method counts and prints the number of elements whose impactSpeed field value is less than the specified one
     * @param data the collection
     * @param impactSpeed impactSpeed
     */
    public void countLessThanImpactSpeed(Map<Integer, HumanBeing> data, int impactSpeed) {

    }

    /**
     * Method counts and prints the number of elements whose car field value is less than the specified one
     * @param data the collection
     * @param car car
     */
    public void filterLessThanCar(Map<Integer, HumanBeing> data, Car car) {

    }
}
