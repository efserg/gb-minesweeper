package ru.geekbrains.lesson6;

import java.util.Random;

public class Main {
    // 1. Создать классы Собака и Кот с наследованием от класса Животное.
    // 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    // 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
    // 4. * Добавить подсчет созданных котов, собак и животных.


    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Барсик"),
                new Dog("Мухтар"),
                new Cat("Мурзик"),
                new Cat("Пушок"),
                new Dog("Карат"),
                new Cat("Тимка"),
                new Fish("Треска"),
                new Fish("Флаундер")
        };

        Random random = new Random();

        for (Animal animal : animals) {
            animal.run(random.nextInt(300));
            animal.swim(random.nextInt(10));
        }

        System.out.println(Animal.getCount());
        System.out.println(Cat.getCatCount());
        System.out.println(Dog.getDogCount());
    }

}
