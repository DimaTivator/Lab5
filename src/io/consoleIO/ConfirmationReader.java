package io.consoleIO;

import java.util.Scanner;

public class ConfirmationReader extends ConsoleReader<String> {

    @Override
    public String readObjectFromConsole() {
        System.out.println("Enter Y / N to confirm");
        Scanner scanner = getScanner();
        return scanner.nextLine();
    }
}
