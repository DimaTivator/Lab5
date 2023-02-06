package collectionManagement;

import commands.Command;
import commands.ExecuteScriptCommand;
import commands.ExitCommand;
import dataStructures.Pair;
import exceptions.NoSuchKeyException;
import exceptions.OccupiedKeyException;
import exceptions.commandExceptions.InvalidArgumentsException;
import io.humanBeingInput.CarObjectConsoleReader;
import io.humanBeingInput.CarObjectFileReader;
import io.humanBeingInput.HumanBeingObjectConsoleReader;
import io.humanBeingInput.HumanBeingObjectFileReader;
import storedClasses.Car;
import storedClasses.HumanBeing;

import java.util.Scanner;

public class CommandsExecutor {

    private final CollectionPrinter collectionPrinter;
    private final CollectionManager collectionManager;

    public CommandsExecutor(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        this.collectionManager = collectionManager;
        this.collectionPrinter = collectionPrinter;
    }

    private HumanBeing getHumanBeingFromConsole() {
        HumanBeingObjectConsoleReader humanBeingObjectReader = new HumanBeingObjectConsoleReader();
        return humanBeingObjectReader.readHumanBeingFromConsole();
    }

    private HumanBeing getHumanBeingFromFile(Scanner fileScanner) {
        HumanBeingObjectFileReader humanBeingObjectFileReader = new HumanBeingObjectFileReader(fileScanner);
        return humanBeingObjectFileReader.readHumanBeingFromFile();
    }

    public void execute(Pair<String, String[]> commandPair, String stream, Scanner scanner) throws Exception {
        String command = commandPair.getFirst();
        String[] args = commandPair.getSecond();

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
                Command executeScriptCommand = new ExecuteScriptCommand(collectionManager, collectionPrinter, args[0]);
                executeScriptCommand.execute();
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
    }
}
