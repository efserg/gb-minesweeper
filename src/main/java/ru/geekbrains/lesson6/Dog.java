package ru.geekbrains.lesson6;

public class Dog extends Animal {

    private static int dogCount;

    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    protected int getSwimLimit() {
        return SWIM_LIMIT;
    }

    @Override
    protected int getRunLimit() {
        return RUN_LIMIT;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
