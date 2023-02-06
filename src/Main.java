import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import collectionManagement.CommandsExecutor;
import io.consoleIO.CommandParser;
import io.fileIO.in.HumanBeingXMLParser;
import io.fileIO.in.Parser;
import storedClasses.HumanBeing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CollectionPrinter collectionPrinter = new CollectionPrinter();

        Parser<LinkedHashMap<Long, HumanBeing>> humanBeingXMLParser = new HumanBeingXMLParser();
        // collectionManager.setCollection(humanBeingXMLParser.parseDataToHashMap("src/dataFiles/data.xml"));
        collectionManager.setCollection(humanBeingXMLParser.parseDataToHashMap(args[0]));

        CommandsExecutor commandsExecutor = new CommandsExecutor(collectionManager, collectionPrinter);
        Scanner scanner = new Scanner(System.in);
        CommandParser commandParser = new CommandParser();

        while (true) {
            try {
                commandsExecutor.execute(commandParser.readObjectFromConsole(), "console", scanner);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
