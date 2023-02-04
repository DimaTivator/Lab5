package io.fileIO.in;

import io.fileIO.FileManager;

public abstract class FileReader<T> extends FileManager {

    public FileReader(String fileName) {
        super(fileName);
    }

    public FileReader() {}

    public abstract T readData(String fileName);
}
