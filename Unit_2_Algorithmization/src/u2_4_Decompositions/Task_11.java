package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр."
 *
 * Числа a, b считываются из потока ввода.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_11 {
    public static void main(String[] args) {
        // Считаем a, b из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number a: ");
        int a = in.nextInt();
        System.out.print("Input second number b: ");
        int b = in.nextInt();
        in.close();

        // Выведем результат на экран
        System.out.println(moreDigits(a,b));
    }

    /**
     * Возвращает количество цифр в числе.
     * @param n - число
     * @return - количество цифр
     */
    public static int numberOfDigits (int n) {
        byte size = 1;
        int temp_n = Math.abs(n);
        while ((temp_n / 10) > 0) {
            size++;
            temp_n /= 10;
        }
        return size;
    }

    /**
     * Возвращает строку с результатом сравнения количества цифр в числе.
     * @param a - первое число
     * @param b - второе число
     * @return - результирующая строка
     */
    public static String moreDigits (int a, int b) {
        if (numberOfDigits(a) > numberOfDigits(b)) {
            return "The number " + a + " has more digits than number " + b + ".";
        }
        else if (numberOfDigits(a) < numberOfDigits(b)) {
            return "The number " + b + " has more digits than number " + a + ".";
        }
        else {
            return "The number of digits in these numbers is the same.";
        }
    }
}
