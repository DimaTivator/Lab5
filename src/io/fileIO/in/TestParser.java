package io.fileIO.in;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import auxiliaryClasses.ConsoleColors;
import exceptioins.InvalidCoordinatesException;
import exceptioins.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import storedClasses.*;

public class TestParser {

    public static LinkedHashMap<Long, HumanBeing> parseXML(String fileName) {

        LinkedHashMap<Long, HumanBeing> humanBeings = new LinkedHashMap<>();

        try {

            File inputFile = new File(fileName);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document doc = documentBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList humanBeingList = doc.getElementsByTagName("HumanBeings");

            for (int i = 0; i < humanBeingList.getLength(); i++) {

                Node humanBeingNode = humanBeingList.item(i);

                if (humanBeingNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element humanBeingElement = (Element) humanBeingNode;
                    NodeList humanBeingElements = humanBeingElement.getChildNodes();

                    for (int j = 0; j < humanBeingElements.getLength(); j++) {

                        Node humanBeing = humanBeingElements.item(j);

                        if (humanBeing.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) humanBeing;

//                            if (eElement.getElementsByTagName("name").getLength() == 0 ||
//                                    eElement.getElementsByTagName("x").getLength() == 0 ||
//                                    eElement.getElementsByTagName("y").getLength() == 0 ||
//                                    eElement.getElementsByTagName("mood").getLength() == 0 ||
//                                    eElement.getElementsByTagName("weaponType").getLength() == 0) {
//                                throw new ParseException("HumanBeing object must have fields name, coordinates, mood and weaponType initialized");
//                            }

                            String name = parseName(eElement);
                            // System.out.println(eElement.getElementsByTagName("coordinates").item(0).getChildNodes().item(1).getTextContent());
                            Coordinates coordinates = parseCoordinates((Element)eElement.getElementsByTagName("coordinates").item(i));

//                            double x = Double.parseDouble(eElement.getElementsByTagName("x").item(0).getTextContent());
//                            Float y = Float.parseFloat(eElement.getElementsByTagName("y").item(0).getTextContent());
//                            Coordinates coordinates = new Coordinates(x, y);
                            // TODO

                            boolean realHero = Boolean.parseBoolean(eElement.getElementsByTagName("realHero").item(0).getTextContent());
                            boolean hasToothpick = Boolean.parseBoolean(eElement.getElementsByTagName("hasToothpick").item(0).getTextContent());
                            double impactSpeed = Double.parseDouble(eElement.getElementsByTagName("impactSpeed").item(0).getTextContent());

                            WeaponType weaponType = WeaponType.valueOf(eElement.getElementsByTagName("weaponType").item(0).getTextContent());
                            Mood mood = Mood.valueOf(eElement.getElementsByTagName("mood").item(0).getTextContent());

                            Car car = new Car();

                            String carName;
                            String carNameTagContent = eElement.getElementsByTagName("name").item(1).getTextContent();
                            if (carNameTagContent.isEmpty()) {
                                carName = "";
                            } else {
                                carName = carNameTagContent;
                            }
                            car.setName(carName);

                            boolean cool;
                            try {
                                String coolTagContent = eElement.getElementsByTagName("cool").item(0).getTextContent();
                                cool = Boolean.parseBoolean(coolTagContent);
                                car.setCool(cool);
                            } catch (NullPointerException ignored) {}

                            HumanBeing obj = new HumanBeing(name, mood, weaponType, coordinates);

                            obj.setRealHero(realHero);
                            obj.setHasToothpick(hasToothpick);
                            obj.setImpactSpeed(impactSpeed);
                            obj.setCar(car);

                            humanBeings.put(obj.getId(), obj);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD + "Some troubles with xml file :(" + ConsoleColors.RESET);
            System.out.println(e.getMessage());
            e.getStackTrace();
        }

        return humanBeings;
    }

    private static String parseName(Element element) throws ParseException {
        if (element.getElementsByTagName("name").item(0).getTextContent().isEmpty()) {
            throw new ParseException("Name field can't be empty!");
        }
        return element.getElementsByTagName("name").item(0).getTextContent();
    }

    private static Coordinates parseCoordinates(Element element) throws ParseException, InvalidCoordinatesException {
        if (element.getElementsByTagName("x").getLength() != 1 || element.getElementsByTagName("y").getLength() != 1) {
            throw new ParseException("Some troubles with parsing coordinates :(");
        }

        Coordinates coordinates = new Coordinates();
        coordinates.setX(Double.parseDouble(element.getChildNodes().item(1).getTextContent()));
        coordinates.setY(Float.parseFloat(element.getChildNodes().item(3).getTextContent()));

        return coordinates;
    }

}