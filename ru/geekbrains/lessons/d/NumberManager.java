package ru.geekbrains.lessons.d;

import java.util.concurrent.atomic.AtomicLong;

/*7. При создании экземпляра класса Сотрудник присваивать
        ему уникальный порядковый номер */
public class NumberManager {
    //Будем вести свои табельные от 1 до +
    private static AtomicLong currentValue = new AtomicLong(1L);
    public static long getNextValue() {
        return currentValue.getAndIncrement();
    }
}