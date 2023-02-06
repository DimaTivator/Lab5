package io.humanBeingInput;

import exceptions.InvalidCoordinatesException;
import exceptions.InvalidInputException;
import io.fileIO.in.FileReader;
import storedClasses.*;

import java.util.Scanner;

public class HumanBeingObjectFileReader extends FileReader<HumanBeing> {

    private final Scanner fileScanner = getFileScanner();

    public HumanBeingObjectFileReader(Scanner fileScanner) {
        super(fileScanner);
    }


    private String readNameFromFile() throws InvalidInputException {

        String name = fileScanner.nextLine().strip();

        if (name.isEmpty()) {
            throw new InvalidInputException("Name field can't be empty!\nPlease try to enter name again\n");
        }

        return name;
    }

    private boolean readBooleanFromFile(String valueName) throws InvalidInputException {

        String input = fileScanner.nextLine().strip().toLowerCase();

        if (!(input.equals("true") || input.equals("false"))) {
            throw new InvalidInputException(
                    String.format("%s field must be true or false!\nPlease try to enter %s again\n", valueName, valueName)
            );
        }

        return Boolean.parseBoolean(input);
    }

    private double readDoubleFromFile(String valueName) throws InvalidInputException {

        if (fileScanner.hasNextDouble()) {
            return Double.parseDouble(fileScanner.nextLine());
        }
        throw new InvalidInputException(
                String.format("%s field must be double!\nPlease try to enter %s again\n", valueName, valueName)
        );
    }

    public HumanBeing readHumanBeingFromFile() {

        String name;
        while (true) {
            try {
                name = readNameFromFile();
                break;
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        Coordinates coordinates;
        CoordinatesObjectFileReader coordinatesObjectFileReader = new CoordinatesObjectFileReader(fileScanner);
        while (true) {
            try {
                coordinates = coordinatesObjectFileReader.readData();
                break;
            } catch (InvalidCoordinatesException | InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        WeaponType weaponType;
        WeaponTypeFileReader weaponTypeFileReader = new WeaponTypeFileReader(fileScanner);
        while (true) {
            try {
                weaponType = weaponTypeFileReader.readData();
                break;
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        Mood mood;
        MoodFileReader moodFileReader = new MoodFileReader(fileScanner);
        while (true) {
            try {
                mood = moodFileReader.readData();
                break;
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        HumanBeing humanBeing = new HumanBeing(name, mood, weaponType, coordinates);


        try {
            boolean realHero = readBooleanFromFile("realHero");
            humanBeing.setRealHero(realHero);
        } catch (InvalidInputException e) {
            System.out.print(e.getMessage());
        }



        try {
            boolean hasToothpick = readBooleanFromFile("hasToothpick");
            humanBeing.setHasToothpick(hasToothpick);
        } catch (InvalidInputException e) {
            System.out.print(e.getMessage());
        }


        try {
            double impactSpeed = readDoubleFromFile("impactSpeed");
            humanBeing.setImpactSpeed(impactSpeed);
        } catch (InvalidInputException e) {
            System.out.print(e.getMessage());
        }


        Car car;
        CarObjectFileReader carObjectFileReader = new CarObjectFileReader(fileScanner);
        car = carObjectFileReader.readData();
        humanBeing.setCar(car);

        return humanBeing;
    }
}
