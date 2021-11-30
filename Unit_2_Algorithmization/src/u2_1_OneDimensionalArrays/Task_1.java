package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "1. В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К"
 *
 * N и K считываются из потока ввода
 * Массив заполняется случайными значениями из диапазона [0..1000]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_1 {
    public static void main(String[] args) {

        // Считываем N и К
        Scanner in = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = in.nextInt();
        System.out.print("Input K: ");
        int k = in.nextInt();
        in.close();
        // инициализируем массив и заполним случайными значениями
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        // найдем сумму элементов, кратных K, и выведем на экран
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % k == 0) {
                result += a[i];
            }
        }
        //System.out.println(Arrays.toString(a));     //Печать массива
        System.out.println("Sum = " + result);
     }
}
