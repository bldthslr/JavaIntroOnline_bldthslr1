package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i."
 *
 * n считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона целых чисел [0..n]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * Очевидно, что для первых элементов массива условие будет выполняться чаще, чем для последних
 */
public class Task_5 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = in.nextInt();
        in.close();
        // Заполним массив случайными значениями из диапазона [0..n]
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * n);
        }
        // Напечатаем массив, а так же элементы, для которых истинно аi > i, а так же индекс этих элементов в скобках
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
            if (a[i] > i) {
                System.out.print(a[i] + "(" + i + ")" + ", ");
            }
        }
    }
}
