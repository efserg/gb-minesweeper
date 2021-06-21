package ru.geekbrains.lesson6;

public abstract class Animal {

    private final String name;
    private static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int length) {
        if (getRunLimit() == 0) {
            System.out.printf("%s не умеет бегать!\n", name);
            return;
        }

        if (length >= 0 && length <= getRunLimit()) {
            System.out.printf("%s пробежал %d м.\n", name, length);
        }
    }

    public void swim(int length) {
        if (getSwimLimit() == 0) {
            System.out.printf("%s не умеет плавать!\n", name);
            return;
        }
        if (length >= 0 && length <= getSwimLimit()) {
            System.out.printf("%s проплыл %d м.\n", name, length);
        }
    }

    public static int getCount() {
        return count;
    }

    protected abstract int getSwimLimit();

    protected abstract int getRunLimit();

}
