package io.fileIO.in;

import io.fileIO.FileManager;

import java.util.Scanner;

public abstract class FileReader<T> extends FileManager {

    private Scanner fileScanner;

    public FileReader(Scanner fileScanner) {
        this.fileScanner = fileScanner;
    }

    public FileReader(String fileName) {
        super(fileName);
    }

    public FileReader() {}

    public Scanner getFileScanner() {
        return fileScanner;
    }

}
