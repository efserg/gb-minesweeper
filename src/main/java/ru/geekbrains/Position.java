package ru.geekbrains;

public enum Position {
    ACCOUNTANT("Бухгалтер", 1000),
    HR("Отдел кадров", 1500),
    BOSS("Директор", 10000),
    ENGINEER("Инженер", 5000),
    PROGRAMMER("Программист", 100000);

    private String russianName;
    private int salary;

    Position(String russianName, int salary) {
        this.russianName = russianName;
        this.salary = salary;
    }

    public String getRussianName() {
        return russianName;
    }

    public int getSalary() {
        return salary;
    }
}
