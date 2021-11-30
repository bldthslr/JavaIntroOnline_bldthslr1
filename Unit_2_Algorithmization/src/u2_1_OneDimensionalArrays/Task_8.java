package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "8. Даны целые числа а1 ,а2,..., аn. Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min(a1, a2, ..., an)."
 *
 * n считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона целых чисел [-10..10]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_8 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = in.nextInt();
        in.close();
        // Заполним массив случайными значениями из диапазона [-10..10]
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 20) - 10;
        }

        System.out.println("Sequence:\n" + Arrays.toString(a));     //Печать массива до выполнения

        // Найдем минимальный элемент в массиве, а так же подсчитаем количество этих элементов
        int min = 11;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                count = 1;
            }
            else if (a[i] == min) {
                count += 1;
            }
        }

        // Инициализируем новый массив, и будем переписывать все значения из первого массива, кроме минимального
        int[] res = new int[n-count];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > min) {
                res[k] = a[i];
                k += 1;
            }
        }
        // Печать минимального элемента и результирующей последовательности
        System.out.println("Min = " + min);
        System.out.println("New sequence:");
        System.out.println(Arrays.toString(res));
    }
}
