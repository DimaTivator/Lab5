package io.consoleIO;

import java.util.Scanner;

public abstract class ConsoleReader<T> {

    private final Scanner consoleScanner = new Scanner(System.in);

    public Scanner getConsoleScanner() {
        return consoleScanner;
    }

    public abstract T readObjectFromConsole() throws Exception;
}
