package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "Даны действительные числа a1, a2, ..., an. Найти max(a1+a2n, a2+a2n-1, ..., an+1")
 *
 * N, a1 и a2 считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона вещественных чисел [-100.0..100.0]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * В качестве порядковых номеров подразумеваются индексы элементов массива +1, т.е. a[0] - первый элемент и т.д.
 */

public class Task_7 {
    public static void main(String[] args) {
        // Считываем N
        Scanner in = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = in.nextInt();
        double[] a = new double[n*2];
        in.close();
        //заполним массив
        for (int i = 0; i < n * 2; i++) {
            a[i] = (Math.random() * 200) - 100;
        }

        //System.out.println(Arrays.toString(a));     //Печать массива до выполнения
        // Пройдем по массиву и найдем значение максимума
        double max = a[0] + a[n*2-1];
        for (int i = 1; i < n; i++) {
            double cur = a[i] + a[2 * n - (i + 1)];
            if (cur > max) {
                max = cur;
            }
        }
        System.out.println("Max = " + max);
    }
}
