import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import collectionManagement.CommandsExecutor;
import io.consoleIO.CommandParser;
import io.fileIO.in.HumanBeingXMLParser;
import io.fileIO.in.Parser;
import storedClasses.HumanBeing;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Main class that contains the main method for starting the program.
 */
public class Main {
    /**
     * Main method that starts the program. It creates objects for managing the collection,
     * printing the collection, parsing XML data, executing commands, reading user input, and parsing commands.
     * The method also contains an infinite loop that reads and executes user commands until the program is terminated.
     * @param args - Arguments passed to the main method.
     */
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CollectionPrinter collectionPrinter = new CollectionPrinter();

        Parser<LinkedHashMap<Long, HumanBeing>> humanBeingXMLParser = new HumanBeingXMLParser();
        // collectionManager.setCollection(humanBeingXMLParser.parseDataToHashMap("src/dataFiles/data.xml"));
        collectionManager.setCollection(humanBeingXMLParser.parseData(args[0]));

        CommandsExecutor commandsExecutor = new CommandsExecutor(collectionManager, collectionPrinter);
        Scanner scanner = new Scanner(System.in);
        CommandParser commandParser = new CommandParser();

        System.out.println( "If you want to see the list of available commands, enter 'help'");

        while (true) {
            try {
                commandsExecutor.execute(commandParser.readObjectFromConsole(), "console", scanner);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
