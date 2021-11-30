package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию."
 *
 * Число n считывается из потока ввода.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_16 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number n: ");
        int n = in.nextInt();
        in.close();

        // Выведем результат на экран
        System.out.println("The sum of all odd numbers of a given bit depth:");
        long res = findSumOfAllDigitsOdd(n);
        System.out.println(res);
        System.out.println("The number of even numbers in the total:");
        System.out.println(howManyEven(res));
    }

    /**
     * Подсчитывает, сколько цифр в числе.
     * @param k - входное число
     * @return - количество цифр в числе
     */
    public static int getNumberOfDigits (long k) {
        // Найдем количество цифр в числе
        int size = 1;
        long temp_k = Math.abs(k);
        while ((temp_k / 10) > 0) {
            size++;
            temp_k /= 10;
        }
        return size;
    }

    /**
     * Проверяет, все ли цифры в числе нечетные
     * @param k - входное число
     * @return - true, если цифры образуют строго возрастающую последовательность, false - если нет.
     */
    public static boolean isAllDigitsOdd (int k) {
        // Найдем количество цифр в числе
        int size = getNumberOfDigits(k);
        // Для каждой следующей цифры проведем проверку. Если она четная, выкинем false
        int div = (int) Math.pow(10, size-1);
        for (int i = 0; i < size; i++) {
            int newNum = (k / div) % 10;
            div /= 10;
            if (newNum % 2 == 0) {
                return false;
            }
        }
        // Если false не был выкинут, значит все цифры нечетные
        return true;
    }

    /**
     * Возвращает сумму всех n - значных чисел, содержащих только нечетные цифры.
     * @param n - разрядность(значность) чисел
     * @return - сумма всех n - значных чисел, содержащих только нечетные цифры.
     */
    public static long findSumOfAllDigitsOdd (int n) {
        // Создадим переменную для подсчета результата
        int res = 0;
        // Пройдем по отрезку, и если цифры в числе нечетные, прибавим число к сумме.
        for (int i = (int) Math.pow(10, n-1); i < (int) Math.pow(10, n); i++) {
            if (isAllDigitsOdd(i)) {
                res += i;
            }
        }
        return res;
    }

    /**
     *  Подсчитывает, сколько четных цифр в числе.
     * @param k - входное число
     * @return - количество четных цифр в числе
     */
    public static int howManyEven (long k) {
        // Найдем количество цифр в числе
        int size = getNumberOfDigits(k);
        // Для каждой следующей цифры проведем проверку. Если она четная, выкинем false
        int count = 0;
        int div = (int) Math.pow(10, size-1);
        for (int i = 0; i < size; i++) {
            long newNum = (k / div) % 10;
            div /= 10;
            if ((newNum % 2 == 0) && (newNum > 0)) {
                count++;
            }
        }
        // Вернем количество четных цифр в числе
        return count;
    }
}
