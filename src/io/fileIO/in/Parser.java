package io.fileIO.in;

import org.w3c.dom.Document;

public abstract class Parser<T> extends FileReader<Document> {

    public Parser(String fileName) {
        super(fileName);
    }

    public Parser() {};

    public abstract T parseDataToHashMap(String fileName);
}
