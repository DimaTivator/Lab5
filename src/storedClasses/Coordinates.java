package storedClasses;

import exceptions.InvalidCoordinatesException;

public class Coordinates implements Comparable<Coordinates> {
    private double x; // Максимальное значение поля: 487
    private Float y; // Значение поля должно быть больше -703, Поле не может быть null

    public Coordinates(double x, Float y) throws InvalidCoordinatesException {
        if (x > 487 || y <= -703) {
            throw new InvalidCoordinatesException();
        }
        this.x = x;
        this.y = y;
    }

    public Coordinates() {}

    public double getX() {
        return x;
    }

    public void setX(double x) throws InvalidCoordinatesException {
        if (x > 487) {
            throw new InvalidCoordinatesException();
        }
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) throws InvalidCoordinatesException {
        if (y <= -703) {
            throw new InvalidCoordinatesException();
        }
        this.y = y;
    }

    @Override
    public int compareTo(Coordinates obj) {
        int result = Double.compare(this.x, obj.x);
        if (result == 0) {
            result = this.y.compareTo(obj.y);
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}