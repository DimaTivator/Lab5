package collectionManagement;

import commands.Command;
import commands.ExecuteScriptCommand;
import commands.ExitCommand;
import commands.SaveCollectionToFileCommand;
import dataStructures.Pair;
import exceptions.NoSuchKeyException;
import exceptions.OccupiedKeyException;
import exceptions.ScriptsRecursionException;
import exceptions.commandExceptions.InvalidArgumentsException;
import io.fileIO.out.HumanBeingXMLWriter;
import io.humanBeingInput.CarObjectConsoleReader;
import io.humanBeingInput.CarObjectFileReader;
import io.humanBeingInput.HumanBeingObjectConsoleReader;
import io.humanBeingInput.HumanBeingObjectFileReader;
import storedClasses.Car;
import storedClasses.HumanBeing;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The `CommandsExecutor` class is responsible for executing commands.
 * It uses two objects of the `CollectionPrinter` and `CollectionManager` classes.
 */
public class CommandsExecutor {

    /**
     * The `collectionPrinter` object is used for printing various information about the collection.
     */
    private final CollectionPrinter collectionPrinter;

    /**
     * The `collectionManager` object is used for managing the collection.
     */
    private final CollectionManager collectionManager;

    /**
     * The set with used files in the command `execute_script`
     */
    private final Set<String> used_scripts = new HashSet<>();

    /**
     * Constructs a `CommandsExecutor` object with the given `collectionManager` and `collectionPrinter`.
     *
     * @param collectionManager the `CollectionManager` object used for managing the collection
     * @param collectionPrinter the `CollectionPrinter` object used for printing information about the collection
     */
    public CommandsExecutor(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        this.collectionManager = collectionManager;
        this.collectionPrinter = collectionPrinter;
    }

    /**
     * Returns a `HumanBeing` object read from the console.
     *
     * @return the `HumanBeing` object read from the console
     */
    private HumanBeing getHumanBeingFromConsole() {
        HumanBeingObjectConsoleReader humanBeingObjectReader = new HumanBeingObjectConsoleReader();
        return humanBeingObjectReader.readHumanBeingFromConsole();
    }

    /**
     * This method reads a `HumanBeing` object from a file and returns it.
     *
     * @param fileScanner the `Scanner` instance that reads the file
     * @return the `HumanBeing` object read from the file
     */
    private HumanBeing getHumanBeingFromFile(Scanner fileScanner) throws Exception {
        HumanBeingObjectFileReader humanBeingObjectFileReader = new HumanBeingObjectFileReader(fileScanner);
        return humanBeingObjectFileReader.readHumanBeingFromFile();
    }

    /**
     Executes the given command.

     @param commandPair a Pair of command name and its arguments
     @param stream source of the input data ("console" or "file")
     @param scanner the Scanner object to read input from
     @throws Exception if an error occurs during the execution of the command
     */
    public void execute(Pair<String, String[]> commandPair, String stream, Scanner scanner) throws Exception {
        String command = commandPair.getFirst();
        String[] args = commandPair.getSecond();

        // System.out.println(command + ' ' + Arrays.toString(args));

        switch (command) {

            case ("help") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException("Command 'help' takes no arguments!" +
                            "Please try to enter command again");
                }
                collectionPrinter.printHelp();
            }

            case ("info") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException("Command 'info' takes no arguments!" +
                            "Please try to enter command again");
                }
                collectionPrinter.printCollectionInfo(collectionManager);
            }

            case ("show") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException("Command 'show' takes no arguments!" +
                            "Please try to enter command again");
                }
                collectionPrinter.printCollection(collectionManager);
            }

            case ("insert") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you enter key in the same line with the name of command");
                }
                try {
                    Long key = Long.parseLong(args[0]);

                    if (collectionManager.getCollection().containsKey(key)) {
                        throw new OccupiedKeyException("Collection already contains the object with this key!\n" +
                                "Please try to enter another key");
                    }

                    if (stream.equals("console")) {
                        collectionManager.insertElement(key, getHumanBeingFromConsole());
                    } else if (stream.equals("file")) {
                        collectionManager.insertElement(key, getHumanBeingFromFile(scanner));
                    }

                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    throw new InvalidArgumentsException();
                }
            }

            case ("update") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you enter key in the same line with the name of command");
                }
                try {
                    Long key = Long.parseLong(args[0]);

                    if (collectionManager.getCollection().containsKey(key)) {

                        if (stream.equals("console")) {
                            collectionManager.updateValueByKey(key, getHumanBeingFromConsole());
                        } else {
                            collectionManager.updateValueByKey(key, getHumanBeingFromFile(scanner));
                        }

                    } else {
                        throw new NoSuchKeyException("Can't find the entered key in the collection :(\n" +
                                "Please try to enter command again");
                    }

                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    throw new InvalidArgumentsException();
                }
            }

            case ("remove_key") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException();
                }
                try {
                    Long key = Long.parseLong(args[0]);

                    if (collectionManager.getCollection().containsKey(key)) {
                        collectionManager.removeByKey(key);
                    } else {
                        throw new NoSuchKeyException("Can't find the entered key in the collection :(\n" +
                                "Please try to enter command again");
                    }

                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you enter key in the same line with the name of command");
                }
            }

            case ("clear") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException("Command 'clear' doesn't have any arguments");
                }
                collectionManager.clearCollection();
            }

            case ("save") -> {
                if (args.length == 0) {
                    collectionPrinter.saveCollectionToFile(collectionManager);
                } else if (args.length == 1) {
                    collectionPrinter.saveCollectionToFile(collectionManager, args[0]);
                } else {
                    throw new InvalidArgumentsException();
                }
            }

            case ("execute_script") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException();
                }

                if (used_scripts.contains(args[0])) {
                    throw new ScriptsRecursionException("You should not call command `execute_script` recursively!");
                }

                used_scripts.add(args[0]);

                Command executeScriptCommand = new ExecuteScriptCommand(collectionManager, collectionPrinter, this, args[0]);
                executeScriptCommand.execute();

                used_scripts.clear();
            }

            case ("exit") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException();
                }
                try {
                    Command exitCommand = new ExitCommand();
                    exitCommand.execute();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            case ("remove_lower") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException();
                }

                if (stream.equals("console")) {
                    collectionManager.removeLower(getHumanBeingFromConsole());
                } else {
                    collectionManager.removeLower(getHumanBeingFromFile(scanner));
                }
            }

            case ("replace_if_greater") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you enter key in the same line with the name of command");
                }
                try {
                    Long key = Long.parseLong(args[0]);

                    if (collectionManager.getCollection().containsKey(key)) {

                        if (stream.equals("console")) {
                            collectionManager.replaceIfGreater(key, getHumanBeingFromConsole());
                        } else {
                            collectionManager.replaceIfGreater(key, getHumanBeingFromFile(scanner));
                        }

                    } else {
                        throw new NoSuchKeyException("Can't find the entered key in the collection :(\n" +
                                "Please try to enter command again");
                    }

                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    throw new InvalidArgumentsException();
                }
            }

            case ("remove_greater_key") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you enter a key in the same line with the name of command");
                }
                try {
                    Long key = Long.parseLong(args[0]);
                    collectionManager.removeGreaterKey(key);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new InvalidArgumentsException();
                }
            }

            case ("count_less_than_impact_speed") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you enter an impact speed in the same line with the name of command");
                }
                try {
                    Double impactSpeed = Double.parseDouble(args[0].replaceAll(",", "."));
                    collectionPrinter.countLessThanImpactSpeed(collectionManager, impactSpeed);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new InvalidArgumentsException();
                }
            }

            case ("filter_less_than_car") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you do not enter any arguments in the same line with the command");
                }
                try {
                    CarObjectConsoleReader carObjectReader = new CarObjectConsoleReader();

                    if (stream.equals("console")) {
                        collectionPrinter.filterLessThanCar(collectionManager, carObjectReader.readObjectFromConsole());
                    } else {
                        CarObjectFileReader carObjectFileReader = new CarObjectFileReader(scanner);
                        Car car = carObjectFileReader.readData();
                        collectionPrinter.filterLessThanCar(collectionManager, car);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new InvalidArgumentsException();
                }
            }

            case ("print_unique_mood") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you do not enter any arguments in the same line with the command");
                }
                collectionPrinter.printUniqueMood(collectionManager);
            }
        }

        // save collection
        CollectionSaver collectionSaver = new CollectionSaver(collectionManager, new HumanBeingXMLWriter());
        collectionSaver.saveCollection();
    }
}
