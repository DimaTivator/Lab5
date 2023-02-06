package io.fileIO.in;

import collectionManagement.CollectionManager;
import collectionManagement.CollectionPrinter;
import collectionManagement.CommandsExecutor;
import io.consoleIO.CommandParser;

import java.io.File;
import java.util.Scanner;

public class ScriptExecutor {

    CollectionManager collectionManager;
    CollectionPrinter collectionPrinter;

    public ScriptExecutor(CollectionManager collectionManager, CollectionPrinter collectionPrinter) {
        this.collectionManager = collectionManager;
        this.collectionPrinter = collectionPrinter;
    }

    public void executeScript(String filePath) throws Exception {
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        CommandsExecutor commandsExecutor = new CommandsExecutor(collectionManager, collectionPrinter);
        CommandParser commandParser = new CommandParser();

        while (fileScanner.hasNext()) {
            commandsExecutor.execute(commandParser.parseCommandFromFile(fileScanner), "file", fileScanner);
        }
    }
}
