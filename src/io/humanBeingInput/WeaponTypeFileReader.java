package io.humanBeingInput;

import exceptions.InvalidInputException;
import io.fileIO.in.FileReader;
import storedClasses.WeaponType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeaponTypeFileReader extends FileReader<WeaponType> {

    public WeaponTypeFileReader(Scanner fileScanner) {
        super(fileScanner);
    }

    public WeaponType readData() throws InvalidInputException {
        Scanner scanner = getFileScanner();

        List<String> weaponTypeList = new ArrayList<>();
        Arrays.stream(WeaponType.values()).toList().forEach(mood -> weaponTypeList.add(mood.toString()));

        String weaponType = scanner.nextLine().toUpperCase();

        if (!weaponTypeList.contains(weaponType)) {
            throw new InvalidInputException("You should choose mood from the available weapon types!\nPlease try again\n");
        }

        return WeaponType.valueOf(weaponType);
    }
}
