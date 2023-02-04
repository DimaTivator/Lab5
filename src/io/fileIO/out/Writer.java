package io.fileIO.out;

import io.fileIO.FileManager;

public abstract class Writer<T> extends FileManager {

    public Writer(String fileName) {
        super(fileName);
    }

    public abstract void writeData(T data, String fileName);
}
