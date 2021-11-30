package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел."
 *
 * Числа а, b, c, d считываются из потока ввода.
 * Для решения используем метод нахождения НОД из первой задачи (просто скопируем код и не будем делать вызов из класса).
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */
public class Task_2 {
    public static void main(String[] args) {
        // Считаем a, b, c, d из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number a: ");
        int a = in.nextInt();
        System.out.print("Input second number b: ");
        int b = in.nextInt();
        System.out.print("Input first number a: ");
        int c = in.nextInt();
        System.out.print("Input second number b: ");
        int d = in.nextInt();
        in.close();
        // Выведем результат на экран
        System.out.println("The greatest common divisor of four numbers: ");
        System.out.println(nodOfFour(a,b,c,d));
    }

    /**
     * Метод нахождения наибольшего общего делителя 2 натуральных чисел.
     * @param a - перове число
     * @param b - второе число
     * @return - НОД(a,b)
     */
    public static int nod (int a, int b) {
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
     * Метод нахождения наибольшего общего делителя 4 натуральных чисел.
     * @param a - первое число
     * @param b - второе число
     * @param c - третье число
     * @param d - четвертое число
     * @return - НОД(a, b, c, d)
     */
    public static int nodOfFour(int a, int b, int c, int d) {
        return nod(nod(nod(a, b),c),d);
    }
}
