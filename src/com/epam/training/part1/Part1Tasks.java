package com.epam.training.part1;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Part1Tasks {

    //1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
    public double getTask1_1(double a, double b, double c) {
        return ((a - 3) * b / 2) + c;
    }

    //2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
    public double getTask1_2(double a, double b, double c) {
        if ((a == 0) || (b == 0)) {
            throw new IllegalArgumentException("a and b arguments should not equal zero");
        }
        return (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - a * a * a * c + 1 / (b * b);
    }

    //3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
    public double getTask1_3(double x, double y) {
        double b = (Math.cos(x) - Math.sin(y));
        if (b == 0) {
            throw new IllegalArgumentException("cos(x) - sin(y) equals 0");
        }
        double c = Math.cos(x * y);
        if (c == 0) {
            throw new IllegalArgumentException("cos(x*y) equals 0");
        }
        return ((Math.sin(x) + Math.cos(y)) / b) * Math.tan(x * y);
    }

    //4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
    //дробную и целую части числа и вывести полученное значение числа.
    public double getTask1_4(double a) {
        final int MAX_PART = 999;
        final int MIN_PART = 100;

        int intPart = (int) a;
        if ((intPart < MIN_PART) || (intPart > MAX_PART)) {
            throw new IllegalArgumentException(String.format("Integer part of a number should be " +
                    "greater than %d and lower than %d", MIN_PART, MAX_PART));
        }
        int fractionPart = (int) ((a - intPart) * (MAX_PART + 1));
        if ((fractionPart < MIN_PART) || (fractionPart > MAX_PART)) {
            throw new IllegalArgumentException(String.format("Fractional part of a number should be " +
                    "greater than %d and lower than %d", MIN_PART, MAX_PART));
        }
        return fractionPart + (double) intPart / (MAX_PART + 1);
    }

    //5 Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
    //данное значение длительности в часах, минутах и секундах в следующей форме:
    //ННч ММмин SSc.
    public String getTask1_5(int timeInSeconds) {
        if (timeInSeconds < 0) {
            throw new IllegalArgumentException("Time should be greater than zero");
        }
        int hours = timeInSeconds / 3600;
        int mins = (timeInSeconds - hours * 3600) / 60;
        int secs = timeInSeconds - hours * 3600 - mins * 60;

        //вариант №1
        //DecimalFormat fmt = new DecimalFormat("00");
        //return String.format("%sч %sмин %sс", fmt.format(hours), fmt.format(mins), fmt.format(secs));

        //вариант №2
        class TimeFormat {
            String format(int timePart) {
                if (timePart > 9) {
                    return Integer.toString(timePart);
                } else {
                    return "0".concat(Integer.toString(timePart));
                }
            }
        }
        TimeFormat fmt = new TimeFormat();
        return String.format("%sч %sмин %sс", fmt.format(hours), fmt.format(mins), fmt.format(secs));
    }

    //6. Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
    //принадлежит закрашенной области, и false — в противном случае:
    public boolean getTask1_6(double x, double y) {
        boolean belongs = ((y > 0) && (y <= 4) && (x >= -2) && (x <= 2));
        belongs = belongs || ((y >= -2) && (y <= 0) && (x >= -4) && (x <= 4));
        belongs = belongs && (!((x == 0) && (y == -1))); //возможно, непонятный артефакт на картинке, но похоже, что точку
        // (0, -1) нужно исключить
        return belongs;
    }

    //Ветвления

    //1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
    //он прямоугольным.
    public void task2_1(int angleA, int angleB) {
        if ((angleA <= 0) || (angleB <= 0) || (angleA + angleB >= 180)) {
            System.out.println("It's not a triangle");
        } else if (angleA + angleB == 90) {
            System.out.println("It's a right triangle");
        } else {
            System.out.println("It's a regular triangle");
        }
    }

    //2. Найти max{min(a, b), min(c, d)}
    public int getTask2_2(int a, int b, int c, int d) {
        int p1;
        int p2;
        p1 = a > b ? b : a;
        p2 = c > d ? d : c;
        return p1 > p2 ? p1 : p2;
    }

    //3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
    public boolean getTask2_3(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Point should not be null");
        }
        if (a.equals(b) || a.equals(c) || b.equals(c)) { //через 2 точки всегда можно провести прямую и притом только одну
            return true;
        }
        double px;
        double py = 0;
        if (b.y != a.y) {
            py = (double) (c.y - a.y) / (b.y - a.y);
        }
        if (a.x != b.x) {
            px = (double) (c.x - a.x) / (b.x - a.x);
        } else {
            return py == c.x;
        }
        if (a.y == b.y) {
            return px == c.y;
        }
        return px == py;
    }

    //4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
    //отверстие.
    public boolean getTask2_4(double a, double b, double x, double y, double z) {
        //
        double minSide1 = x > y ? y : x;
        double minSide2 = 0;
        if (minSide1 == x) {
            minSide2 = y > z ? z : y;
        } else {
            minSide2 = x > z ? z : x;
        }
        return ((minSide1 <= a) && (minSide2 <= b)) || ((minSide1 <= b) && (minSide2 <= a));
        //не рассмотрен случай размещения кирпича по диагонали прямоугольного отверстия
    }

    //   5. Вычислить значение функции
    public double getTask2_5(double x) {
        if (x <= 3) {
            return x * x - 3 * x + 9;
        } else {
            return 1 / (x * x * x + 6);
        }
    }

    // Циклы
    //1. Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
    //все числа от 1 до введенного пользователем числа.
    public void task3_1() {
        Scanner scanner = new Scanner(System.in);
        long lEnd = 0;
        do {
            System.out.println("Enter whole positive numeric: ");
            try {
                lEnd = scanner.nextLong();
                if (lEnd <= 0) {
                    System.out.println("Is not positive. Try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input. Try again.");
                scanner.next();
            }
        } while (true);
        long sum = 0;
        for (long l = 1; l <= lEnd; l++) {
            sum += l;
        }
        System.out.println(String.format("Sum of numbers from 1 to %d is: %d", lEnd, sum));
    }

    // Вычислить значения функции на отрезке [а,b] c шагом h:
    public void task3_2() {
        double a = -10.0;
        double b = 12.23;
        double h = 0.1;
        double y;

        double cVal = a;
        do {
            if (cVal > 2) {
                y = cVal;
            } else {
                y = -cVal;
            }
            cVal += h;
            System.out.println(y);
        } while (cVal <= b);
    }

    //Найти сумму квадратов первых ста чисел.
    public void task3_3() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j += i * i;
        }
        System.out.println(j);
    }

    //Составить программу нахождения произведения квадратов первых двухсот чисел.
    public void task3_4() {
        double j = 1;
        int pow = 0;
        for (int i = 1; i <= 200; i++) {
            double k = i * j;
            if (Double.isInfinite(k)) {     //если произведение большое, то выделяем и суммируем степени 10
                int cPow = (int) Math.log10(j);
                j = j / Math.pow(10, cPow);
                pow += cPow;
                j *= i;
            } else
                j = k;
        }
        int cPow = (int) Math.log10(j);
        j = j / Math.pow(10, cPow);
        //возводим в квадрат, тк произведение квадратов равно квадрату произведений,
        //ранее посчитали произведение без квадратов
        j *= j;
        pow = (pow + cPow) * 2;  //умножаем на 2, т.к. нужно возводить в квадрат
        System.out.println(String.format("%fE%d", j, pow));
    }

    ///5. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
    //заданному е. Общий член ряда имеет вид:
    public void task3_5() {
        double e = 0.0012345;
        double sum = 0;
        double emt = 0;
        int n = 1;
        do {
            sum += emt;
            emt = 1 / (Math.pow(2, n)) + 1 / (Math.pow(3, n));
            n++;
        } while (emt >= e);

        System.out.println(sum);
    }

    //6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
    public void task3_6() {
        for (char i = 1; i < 255; i++) {
            System.out.println(String.format("%s = %d", i, (int) i));
        }
    }

    //7.  Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
    //    m и n вводятся с клавиатуры.
    public void task3_7() {
        Scanner scanner = new Scanner(System.in);
        int m;
        int n;
        do {
            try {
                System.out.println("Enter 2 numbers above zero:");
                m = scanner.nextInt();
                n = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input. Try again.");
                scanner.next();
            }
        } while (true);
        int iMax = m > n ? m : n;
        int iMin = m == iMax ? n : m;
        for (int i = iMin; i <= iMax; i++) {
            int q = (int) Math.sqrt(i);
            System.out.print(String.format("Делители для %d: ", i));
            String delimiter = "";
            for (int j = 2; j <= q; j++) {
                if (i % j == 0) {
                    int d = i / j;
                    if (d != j) {
                        System.out.print(String.format("%s%d, %d", delimiter, j, d));
                    } else {
                        System.out.println(String.format("%s%d", delimiter, j));
                    }
                    delimiter = ", ";
                }
            }
            System.out.println("");
        }
    }

    //8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
    public void task3_8(int n, int m) {
        String sn = Integer.toString(n);
        String sm = Integer.toString(m);
        String sRes = "";
        for (int i = 0; i < sn.length(); i++) {
            int j = 0;
            while (j < sm.length()) {
                if ((sn.charAt(i) == sm.charAt(j)) && (!sRes.contains(sn.charAt(i) + ""))) {
                    sRes += String.format("%s;", sn.charAt(i));
                    break;
                } else {
                    j++;
                }
            }
        }
        System.out.println(sRes);
    }
}
