package io.humanBeingInput;

import exceptions.InvalidCoordinatesException;
import exceptions.InvalidInputException;
import io.consoleIO.ConsoleReader;
import storedClasses.Coordinates;

import java.util.Scanner;

/**
 * Class for reading and parsing coordinates field of HumanBeing object
 */
public class CoordinatesObjectConsoleReader extends ConsoleReader<Coordinates> {

    private final Coordinates coordinates = new Coordinates();

    @Override
    public Coordinates readObjectFromConsole() throws InvalidInputException, InvalidCoordinatesException {
        Scanner scanner = getConsoleScanner();

        System.out.print("Coordinates (first x, then y): ");
        return getCoordinates(scanner, coordinates);
    }

    static Coordinates getCoordinates(Scanner scanner, Coordinates coordinates) throws InvalidInputException, InvalidCoordinatesException {
        String[] s = scanner.nextLine().strip().replaceAll(" +", " ").replaceAll(",", ".").split(" ");

        if (s.length != 2) {
            throw new InvalidInputException("Only 2 coordinates should be entered!\nPlease try again\n");
        }

        coordinates.setX(Double.parseDouble(s[0]));
        coordinates.setY(Float.parseFloat(s[1]));

        return coordinates;
    }
}
