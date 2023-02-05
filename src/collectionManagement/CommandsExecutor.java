package collectionManagement;

import commands.Command;
import commands.ExecuteScriptCommand;
import commands.ExitCommand;
import dataStructures.Pair;
import exceptions.commandExceptions.InvalidArgumentsException;
import io.consoleIO.humanBeingInput.CarObjectReader;
import io.consoleIO.humanBeingInput.HumanBeingObjectReader;
import storedClasses.HumanBeing;

public class CommandsExecutor {

    private CollectionPrinter collectionPrinter;
    private CollectionManager collectionManager;

    public CommandsExecutor(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        this.collectionManager = collectionManager;
        this.collectionPrinter = collectionPrinter;
    }

    private HumanBeing getHumanBeing() {
        HumanBeingObjectReader humanBeingObjectReader = new HumanBeingObjectReader();
        return humanBeingObjectReader.readHumanBeingFromConsole();
    }

    public void execute(Pair<String, String[]> commandPair) throws InvalidArgumentsException {
        String command = commandPair.getFirst();
        String[] args = commandPair.getSecond();

        switch (command) {

            case ("help") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException();
                }
                collectionPrinter.printHelp();
            }

            case ("info") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException();
                }
                collectionPrinter.printCollectionInfo(collectionManager);
            }

            case ("show") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException();
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
                    collectionManager.insertElement(key, getHumanBeing());
                } catch(Exception e) {
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
                    collectionManager.updateValueByKey(key, getHumanBeing());
                } catch(Exception e) {
                    throw new InvalidArgumentsException();
                }
            }

            case ("remove_key") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException();
                }
                try {
                    Long key = Long.parseLong(args[0]);
                    collectionManager.removeByKey(key);
                } catch(Exception e) {
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
                    collectionPrinter.saveCollectionToFile();
                } else if (args.length == 1) {
                    collectionPrinter.saveCollectionToFile(args[0]);
                } else {
                    throw new InvalidArgumentsException();
                }
            }

            case ("execute_script") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException();
                }
                // TODO
                // Command executeScriptCommand = new ExecuteScriptCommand();
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
                collectionManager.removeLower(getHumanBeing());
            }

            case ("replace_if_greater") -> {
                if (args.length != 1) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you enter key in the same line with the name of command");
                }
                try {
                    Long key = Long.parseLong(args[0]);
                    collectionManager.replaceIfGreater(key, getHumanBeing());
                } catch(Exception e) {
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
                    throw new InvalidArgumentsException();
                }
            }

            case ("filter_less_than_car") -> {
                if (args.length != 0) {
                    throw new InvalidArgumentsException("Something wrong with command arguments :(\n" +
                            "Please check that you do not enter any arguments in the same line with the command");
                }
                try {
                    CarObjectReader carObjectReader = new CarObjectReader();
                    collectionPrinter.filterLessThanCar(collectionManager, carObjectReader.readObjectFromConsole());
                } catch (Exception e) {
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
