package u2_4_Decompositions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
 * массива с номерами от k до m."
 *
 * Длинна массива N считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона вещественных чисел [-100.0..100.0]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_8 {
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

        if (a.length < 3) {
            System.out.println("The array length is less than three");
        }
        else {
            for (int i = 1; i < a.length - 1; i++) {
                System.out.println("The sum of the numbers of elements " + i + ", " + (i + 1) + ", " + (i + 2) + " == "
                        + sumOfThree(a, i));

            }
        }
    }

    /**
     * Метод возвращает сумму трех последовательно расположенных элементов массива с первым номером first_number.
     * При этом если номер = 1, то индекс i = 0, т.е. индекс номера меньше на 1.
     * Проверки и обработки исключений не производятся.
     * @param a - входной массив
     * @param first_number - номер первого элемента последовательности из трех эл-ов
     * @return - сумма трех последовательно расположенных элементов
     */
    public static double sumOfThree (double[] a, int first_number) {
        return a[first_number-1] + a[first_number] + a[first_number + 1];
    }
}
