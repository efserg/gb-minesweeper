package ru.geekbrains;

public class Circle extends Shape { // наследник, дочерний класс, производный класс

    private int radius;

    public Circle(int centerX, int centerY, Color color, int radius) {
        super(centerX, centerY, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public float square() {
        return (float) 3.1415 * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("   **  ");
        System.out.println(" **  **  ");
        System.out.println("   **  ");
    }

    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle shape = (Circle) o;

        if (getCenterX() != shape.getCenterX()) return false;
        if (getCenterY() != shape.getCenterY()) return false;
        if (getRadius() != shape.getRadius()) return false;
        return getColor() != null ? getColor().equals(shape.getColor()) : shape.getColor() == null;
    }

}
