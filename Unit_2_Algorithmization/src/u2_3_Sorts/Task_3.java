package u2_3_Sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "3. Сортировка выбором. Дана последовательность чисел a1 <= a2 <= an. Требуется переставить элементы так, чтобы они были
 * расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое
 * место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется.
 * Написать алгоритм сортировки выбором."
 *
 * Длинна массива n считывается из потока ввода
 * Массив заполняется случайными неубывающими целыми значениями, начиная от 0
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_3 {
    public static void main(String[] args) {
        // Считаем динну массива n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input the length of the array n: ");
        int n = in.nextInt();
        in.close();

        // Создадим массив a
        int[] a = new int[n];

        // Заполним массив случайными неубывающими значениями с шагом 5
        for (int i = 0; i < n; i++) {
            a[i] = ((int) (Math.random() * 5)) + i * 5;
        }

        // Выведем получившийся массив на экран
        System.out.println("Array:");
        System.out.println(Arrays.toString(a));

        // Реализуем сортировку выбором
        int max_elem = 0;
        int max_index = 0;
        // Внешний цикл
        for (int i = 0; i < n; i++) {
            max_elem = a[i];
            max_index = i;
            // Внутренний цикл поиска наибольшего элемента
            for (int j = i; j < n; j++) {
                if (a[j] > max_elem) {
                    max_elem = a[j];
                    max_index = j;
                }
            }
            // Осуществим перестановку
            a[max_index] = a[i];
            a[i] = max_elem;
        }

        // Выведем результат на экран
        System.out.println("The resulting array:");
        System.out.println(Arrays.toString(a));
    }
}
