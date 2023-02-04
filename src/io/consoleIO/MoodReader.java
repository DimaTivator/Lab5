package io.consoleIO;

import exceptioins.InvalidInputException;
import storedClasses.Mood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoodReader extends ConsoleReader<Mood> {

    private Mood mood;

    @Override
    public Mood readObjectFromConsole() throws InvalidInputException {
        Scanner scanner = getScanner();

        System.out.println("Enter one of the following moods:");

        List<String> moodList = new ArrayList<>();
        Arrays.stream(Mood.values()).toList().forEach(mood -> moodList.add(mood.toString()));

        for (String mood : moodList) {
            System.out.println(mood);
        }

        String input = scanner.nextLine().toUpperCase();

        if (!moodList.contains(input)) {
            throw new InvalidInputException("You should choose mood from the available moods!\nPlease try again\n");
        }

        mood = Mood.valueOf(input);

        return mood;
    }
}
