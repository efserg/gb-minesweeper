package ru.geekbrains;

public abstract class Shape {
    private int centerX;
    private int centerY;
    private Color color;

    public Shape(int centerX, int centerY, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract float square();

    public abstract void draw();

}
