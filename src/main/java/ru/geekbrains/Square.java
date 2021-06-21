package ru.geekbrains;

public class Square extends Circle {

    public Square(int centerX, int centerY, Color color, int radius) {
        super(centerX, centerY, color, radius);
    }

    @Override
    public float square() {
        return getRadius() * getRadius();
    }

    @Override
    public void draw() {
        System.out.println("******");
        System.out.println("**  **");
        System.out.println("******");
    }

    public String info() {
        return "Квадрат";
    }


    @Override
    public String toString() {
        return "Square{" +
                "radius=" + getRadius() +
                '}';

    }
}
