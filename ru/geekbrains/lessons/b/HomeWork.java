package ru.geekbrains.lessons.b;

import java.util.Random;
import java.util.Arrays;

import static java.lang.Math.abs;

public class HomeWork {

    public static void main (String[] args){

        /*
        1 Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в
        принятом массиве 0 на 1, 1 на 0;
        */

        //ограничения задачи: массив может быть только из 0 и 1
        int[] array = createRandomArray(12, 0,1);
        //System.out.println(Arrays.toString(array));
        replaceValueArray(array);
        //System.out.println(Arrays.toString(array));

         /*
         2 Задать пустой целочисленный массив размером 8. Написать метод,
         который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
         */

        int[] array1 = new int[8];
        fillElementPlusValuePrevious(array1, 3);
        //System.out.println(Arrays.toString(array1));

        /*
        3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
        принимающий на вход массив и умножающий числа меньше 6 на 2;
        */

        int[] array2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        replaceElementsMultiplying(array2, 6, 2);
        //System.out.println(Arrays.toString(array2));

        /*
        4 Задать одномерный массив. Написать методы поиска в нём
        минимального и максимального элемента;
        */

        // Можно конечно и через import java.lang.Math; Math.max()
        int array3[] = {-1,-2,-3,-4,-5,0,1,2,3,4,5};
        int min = findMinElement(array3);
        //System.out.println("Minimal element: " + min);
        int max = findMaxElement(array3);
        //System.out.println("Maximal element: " + max);

        /*
        5 * Создать квадратный целочисленный массив
        (количество строк и столбцов одинаковое), заполнить его диагональные
        элементы единицами, используя цикл(ы);
        */

        int array4[][] = new int[8][8];
        fillDiagonalElement(array4, 1);

        /*for(int i = 0; i < 8; i++){
            System.out.println();
                for(int k = 0; k < 8; k++){
                System.out.print(array4[i][k] + "\t");
                }
            }*/

        /*
        6 ** Написать метод, в который передается не пустой одномерный
        целочисленный массив, метод должен вернуть true если в массиве есть
        место, в котором сумма левой и правой части массива равны. Примеры:
        checkBalance([1, 1, 1, || 2, 1]) → true,
                checkBalance ([2, 1, 1, 2, 1]) → false,
                checkBalance ([10, || 1, 2, 3, 4]) → true.
                Абстрактная граница показана символами ||, эти символы в массив не входят.
        */

        int array5[] = {10, 1, 2, 3, 4};
        boolean isbalance = checkBalance(array5);
        //System.out.print(isbalance);

        /*
        7 *** Написать метод, которому на вход подаётся одномерный массив и
        число n (может быть положительным, или отрицательным), при этом метод
        должен циклически сместить все элементы массива на n позиций.
	    [1,2,3,4,5], -2 => [3,4,5,1,2]
	    [1,2,3,4,5], 2 => [4,5,1,2,3]

        8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
        */

        int araray6[] = {1,2,3,4,5};
        movElement(araray6, -2);
        //System.out.println(Arrays.toString(araray6));

    }

    /* принимаем указатель на массив из 0 и 1 и меняем значения с 0 на 1 и с 1 на 0 */
    static void replaceValueArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    /* принимаем указатель на массив и заполняем значения прибавлением указанного значения к предудущему */
    static void fillElementPlusValuePrevious (int[] array, int plusvalue) {

        for (int i = 0; i < array.length; i++) {
            array[i] = (i == 0) ? 1 : array[i-1] + plusvalue;
        }

    }

    /* принимаем указатель на массив и заменяем значения меньше условия на указанное значение */
    static void replaceElementsMultiplying (int[] array, int limit, int multip) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] < limit)  array[i] = array[i] * multip;
        }

    }

    /* принимаем указатель на массив и ищем минимальный элемент */
    static int findMinElement(int[] array) {
        int min = array[0];
        for (int i: array) {
            if(i < min) min = i;
        }
        return min;
    }

    /* принимаем указатель на массив и ищем максимальный элемент */
    static int findMaxElement(int[] array) {
        int max = array[0];
        for (int i: array) {
            if(i > max) max = i;
        }
        return max;
    }

    /* заполняем диаганали массива в котором количество строк и столбцов одинаково переданным значением */
    static void fillDiagonalElement(int[][] array, int fillvalue) {

        int alength = array.length;

        for (int i = 0; i < alength; i++) {
            array[i][i] = fillvalue;
            array[i][alength - 1 - i] = fillvalue;
        }

    }

    /* принимаем указатель и проверяем на возможное равенство сумм левой и правой частей */
    static boolean checkBalance(int[] array) {

        int sumleft = 0;
        int sumright = 0;

        for (int i = 0; i < array.length; i++) {

            sumleft += array[i];
            sumright = 0;

            for (int j = i + 1; j < array.length; j++) {
                sumright += array[j];
            }

            if (sumleft == sumright) return true;

        }

        return false;
    }

    /* перемещаем элементы массива на переданное число смещений */
    static void movElement(int[] array, int offset) {

        // найдем реальное количество смещений
        int length = array.length;
        final int finoffset = offset % length;

        for (int i = 0; i < abs(finoffset); i++) {
            int j = 0;
            if (finoffset < 0) {
                int temp = array[j];
                for (j = 0; j < length - 1; j++)
                    array[j] = array[j + 1];
                array[j] = temp;
            } else {
                int temp = array[length - 1];
                for (j = length - 1; j > 0; j--)
                    array[j] = array[j - 1];
                array[j] = temp;
            }

        }

    }

    /* создаем желаемый массив и инициализируем его элементы */
    static int[] createRandomArray(int size, int min, int max) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }

        return array;
    }

}