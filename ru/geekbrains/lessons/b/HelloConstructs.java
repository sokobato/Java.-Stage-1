package ru.geekbrains.lessons.b;

import java.util.Arrays;
import java.util.Scanner;

public class HelloConstructs {
    private static int power(int base, int significative) {
        int result = 1;
        for (int i = 0; i < significative; i++) {
            result *= base;
        }
        return result;
    }
    private static void printPifagor(int width, int height) {
        for (int y = 1; y < height; y++) {
            for (int x = 1; x < width; x++) {
                System.out.print(x * y + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        String line = s.nextLine();
        int in = s.nextInt();
        double dbl = s.nextDouble();
        float fl = s.nextFloat();
        System.out.println(str);

        int a = 0;
        int b = 0;
        int c;
//        if (a > b) {
//            c = a;
//        } else {
//            c = b;
//        }
//        c = (a > b) ? a : b;
//        System.out.println(c);
//        String name = "Саша";
////        if (name == "Ваня") {
////            System.out.println("25");
////        } else if (name == "Петя") {
////            System.out.println("15");
////        } else {
////        }
////
////        switch (name) {
////            case "Ваня":
////                System.out.println("отправили на рабочее мето №25");
////                break;
////            case "Петя":
////                System.out.println("отправили на рабочее мето №15");
////                break;
////            default:
////                System.out.println("оставили во входящих");
////                break;
////            case "Саша":
////                System.out.println("отправили на рабочее мето №5");
////                break;
////
////        }
////        // int = 0;
////        for (int i = 0; i < 10; i++) /*i < 10*/{
////            System.out.println(i);
////        /*i++*/ /*back to check*/} //further program
//        System.out.println(power(2, 10));
//        printPifagor(10, 10);
//        for(;;) {
//            //infinity
//        }
        while (a < 10) {
            a++;
            if (a == 5 || a == 7) continue;
            System.out.print(a + " ");
        }
        System.out.println();
        do {
            b++;
            System.out.print(b + " ");
            if (b == 5) break;
        } while (true);
        System.out.println();

        int[] arr; //null
        arr = new int[10];
        initArray(arr);

        printValues(1, 2, 3, 4, 5, 6, 7);

        printValues(arr);
        //System.out.println(Arrays.toString(arr));

        String words[] = {"Hello", null, "Java", null, "World"};

        byte b1[][] = new byte[3][];
        b1[0] = new byte[4];
        b1[1] = new byte[7];
        b1[2] = null;
    }

    private static void printValues(int... a) { // int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void initArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }
    /*
    1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в
    принятом массиве 0 на 1, 1 на 0;

	2 Задать пустой целочисленный массив размером 8. Написать метод,
	который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;

	3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
	принимающий на вход массив и умножающий числа меньше 6 на 2;

	4 Задать одномерный массив. Написать методы поиска в нём
	минимального и максимального элемента;

	5 * Создать квадратный целочисленный массив
	(количество строк и столбцов одинаковое), заполнить его диагональные
	элементы единицами, используя цикл(ы);

	6 ** Написать метод, в который передается не пустой одномерный
	целочисленный массив, метод должен вернуть true если в массиве есть
	место, в котором сумма левой и правой части массива равны. Примеры:
	checkBalance([1, 1, 1, || 2, 1]) → true,
	checkBalance ([2, 1, 1, 2, 1]) → false,
	checkBalance ([10, || 1, 2, 3, 4]) → true.
	Абстрактная граница показана символами ||, эти символы в массив не входят.

	7 *** Написать метод, которому на вход подаётся одномерный массив и
	число n (может быть положительным, или отрицательным), при этом метод
	должен циклически сместить все элементы массива на n позиций.
	[1,2,3,4,5], -2 => [3,4,5,1,2]
	[1,2,3,4,5], 2 => [4,5,1,2,3]

	8 **** Не пользоваться вспомогательным массивом при решении задачи 7.

    * */
}
