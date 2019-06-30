package ru.geekbrains.lessons.d;

import java.util.ArrayList;

/*

1. Создать класс "Сотрудник" с полями: ФИО,
должность, телефон, зарплата, возраст;

2 Конструктор класса должен заполнять эти поля при создании
объекта;

*/

public class Employee {

    private long id;
    private String fullName;
    private int age;
    private String position;
    private  String telephone;
    private int salary;

    public Employee(){

        /*7. При создании экземпляра класса Сотрудник присваивать
        ему уникальный порядковый номер */

        /* Возможно это несовсем та реализация, но я ведь могу создавать объекты в разных потоках...
        Thread поток1 = new Thread();
        поток1.start(); ... */

        id = NumberManager.getNextValue();
    }

    public Employee(String fullName, int age, String position, String telephone, int salary){
        this();
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.telephone = telephone;
        this.salary = salary;
    }

    /* 3. Внутри класса «Сотрудник» написать методы, которые
    возвращают значение каждого поля; */

    public long getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void changeSalary(int surcharge) {
        this.salary = getSalary() + surcharge;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmployeeStaff() {
        return "Employee: " + fullName + ", position: " + position;
    }

    static ArrayList<Employee> getEmployeOverAge(ArrayList<Employee> employees, int conditionAge){

        ArrayList<Employee> empOverAge = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getAge() > conditionAge) empOverAge.add(emp);
        }

        return empOverAge;

    }




}
