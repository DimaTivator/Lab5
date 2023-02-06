package io.humanBeingInput;

import exceptions.InvalidCoordinatesException;
import exceptions.InvalidInputException;
import io.fileIO.in.FileReader;
import storedClasses.Coordinates;

import java.util.Scanner;

import static io.humanBeingInput.CoordinatesObjectConsoleReader.getCoordinates;

public class CoordinatesObjectFileReader extends FileReader<Coordinates> {

    private final Coordinates coordinates = new Coordinates();

    public CoordinatesObjectFileReader(Scanner fileScanner) {
        super(fileScanner);
    }

    public Coordinates readData() throws InvalidInputException, InvalidCoordinatesException {
        Scanner scanner = getFileScanner();

        return getCoordinates(scanner, coordinates);
    }
}
