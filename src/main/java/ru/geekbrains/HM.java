package ru.geekbrains;

import java.util.Arrays;

public class HM {

    public static void main(String[] args) {
        Employee employee1 = new Employee("name1", Position.ENGINEER, "t@t.ru", "1234", 123.2, 30);

        Employee[] employees = {
                employee1,
                new Employee("name2", Position.ACCOUNTANT, "t@t.ru", "1234", 1.2, 41),
                new Employee("name3", Position.ENGINEER, "t@t.ru", "1234", 2, 28),
                new Employee("name4", Position.BOSS, "t@t.ru", "1234", 1., 50),
                new Employee("name4", Position.PROGRAMMER, "t@t.ru", "1234", .9, 50),
        };

        Arrays.stream(employees)
                .filter(employee -> employee.getAge() > 40)
                .forEach(employee -> System.out.println(employee.toString()));

    }

}
