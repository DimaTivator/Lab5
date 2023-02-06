package io.humanBeingInput;

import exceptions.InvalidCoordinatesException;
import exceptions.InvalidInputException;
import storedClasses.*;

import java.util.Scanner;

public class HumanBeingObjectConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    protected static String readNameFromConsole() throws InvalidInputException {

        System.out.print("Enter a name: ");
        String name = scanner.nextLine().strip();

        if (name.isEmpty()) {
            throw new InvalidInputException("Name field can't be empty!\nPlease try to enter name again\n");
        }

        return name;
    }

    protected static boolean readBooleanFromConsole(String valueName) throws InvalidInputException {

        System.out.printf("Enter a value of %s (true / false): ", valueName);
        String input = scanner.nextLine().strip().toLowerCase();

        if (!(input.equals("true") || input.equals("false"))) {
            throw new InvalidInputException(
                    String.format("%s field must be true or false!\nPlease try to enter %s again\n", valueName, valueName)
            );
        }

        return Boolean.parseBoolean(input);
    }

    protected static double readDoubleFromConsole(String valueName) throws InvalidInputException {

        System.out.printf("Enter a value of %s: ", valueName);

        if (scanner.hasNextDouble()) {
            return Double.parseDouble(scanner.nextLine());
        }
        throw new InvalidInputException(
                String.format("%s field must be double!\nPlease try to enter %s again\n", valueName, valueName)
        );
    }

    protected static boolean checkTheDesireToEnter(String valueName) {
        System.out.printf("Do you want to enter %s? (Y / N): ", valueName);
        String input = scanner.nextLine().strip();
        return input.equals("Y");
    }

    public HumanBeing readHumanBeingFromConsole() {

        String name;
        while (true) {
            try {
                name = readNameFromConsole();
                break;
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        Coordinates coordinates;
        CoordinatesObjectConsoleReader coordinatesObjectReader = new CoordinatesObjectConsoleReader();
        while (true) {
            try {
                coordinates = coordinatesObjectReader.readObjectFromConsole();
                break;
            } catch (InvalidCoordinatesException|InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        WeaponType weaponType;
        WeaponTypeConsoleReader weaponTypeReader = new WeaponTypeConsoleReader();
        while (true) {
            try {
                weaponType = weaponTypeReader.readObjectFromConsole();
                break;
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        Mood mood;
        MoodConsoleReader moodReader = new MoodConsoleReader();
        while (true) {
            try {
                mood = moodReader.readObjectFromConsole();
                break;
            } catch (InvalidInputException e) {
                System.out.print(e.getMessage());
            }
        }

        HumanBeing humanBeing = new HumanBeing(name, mood, weaponType, coordinates);


        if (checkTheDesireToEnter("realHero")) {
            boolean realHero;
            while (true) {
                try {
                    realHero = readBooleanFromConsole("realHero");
                    break;
                } catch (InvalidInputException e) {
                    System.out.print(e.getMessage());
                }
            }
            humanBeing.setRealHero(realHero);
        }

        if (checkTheDesireToEnter("hasToothpick")) {
            boolean hasToothpick;
            while (true) {
                try {
                    hasToothpick = readBooleanFromConsole("hasToothpick");
                    break;
                } catch (InvalidInputException e) {
                    System.out.print(e.getMessage());
                }
            }
            humanBeing.setHasToothpick(hasToothpick);
        }

        if (checkTheDesireToEnter("impactSpeed")) {
            double impactSpeed;
            while (true) {
                try {
                    impactSpeed = readDoubleFromConsole("impactSpeed");
                    break;
                } catch (InvalidInputException e) {
                    System.out.print(e.getMessage());
                }
            }
            humanBeing.setImpactSpeed(impactSpeed);
        }

        if (checkTheDesireToEnter("Car")) {
            Car car;
            CarObjectConsoleReader carObjetReader = new CarObjectConsoleReader();
            while (true) {
                try {
                    car = carObjetReader.readObjectFromConsole();
                    break;
                } catch (InvalidInputException e) {
                    System.out.print(e.getMessage());
                }
            }
            humanBeing.setCar(car);
        }

        return humanBeing;
    }
}
