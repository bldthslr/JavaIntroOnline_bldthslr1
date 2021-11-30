package u2_4_Decompositions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
 * которое меньше максимального элемента массива, но больше всех других элементов)."
 *
 * N считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона вещественных чисел [-100.0..100.0]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_5 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = in.nextInt();
        in.close();

        // Заполним массив случайными значениями из диапазона [-100..100]
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = (Math.random() * 200) - 100;
        }

        // Выведем массив на экран
        System.out.println("Array:");
        System.out.println(Arrays.toString(a));

        // Найдем максимальный элемент массива
        double maxElem = max(a);
        // Найдем второй по величине элемент массива
        double secondMax = -100;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] > secondMax) && (a[i] < maxElem)) {
                secondMax = a[i];
            }
        }
        // Выведем результат на экран
        System.out.println("the second maximum element in the array:");
        System.out.println(secondMax);
    }

    /**
     * Поиск максимального элемента в массиве double
     * @param a - входной массив
     * @return - максимальный элемент
     */
    public static double max(double[] a) {
        double maxElem = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxElem) {
                maxElem = a[i];
            }
        }
        return maxElem;
    }
}
