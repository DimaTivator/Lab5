package io.fileIO.in;

import io.fileIO.FileManager;

public abstract class Parser<T> extends FileManager {

    public Parser(String fileName) {
        super(fileName);
    }

    public abstract T ParseDataToHashMap(String fileName);
}
