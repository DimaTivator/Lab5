package io.fileIO.out;

import io.fileIO.FileManager;

public abstract class FileWriter<T> extends FileManager {

    public FileWriter(String fileName) {
        super(fileName);
    }

    public FileWriter() {};

    public abstract void writeData(T data, String fileName);
}
