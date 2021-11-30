package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них."
 *
 * n считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона целых чисел [-10..10]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_9 {
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

        int freq = 1;
        int freq_elem = a[0];
        int cur_freq;
        for (int i = 0; i < n; i++) {                               // Для каждого элемента массива
            cur_freq = 1;
            for (int j = 0; j < n; j++) {                           // Проходим по массиву
                if ((a[i] == a[j]) && (i != j)) {                   // Если нашли такой же элемент, добавляем к счетчику +1
                    cur_freq += 1;
                }
            }
            if (cur_freq > freq) {                                  // Если самый часто встречающейся элемент
                freq_elem = a[i];
                freq = cur_freq;
            }
            else if ((cur_freq == freq) && (a[i] < freq_elem)) {    // Если частота вхождений одинакова, записываем меньшее
                freq_elem = a[i];
            }
        }
        //Печатаем результат на экран
        System.out.println("The most common number: " + freq_elem +". It was found " + freq +" times." );
    }
}
