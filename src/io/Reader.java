package io;

import exceptioins.InvalidCoordinatesException;
import exceptioins.InvalidInputException;

import java.util.Scanner;

public abstract class Reader<T> {

    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public abstract T readObjectFromConsole() throws InvalidInputException, InvalidCoordinatesException;
}
