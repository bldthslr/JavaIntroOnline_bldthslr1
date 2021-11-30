package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "10. Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать."
 *
 * n считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона целых чисел [-10..10]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_10 {
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

        System.out.println("Array:\n" + Arrays.toString(a));     //Печать массива до выполнения

        // Одним циклом обнулим каждый второй элемент
        for (int i = 1; i < n; i += 2) {
            a[i] = 0;
        }
        // Результат
        System.out.println("New array:\n" + Arrays.toString(a));
    }
}
