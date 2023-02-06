package io.humanBeingInput;

import exceptions.InvalidInputException;
import io.consoleIO.ConsoleReader;
import storedClasses.Car;

import java.util.Scanner;

public class CarObjectConsoleReader extends ConsoleReader<Car> {

    private final Car car = new Car();

    @Override
    public Car readObjectFromConsole() throws InvalidInputException {
        Scanner scanner = getConsoleScanner();

        if (HumanBeingObjectConsoleReader.checkTheDesireToEnter("carName")) {
            String carName = HumanBeingObjectConsoleReader.readNameFromConsole();
            car.setName(carName);
        }

        if (HumanBeingObjectConsoleReader.checkTheDesireToEnter("cool")) {
            boolean cool = HumanBeingObjectConsoleReader.readBooleanFromConsole("cool");
            car.setCool(cool);
        }

        return car;
    }
}
