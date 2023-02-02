package storedClasses;

public class HumanBeing {
    private Long id; // Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private java.time.LocalDate creationDate; // Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    private double impactSpeed;
    private WeaponType weaponType; // Поле не может быть null
    private Mood mood; // Поле не может быть null
    private Car car; // Поле может быть null
}
