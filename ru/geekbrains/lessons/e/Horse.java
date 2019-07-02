package ru.geekbrains.lessons.e;

public class Horse extends Animal{

    protected int power = 1500;
    protected float highjump = 3.0f;
    protected int powerswim = 100;

    public Horse(int age, String color, String name){
        super(age, color, name);
    }

    public Horse(int age, String color, String name, int minpower, int maxpower, float highjump){
        super(age, color, name, minpower, maxpower, highjump);
        power = super.power;
    }

    @Override
    public void voice(){
        System.out.println(name + " neigh-neigh");
    }

}
