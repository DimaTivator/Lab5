package io;

import exceptioins.InvalidInputException;
import storedClasses.Car;

import java.util.Scanner;

public class CarObjectReader extends Reader<Car> {

    private Car car = new Car();

    @Override
    public Car readObjectFromConsole() throws InvalidInputException {
        Scanner scanner = getScanner();

        System.out.print("Enter a name: ");
        String name = scanner.nextLine().strip();
        System.out.print("Enter a value of field cool (true / false): ");
        String cool = scanner.nextLine().strip().toLowerCase();

        if (name.isEmpty()) {
            throw new InvalidInputException("Name field can't be empty!\nPlease try to enter name again\n");
        }

        car.setName(name);

        if (!(cool.equals("true") || cool.equals("false"))) {
            throw new InvalidInputException("Cool field must be true or false!\nPlease try to enter cool again\n");
        }

        car.setCool(Boolean.getBoolean(cool));

        return car;
    }
}
