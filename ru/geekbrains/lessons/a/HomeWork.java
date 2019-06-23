package ru.geekbrains.lessons.a;

/**import java.util.GregorianCalendar; */

public class HomeWork {

    public static void main(String[] args) {

        double res = calcFunction(5,2,3,4);
        System.out.println(res);
        boolean res1 = checkSumInterval(5,4);
        System.out.println(res1);
        boolean res2 = checkSumInterval(5,10);
        System.out.println(res2);
        negativityNumber(-10);
        negativityNumber(-0);
        String myhello = helloName("Всея_галактики_и_иных_миров_и_цивилизаций");
        checkLeapYear(2017);
        checkLeapYear(2400);
    }

    /** returns the calculated value */
    private static double calcFunction(int a, int b, int c, int d) {
        double result =  a * (b + ((double) c / d));
        return result;
    }

    /** returns the check sum a and b beetwen 10 and 20 value */
    private static boolean checkSumInterval(int a, int b) {
        int sum = a + b;
        boolean result = sum <= 20 && sum >= 10;
        return result;
    }

    /** print check parametr <a> negativity or positivity */
    private static void negativityNumber(int a) {
        if (a < 0)
            System.out.println("число <" + a + "> отрицательно");
        else
            System.out.println("число <" + a + "> положительно");
     }

    /** print hello name name and return */
    private static String helloName(String name) {
        String result = "Привет, " + name + "!";
        System.out.println(result);
        return result;
    }

    /** print year is leap */
    private static void checkLeapYear(int year) {

        /** GregorianCalendar calendar = new GregorianCalendar(year, 12, 31);
        boolean leap = calendar.isLeapYear(year); */

        if ((( year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 == 0)))
            System.out.println("Год <" + year + "> високосный");
        else
            System.out.println("Год <" + year + "> невисокосный");

    }

}
