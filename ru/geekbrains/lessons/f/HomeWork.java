package ru.geekbrains.lessons.f;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    private static String mainstring = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
    private static Random rnd = new Random();

    public static void main(String[] args) {

        FileManager fm = new FileManager();

        //1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом

        if (!fm.createFile("1.txt",createString(100))) {
            System.out.println(fm.getErrorMessage());
            return;
        }

        if (!fm.createFile("2.txt",createString(100))) {
            System.out.println(fm.getErrorMessage());
            return;
        }

        //2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        if (!fm.mergeFiles(new String[]{"1.txt","2.txt"}, "3.txt")) {
            System.out.println(fm.getErrorMessage());
            return;
        }

        //3. Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.

        int index = fm.serchInFile("3.txt","HP");
        if (index < 0) {
            System.out.println(fm.getErrorMessage());
            return;
        }else {
            System.out.println((index>0) ? "Позиция слова в файле " + index + 1  : "Слова в файле нет");
        }

        //4. ** Написать метод, проверяющий, есть ли указанное слово в папке

        int index1 = fm.findWordInFolder("C:\\java", "drop");
        if (index1 < 0) {
            System.out.println(fm.getErrorMessage());
            return;
        }else {
            System.out.println((index1>0) ? "Есть такое слово"  : "Нет такого слова");
        }

    }

    public static String createString(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++){
            sb.append(mainstring.charAt(rnd.nextInt(mainstring.length())));
        }
        return sb.toString();
    }



}
