package io.fileIO.in;

import storedClasses.HumanBeing;

import java.util.LinkedHashMap;

public class HumanBeingXMLParser extends Parser<LinkedHashMap<Long, HumanBeing>> {

    public HumanBeingXMLParser(String fileName) {
        super(fileName);
    }

    @Override
    public void readData(String fileName) {

    }

    @Override
    public void writeData(String fileName) {

    }

    @Override
    public LinkedHashMap<Long, HumanBeing> ParseDataToHashMap(String fileName) {
        return null;
    }
}
