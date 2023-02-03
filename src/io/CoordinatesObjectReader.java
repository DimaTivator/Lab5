package io;

import exceptioins.InvalidCoordinatesException;
import storedClasses.Coordinates;

import java.util.Scanner;

/**
 * Class for reading and parsing coordinates field of HumanBeing object
 */
public class CoordinatesObjectReader extends Reader<Coordinates> {

    private Coordinates coordinates = new Coordinates();

    @Override
    public Coordinates readObjectFromConsole() throws InvalidCoordinatesException {
        Scanner scanner = getScanner();

        System.out.print("Coordinates (first x, then y): ");
        String[] s = scanner.nextLine().strip().replaceAll(" +", " ").replaceAll(",", ".").split(" ");

        if (s.length != 2) {
            throw new InvalidCoordinatesException("Only 2 coordinates should be entered!\nPlease try again\n");
        }

        coordinates.setX(Double.parseDouble(s[0]));
        coordinates.setY(Float.parseFloat(s[1]));

        return coordinates;
    }
}
