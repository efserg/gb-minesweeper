package ru.geekbrains;

public class Canvas {
    public static final int CANVAS_SIZE = 10;
    private Shape[] shapes;

    public Canvas() {
        this.shapes = new Shape[CANVAS_SIZE];
    }

    public void addShape(Shape shape) {
        int i = 0;
        while (i < CANVAS_SIZE && shapes[i] != null) {
            i++;
        }
        if (i >= CANVAS_SIZE) {
            i = 0;
        }

        shapes[i] = shape;
    }

    public void draw() {
        for (Shape shape : shapes) {
            if (shape == null) {
                continue;
            }
            shape.draw();
        }
    }
}
