package io;

import exceptioins.InvalidCoordinatesException;
import exceptioins.InvalidInputException;
import storedClasses.*;

import java.util.Scanner;

public class HumanBeingObjectReader {

    private HumanBeing humanBeing;
    private Scanner scanner = new Scanner(System.in);

    public String readNameFromConsole() throws InvalidInputException {

        System.out.print("Enter a name: ");
        String name = scanner.nextLine().strip();

        if (name.isEmpty()) {
            throw new InvalidInputException("Name field can't be empty!\nPlease try to enter name again\n");
        }

        return name;
    }

    public HumanBeing readObjectFromConsole() {

        String name;
        while (true) {
            try {
                name = readNameFromConsole();
                break;
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        System.out.println(name);

        return humanBeing;
    }
}
