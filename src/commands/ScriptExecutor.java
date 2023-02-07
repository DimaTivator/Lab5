package commands;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import collectionManagement.CommandsExecutor;
import exceptions.commandExceptions.NoSuchCommandException;
import io.consoleIO.CommandParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The {@code ScriptExecutor} class provides the functionality to execute commands from a script file.
 * It takes a {@link CollectionManager} and {@link CollectionPrinter} object and uses them to execute the commands.
 */
public class ScriptExecutor {

    /**
     * The {@code CollectionManager} object to manage the collection of data.
     */
    CollectionManager collectionManager;

    /**
     * The {@code CollectionPrinter} object to print the collection data.
     */
    CollectionPrinter collectionPrinter;

    /**
     * Constructs a {@code ScriptExecutor} object with the given {@code CollectionManager} and {@code CollectionPrinter} objects.
     * @param collectionManager the {@code CollectionManager} object to manage the collection of data.
     * @param collectionPrinter the {@code CollectionPrinter} object to print the collection data.
     */
    public ScriptExecutor(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        this.collectionManager = collectionManager;
        this.collectionPrinter = collectionPrinter;
    }

    /**
     * Executes the commands from the script file located at the given file path.
     * @param filePath the path to the script file.
     */
    public void executeScript(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        CommandsExecutor commandsExecutor = new CommandsExecutor(collectionManager, collectionPrinter);
        CommandParser commandParser = new CommandParser();

        while (true) {
            try {
                commandsExecutor.execute(commandParser.parseCommandFromFile(fileScanner), "file", fileScanner);
            } catch (NoSuchCommandException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                break;
            }
        }
    }
}
