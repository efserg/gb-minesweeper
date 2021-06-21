package ru.geekbrains.lesson6;

public class Cat extends Animal {

    private static final int RUN_LIMIT = 0;
    private static int catCount;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    protected int getSwimLimit() {
        return 0;
    }

    @Override
    protected int getRunLimit() {
        return RUN_LIMIT;
    }

    public static int getCatCount() {
        return catCount;
    }
}
