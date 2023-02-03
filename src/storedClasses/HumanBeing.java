package storedClasses;

import java.util.HashSet;

public class HumanBeing {

    private Long id; // Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private final java.time.LocalDate creationDate; // Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    private double impactSpeed;
    private WeaponType weaponType; // Поле не может быть null
    private Mood mood; // Поле не может быть null
    private Car car; // Поле может быть null

    private HashSet<Long> usedID = new HashSet<>();

    public HumanBeing(String name, Car car, Mood mood, WeaponType weaponType, Coordinates coordinates) {
        this.name = name;
        this.car = car;
        this.mood = mood;
        this.weaponType = weaponType;
        this.coordinates = coordinates;

        creationDate = java.time.LocalDate.now();

        Long randomId = (long) Math.floor(Math.random() * ((int) 1e9));
        while (usedID.contains(randomId)) {
            randomId++;
        }
        usedID.add(randomId);
        id = randomId;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isRealHero() {
        return realHero;
    }

    public void setRealHero(boolean realHero) {
        this.realHero = realHero;
    }

    public double getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(double impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
