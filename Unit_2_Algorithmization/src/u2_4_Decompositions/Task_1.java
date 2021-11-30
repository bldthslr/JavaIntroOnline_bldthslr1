package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
 * натуральных чисел".
 *
 * Числа а и b считываются из потока ввода.
 * Для нахождения НОД двух чисел используется алгоритм Евклида.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */
public class Task_1 {
    public static void main(String[] args) {
        // Считаем a, b из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number a: ");
        int a = in.nextInt();
        System.out.print("Input second number b: ");
        int b = in.nextInt();
        in.close();
        // Выведем результат
        System.out.println("The greatest common divisor: " + nod(a, b));
        System.out.println("The smallest common multiple: " + nok(a, b));
    }

    public static int nod (int a, int b) {
        while ((a != 0) && (b != 0)) {
            if (Math.abs(a) > Math.abs(b)) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        return a + b;
    }

    public static int nok (int a, int b) {
        return (a*b)/nod(a, b);
    }
}
