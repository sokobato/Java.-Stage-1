package ru.geekbrains.lessons.e;

public class Bird extends Animal{

    protected int power = 5;
    protected float highjump = 0.2f;

    public Bird(int age, String color, String name){
        super(age, color, name);
    }

    public Bird(int age, String color, String name, int minpower, int maxpower, float highjump){
        super(age, color, name, minpower, maxpower, highjump);
        power = super.power;
    }

    @Override
    public void voice(){
        System.out.println(name + " tweet tweet tweet");
    }

    @Override
    public String swim(int distance){
        return name + " cannot swim";
    }

}
