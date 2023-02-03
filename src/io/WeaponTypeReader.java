package io;

import exceptioins.InvalidInputException;
import storedClasses.Mood;
import storedClasses.WeaponType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeaponTypeReader extends Reader<WeaponType> {

    private WeaponType weaponType;

    @Override
    public WeaponType readObjectFromConsole() throws InvalidInputException {
        Scanner scanner = getScanner();

        System.out.println("Enter one of the following weapon types:");

        List<String> weaponTypeList = new ArrayList<>();
        Arrays.stream(WeaponType.values()).toList().forEach(mood -> weaponTypeList.add(mood.toString()));

        for (String weaponType : weaponTypeList) {
            System.out.println(weaponType);
        }

        String input = scanner.nextLine().toUpperCase();

        if (!weaponTypeList.contains(input)) {
            throw new InvalidInputException("You should choose mood from the available weapon types!\nPlease try again");
        }

        weaponType = WeaponType.valueOf(input);

        return weaponType;
    }
}
