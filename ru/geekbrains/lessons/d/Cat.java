package ru.geekbrains.lessons.d;

public class Cat {

    static class CatsHead{
        static int earsAmount;
        static int eyesAmount;
        static String eyesColor;
    }

    //свойства (характеристики, атрибуты). Все 3 переменные - поля класса.

    static int paws = 4;

    String name;
    private int age;
    private String color;

    Cat(){
        age = 0;
        voice();
        name = "";
        color = "grey";
    }

    Cat(int age, String color, String name) {
        this.age = age;
        this.color = color;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    static void voice() {
        System.out.println("cat meows");
    }

    void jump() {
        if (age < 5) {
            System.out.println(name + " jumps");
        }
    }
}
