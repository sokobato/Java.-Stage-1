package ru.geekbrains.lessons.e;

public class Cat extends Animal{

    //3. У каждого животного есть ограничения на действия
    protected int power = 200;
    protected float highjump = 2.0f;

    public Cat(int age, String color, String name){
        super(age, color, name);
    }

    public Cat(int age, String color, String name, int minpower, int maxpower, float highjump){
        super(age, color, name, minpower, maxpower, highjump);
        // 5. Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
        power = super.power;
    }

    @Override
    public void voice(){
        System.out.println(name + " meows");
    }


    @Override
    public String swim(int distance){
        return name + " cannot swim";
    }

}
