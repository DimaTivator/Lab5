package io.fileIO.out;

import auxiliaryClasses.ConsoleColors;
import storedClasses.HumanBeing;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class HumanBeingXMLWriter extends FileWriter<Map<Long, HumanBeing>> {

    public HumanBeingXMLWriter(String fileName) {
        super(fileName);
    }

    public HumanBeingXMLWriter() {};

    @Override
    public void writeData(Map<Long, HumanBeing> data, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {

            writer.write("<?xml version='1.0' encoding='UTF-8'?>\n");
            writer.write("<HumanBeings>\n");

            for (HumanBeing humanBeing : data.values()) {

                writer.write("\t<HumanBeing>\n");
                writer.write("\t\t<id>" + humanBeing.getId() + "</id>\n");
                writer.write("\t\t<name>" + humanBeing.getName() + "</name>\n");
                writer.write("\t\t<creationDate>" + humanBeing.getCreationDate() + "</creationDate>\n");
                writer.write("\t\t<realHero>" + humanBeing.isRealHero() + "</realHero>\n");
                writer.write("\t\t<hasToothpick>" + humanBeing.isHasToothpick() + "</hasToothpick>\n");
                writer.write("\t\t<impactSpeed>" + humanBeing.getImpactSpeed() + "</impactSpeed>\n");
                writer.write("\t\t<weaponType>" + humanBeing.getWeaponType() + "</weaponType>\n");
                writer.write("\t\t<mood>" + humanBeing.getMood() + "</mood>\n");
                writer.write("\t\t<coordinates>\n");
                writer.write("\t\t\t<x>" + humanBeing.getCoordinates().getX() + "</x>\n");
                writer.write("\t\t\t<y>" + humanBeing.getCoordinates().getY() + "</y>\n");
                writer.write("\t\t</coordinates>\n");

                if (humanBeing.getCar() != null) {
                    writer.write("\t\t<car>\n");

                    if (humanBeing.getCar().getName() != null) {
                        writer.write("\t\t\t<name>" + humanBeing.getCar().getName() + "</name>\n");
                    }

                    if (humanBeing.getCar().getCool() != null) {
                        writer.write("\t\t\t<cool>" + humanBeing.getCar().getCool() + "</cool>\n");
                    }

                    writer.write("\t\t</car>\n");
                }
                writer.write("\t</HumanBeing>\n");
            }
            writer.write("</HumanBeings>\n");
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED_BOLD + "Something wrong with saving data in XML file :(" + ConsoleColors.RESET);
            e.printStackTrace();
        }
    }
}
