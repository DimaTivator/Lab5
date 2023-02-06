package io.humanBeingInput;

import exceptions.InvalidInputException;
import io.fileIO.in.FileReader;
import storedClasses.Mood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoodFileReader  extends FileReader<Mood> {

    public MoodFileReader(Scanner fileScanner) {
        super(fileScanner);
    }

    public Mood readData() throws InvalidInputException {
        Scanner fileScanner = getFileScanner();

        List<String> moodList = new ArrayList<>();
        Arrays.stream(Mood.values()).toList().forEach(mood -> moodList.add(mood.toString()));

        String mood = fileScanner.nextLine().toUpperCase();

        if (!moodList.contains(mood)) {
            throw new InvalidInputException("You should choose mood from the available moods!\nPlease try again\n");
        }

        return Mood.valueOf(mood);
    }
}
