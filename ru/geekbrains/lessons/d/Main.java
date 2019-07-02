package ru.geekbrains.lessons.d;

public class Main {
    public static void main(String[] args) {
        Cat c0 = new Cat(1, "Black", "Barsik");
        Cat c1 = new Cat(5,"Black", "Murzik");

        System.out.println(c0.name);
        System.out.println(c0.getColor());

        /* c0.age = 1;
        c0.name = "Barsik";
        c0.color = "White";

        c1.age = 5;
        c1.name = "Murzik";
        c1.color = "Black"; */

        System.out.println("cat color = " + c0.getColor());
        System.out.println("cat color = " + c1.getColor());

        c0.jump();
        c1.jump();

        Cat.voice();

        System.out.println(Cat.CatsHead.earsAmount);
        System.out.println(Cat.paws);

    }
}
