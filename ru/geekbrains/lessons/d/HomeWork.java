package ru.geekbrains.lessons.d;

import java.util.ArrayList;

public class HomeWork {

    public static void main(String[] args) {

        // создам список с жесткой типизацией
        ArrayList<Employee> employees = new ArrayList<>(5);

        employees.add(new Employee("Ivanov Denis Petrovich", 35, "Senjor Java Developer", "113114", 160000));
        employees.add(new Employee("Petrov Ivan Ivanovich", 46, "Senjor Java Developer", "113114", 160000));
        employees.add(new Employee("Lenstal Boris Alexandrovich", 50, "Senjor Java Developer", "113114", 160000));
        employees.add(new Employee("Lepin Artem Bahirovich", 25, "Junior Java Developer", "113114", 60000));
        employees.add(new Employee("Korol Jamsut Ravshanovich", 30, "Middle Java Developer", "113114", 100000));

        // тестируем наши табельные номера
        for (Employee emp : employees) {
            System.out.println("Employee name " + emp.getFullName() + "; id: " + emp.getId());
        }
        System.out.println(" ");

        //System.out.println("ArrayList has %d elements \n", employees.size());

        /* 4. Вывести при помощи методов из пункта 3 ФИО и должность. */
        printStaff(employees);

        System.out.println(" ");

        /* 5. Создать массив из 5 сотрудников. С помощью цикла вывести
        информацию только о сотрудниках старше 40 лет*/
        printEmployeesOverAge(employees,40);

    }

    /* 4. Вывести при помощи методов из пункта 3 ФИО и должность. */
    static void printStaff(ArrayList<Employee> employees) {
        System.out.println("My staff:");
        for (Employee emp : employees) {
            // System.out.println("Employee: " + emp.getFullName() + ", position: " + emp.getPosition());
            System.out.println(emp.getEmployeeStaff());
        }
    }

    /* 5. Создать массив из 5 сотрудников. С помощью цикла вывести
    информацию только о сотрудниках старше 40 лет*/
    static void printEmployeesOverAge(ArrayList<Employee> employees, int conditionAge){
        System.out.println("Employee over " + conditionAge + " year age:");
        ArrayList<Employee> empOverAge = Employee.getEmployeOverAge(employees, conditionAge);
        for (Employee emp : empOverAge) {
             System.out.println("Employee: " + emp.getFullName() + "; age: " + emp.getAge());
        }

    }

}

