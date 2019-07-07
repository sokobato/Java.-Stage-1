package ru.geekbrains.lessons.e;

public class Dog extends Animal{

    protected int power = 500;
    protected float highjump = 0.5f;
    protected int powerswim = 10;

    public Dog(int age, String color, String name){
        super(age, color, name);
    }

    public Dog(int age, String color, String name, int minpower, int maxpower, float highjump){
        super(age, color, name, minpower, maxpower, highjump);
        power = super.power;
    }

    @Override
    public void voice(){
        System.out.println(name + " woof-woof");
    }

}
