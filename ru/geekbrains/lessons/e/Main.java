package ru.geekbrains.lessons.e;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        Animal[] animals = {new Bird(1, "broun", "Kazar", 1, 4,  0.2f)
                           ,new Bird(1, "gray", "Fronur")
                           ,new Cat(2, "gray", "Barsik")
                           ,new Dog(5, "white", "Chester", 500, 700, 0.5f)
                           ,new Horse(10, "black", "BlackWood")};

        for (Animal animal:animals) {
            //4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
            System.out.println(animal.run(random.nextInt((2000 - 2) + 1) + 2));
            System.out.println(animal.swim(random.nextInt((100 - 10) + 1) + 10));
            System.out.println(animal.jump(0.3f));
        }

    }

}
