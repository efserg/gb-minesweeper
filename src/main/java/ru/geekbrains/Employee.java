package ru.geekbrains;

public class Employee {
    private String name;
    private Position position;
    private String email;
    private String phone;
    private double bonus;
    private int age;

    public Employee(String name, Position position, String email, String phone, double bonus, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.bonus = bonus;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", bonus=" + bonus +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return position.getSalary() * this.bonus;
    }
}
