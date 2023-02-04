package io.consoleIO;

import exceptioins.InvalidInputException;
import storedClasses.Car;

import java.util.Scanner;

public class CarObjectReader extends ConsoleReader<Car> {

    private Car car = new Car();

    @Override
    public Car readObjectFromConsole() throws InvalidInputException {
        Scanner scanner = getScanner();

        if (HumanBeingObjectReader.checkTheDesireToEnter("carName")) {
            String carName = HumanBeingObjectReader.readNameFromConsole();
            car.setName(carName);
        }

        if (HumanBeingObjectReader.checkTheDesireToEnter("cool")) {
            boolean cool = HumanBeingObjectReader.readBooleanFromConsole("cool");
            car.setCool(cool);
        }

        return car;
    }
}
