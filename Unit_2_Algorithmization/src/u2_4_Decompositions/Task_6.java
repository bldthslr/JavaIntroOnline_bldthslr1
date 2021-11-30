package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми."
 *
 * Числа a, b, c считываются из потока ввода. Эти числа должны быть целыми.
 * Числа взаимно простые, если их общий НОД = +-1.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_6 {
    public static void main(String[] args) {
        // Считаем a, b, c из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number a: ");
        int a = in.nextInt();
        System.out.print("Input second number b: ");
        int b = in.nextInt();
        System.out.print("Input first number a: ");
        int c = in.nextInt();
        in.close();

        //Выведем результат на экран
        boolean res = isMutuallyPrime(a,b,c);
        if (res) {
            System.out.println("The numbers are mutually prime");
        }
        else {
            System.out.println("The numbers are NOT mutually prime");
        }
    }

    /**
     * Метод нахождения наибольшего общего делителя 2 целых чисел.
     * @param a - перове число
     * @param b - второе число
     * @return - НОД(a,b)
     */
    public static int nod(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while ((a != 0) && (b != 0)) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        return a + b;
    }

    /**
     * Метод проверяет, являются ли три числа взаимно простыми. Возвращает true или false.
     * @param a - первое число
     * @param b - второе число
     * @param c - третье число
     * @return - true, если числа взаимно простые, и false - если не взаимно простые
     */
    public static boolean isMutuallyPrime(int a, int b, int c) {
        return nod(nod(a, b), c) ==  1;
    }
}
