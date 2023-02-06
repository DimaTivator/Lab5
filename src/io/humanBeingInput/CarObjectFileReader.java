package io.humanBeingInput;

import io.fileIO.in.FileReader;
import storedClasses.Car;

import java.util.Scanner;

public class CarObjectFileReader extends FileReader<Car> {

    private final Car car = new Car();

    public CarObjectFileReader(Scanner fileScanner) {
        super(fileScanner);
    }

    public Car readData() {
        Scanner fileScanner = getFileScanner();

        String carName = fileScanner.nextLine().strip();
        car.setName(carName);

        boolean cool = Boolean.parseBoolean(fileScanner.nextLine().strip());
        car.setCool(cool);

        return car;
    }
}
