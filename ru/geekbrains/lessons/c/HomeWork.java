package ru.geekbrains.lessons.c;


import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '*';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final int DIMENSION = 3;
    private static char[][] field;

    public static void main(String[] args){
        runGameTicTakToe();
    }

    private static void runGameTicTakToe() {

        //Меню для мню
        System.out.println(" ");
        System.out.println("Меню:");
        System.out.println("1. Играть в крестики нолики");
        System.out.println("2. Выход");
        System.out.print("Введите одно из значений: ");

        // есть че по ответам ...
        int answer = getCorrectIntAnswerUser(1,2, "Введите одно из значений: ");
        //моя игрока не хотеть играть ...
        if (answer != 1) System.exit(0);

        //Начальная инициализация
        initMap();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Игровое поле:");
        printMap();

        int i = -1;

        // Мега цикл... да прожарим ядра железа
        do {i++;
            System.out.println(" ");
            if ((i % 2) == 0) {
                System.out.println("Ход игрока:");
                humanTurn();
            } else {
                System.out.println("Ход компьютера:");
                aiTurn();
            }
            printMap();
            // ну не бесконечный же
            if (((DIMENSION * DIMENSION) * 3) < i) break;
        } while (!isGameOver());
    }

    /* Инициализация поля - наше с занятия, модифицированное */
    private static void initMap() {
        field = new char[DIMENSION][DIMENSION];
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                field[x][y] = EMPTY_DOT;
            }
        }
    }

    /* Печатаем поле - наше с занятия, модифицированное */
    private static void printMap() {
        for (int x = 0; x <= DIMENSION; x++) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x = 0; x < DIMENSION; x++) {
            System.out.print((x + 1) + " ");
            for (int y = 0; y < DIMENSION; y++) {
                System.out.print(field[x][y] + " ");
            }
            System.out.println();
        }
    }

    /* Защита от игрока (дурака) - наше с занятия, модифицированное */
    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < DIMENSION && y >= 0 && y < DIMENSION;
    }

    /* Проверка на пустую ячейку - наше с занятия, модифицированное */
    private static boolean isEmptyCell(int x, int y) {
        return field[x][y] == EMPTY_DOT;
    }

    /* Проверка что поле забито - наше с занятия, модифицированное */
    private static boolean isMapFull() {
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                //if (field[x][y] == EMPTY_DOT) return false;
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    /* Обработчик хода игрока - наше с занятия, модифицированное */
    private static void humanTurn() {
        int x;
        int y;
        String mess = "Введите координаты хода X и Y (от 1 до " + DIMENSION + ") через пробел >>";
        do {
            System.out.println(mess);
            x = getCorrectIntAnswerUser(1, DIMENSION, mess) - 1;
            y = getCorrectIntAnswerUser(1, DIMENSION, mess) - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[x][y] = HUMAN_DOT;
        //System.out.println(x + " " + y + " ");
    }

    public static void aiTurn() {

        int[] argstep = {0,0};

        // 5 к 6, что захотим потопить игрока нафиг:)
       int variant = RANDOM.nextInt(6);

       if (variant == 0) {

           setDotRandomStep(AI_DOT);

       } else {

           boolean userwinstep = false;
           boolean aiwinstep = false;

           //Ищем свою выигрышную комбинацию
           aiwinstep = searchWinStep(argstep, AI_DOT);

           if (aiwinstep) {
               field[argstep[0]][1] = AI_DOT;
           } else {
               userwinstep = searchWinStep(argstep, HUMAN_DOT);
               if (userwinstep){
                   field[argstep[0]][argstep[1]] = AI_DOT;
               } else {
                   setDotRandomStep(AI_DOT);
               }
           }
       }
    }

    /* Пытаемся найти выигрышную комбинацию */
    static boolean searchWinStep(int argstep[], char dot){
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                if (isEmptyCell(x, y)) {
                    field[x][y] = dot;
                    boolean check = checkWin(dot);
                    field[x][y] = EMPTY_DOT;
                    if (check) {
                        argstep[0] = x;
                        argstep[1] = y;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* Делаем рандомный шаг */
    static void setDotRandomStep(char dot){
        int x = 0;
        int y = 0;
        do {
            x = RANDOM.nextInt(DIMENSION - 1);
            y = RANDOM.nextInt(DIMENSION - 1);
        } while (!isEmptyCell(x, y));
        field[x][y] = dot;
    }

    /* нужно добиться ответа от игрока .. путь выживет сильнейший */
    private static int getCorrectIntAnswerUser(int minvalue, int maxvalue, String message) {
        int answer = 0;
        while (true) {
            if (SCANNER.hasNextInt()) {
                answer = SCANNER.nextInt();
                if ((answer >= minvalue)&&(answer <= maxvalue)) break;
            } else {
                SCANNER.next();
            }
            //может быть упорная зараза и если больше 2х раз зайдет, можно расстреливать .... :)
            System.out.print(message);
        }
        return answer;
    }

    /* нужно проверить линии .. путь выживет сильнейший */
    public static boolean checkLine(int x, int y, int dx, int dy, char dot) {
        for (int i = 0; i < DIMENSION; i++) {
            if (field[x + i * dx][y + i * dy] != dot)
                return false;
        }
        return true;
    }

    /* Проверка выигрыша - просто полный .. спать хочу, 2:30 ночи, завтра на работу и занятие J.... O_o */
    public static boolean checkWin(char dot) {
        for (int i = 0; i < DIMENSION; i++) {
            // проверяем строки
            if (checkLine(i, 0, 0, 1, dot)) return true;
            // проверяем столбцы
            if (checkLine(0, i, 1, 0, dot)) return true;
        }
        // проверяем диагонали
        if (checkLine(0, 0, 1, 1, dot)) return true;
        if (checkLine(0, DIMENSION - 1, 1, -1, dot)) return true;
        return false;
    }

    private static boolean isGameOver() {

        if (isMapFull()) {
            System.out.print("Больше нет ходов");
            return true;
        }

        /* Да, победила пустота с первого хода ....
        if (checkWin(EMPTY_DOT)){
            System.out.print("Победила пустота ʕʘ‿ಠʔ");
            return true;
        }
         */

        if (checkWin(HUMAN_DOT)){
            System.out.print("Победил игрок ☺");
            return true;
        }

        // Я вот все думаю, может ☻ - это негр ....
        if (checkWin(AI_DOT)){
            System.out.print("Победил компьютер ☻");
            return true;
        }
        return false;
    }


    /* Чет непонятное с нашего урока .....

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (!isEmptyCell(y, x));
        field[y][x] = AI_DOT;
    }

    private static boolean checkWin(char c) {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }
     */
}

