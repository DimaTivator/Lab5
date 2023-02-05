package io.consoleIO;

import java.util.Scanner;

public abstract class ConsoleReader<T> {

    private final Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public abstract T readObjectFromConsole() throws Exception;
}
