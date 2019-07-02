package ru.geekbrains.lessons.e;

import java.util.Random;

abstract class Animal extends Object{

    //3. У каждого животного есть ограничения на действия
    protected String name;
    protected int age;
    protected String color;
    protected int power;
    protected float highjump;
    protected int powerswim;

    public Animal(int age, String color, String name) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public Animal(int age, String color, String name, int power, float highjump, int powerswim) {
        this.age = age;
        this.name = name;
        this.color = color;
        this.power = power;
        this.highjump = highjump;
        this.powerswim = powerswim;
    }

    public Animal(int age, String color, String name, int minpower, int maxpower, float highjump) {

        Random random = new Random();

        this.age = age;
        this.name = name;
        this.color = color;
        // 5. Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
        this.power = random.nextInt((maxpower - minpower) + 1) + minpower;
        this.highjump = highjump;
    }

    public final String getName() {
        return name;
    }

    protected void move() {
        System.out.println(name + " walks on paws");
    }

    public abstract void voice();

    //2 . Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.

    protected String run(int distance){
        if (power >= distance)
            return name + " is running " + distance + ".";
        else
            return name + " cannot run. The distance " + distance + " is very long.";
    }

    protected String swim(int distance){
        if (powerswim >= distance)
            return  name + " is swimming " + distance + ".";
        else
            return name + " cannot swim. The distance " + distance + " is very long.";
    }

    protected String jump(float high) {
        if (highjump >= high)
            return name + " is jumping " + high + ".";
        else
             return name + " cannot jump. This height " + high + " is too high";
    }

}
