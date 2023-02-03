package storedClasses;

public class Car {
    private String name; // Поле может быть null
    private Boolean cool; // Поле может быть null

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCool() {
        return cool;
    }

    public void setCool(Boolean cool) {
        this.cool = cool;
    }

    @Override
    public String toString() {
        return String.format("Object Car. Name: %s. Cool: %b", name, cool);
    }
}