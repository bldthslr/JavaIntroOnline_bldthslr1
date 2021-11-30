package u2_4_Decompositions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
 * являются числа, сумма цифр которых равна К и которые не большее N."
 *
 * Числа K, N считываются из потока ввода.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_12 {
    public static void main(String[] args) {
        // Считаем K, N из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number k: ");
        int k = in.nextInt();
        System.out.print("Input second number n: ");
        int n = in.nextInt();
        in.close();
        // Выведем результат на экран
        System.out.println(Arrays.toString(removeZeros(arrayOfSumDigits(k, n))));
    }


    /**
     * Возвращает сумму цифр, входящих в число k
     * @param k - число
     * @return - сумма цифр в числе
     */
    public static int sumOfDigits (int k) {
        byte size = 1;
        int temp_k = Math.abs(k);
        while ((temp_k / 10) > 0) {
            size++;
            temp_k /= 10;
        }
        // Создадим переменную для суммы
        int sum = 0;
        // Найдем сумму цифр
        int div = (int) Math.pow(10, size-1);
        for (int i = 0; i < size; i++) {
            sum += (k / div) % 10;
            div /= 10;
        }
        return sum;
    }

    /**
     * Метод формирует массива А, элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
     * @param k - сумма цифр
     * @param n - верхняя граница
     * @return - сформированный массив
     */
    public static int[] arrayOfSumDigits (int k, int n) {
        int[] a = new int[n];
        int i = 0;
        for (int el = 1; el <= n; el++) {
            if (sumOfDigits(el) == k) {
                a[i] = el;
                i++;
            }
        }
        return a;
    }

    /**
     * Формирует новый массив из массива a. Убирает все элементы из массива после первого найденного нуля.
     * @param a - входной массив
     * @return - результирующий массив
     */
    public static int[] removeZeros(int[] a) {
        int count = 0;
        while (a[count] != 0) {
            count++;
        }
        int[] result = new int[count];
        System.arraycopy(a, 0, result, 0, result.length);
        return result;
    }
}
