package io.consoleIO;

import auxiliaryClasses.ConsoleColors;
import dataStructures.Pair;
import exceptions.commandExceptions.NoSuchCommandException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandParser extends ConsoleReader<Pair<String, String[]>> {

    private static final ArrayList<String> commandsList = new ArrayList<>() {{
        add("help");
        add("info");
        add("show");
        add("insert");
        add("update");
        add("remove_key");
        add("clear");
        add("save");
        add("save");
        add("execute_script");
        add("exit");
        add("remove_lower");
        add("replace_if_greater");
        add("remove_greater_key");
        add("count_less_than_impact_speed");
        add("filter_less_than_car");
        add("print_unique_mood");
    }};

    public static ArrayList<String> getCommandsList() {
        return commandsList;
    }

    @Override
    public Pair<String, String[]> readObjectFromConsole() throws NoSuchCommandException {
        Scanner scanner = getConsoleScanner();
        System.out.print(ConsoleColors.BLUE_BRIGHT + "Enter a command: " + ConsoleColors.RESET);
        return getStringPair(scanner);
    }

    private Pair<String, String[]> getStringPair(Scanner scanner) throws NoSuchCommandException {
        List<String> line = Arrays.stream(scanner.nextLine().strip().replaceAll(" +", " ").split(" ")).toList();

        // System.out.println(line);

        if (!commandsList.contains(line.get(0))) {
            throw new NoSuchCommandException(String.format("Can't find command %s in commands list\n", line.get(0)) +
                    "Please try to enter command again\n");
        }

        String command = line.get(0);
        String[] args = line.subList(1, line.size()).toArray(new String[0]);

        return new Pair<>(command, args);
    }

    public Pair<String, String[]> parseCommandFromFile(Scanner fileScanner) throws NoSuchCommandException {

        return getStringPair(fileScanner);
    }
}
