package ru.geekbrains.lesson6;

public class Fish extends Animal {

    public static final int SWIM_LIMIT = 10000;

    public Fish(String name) {
        super(name);
    }

    @Override
    protected int getSwimLimit() {
        return SWIM_LIMIT;
    }

    @Override
    protected int getRunLimit() {
        return 0;
    }
}
