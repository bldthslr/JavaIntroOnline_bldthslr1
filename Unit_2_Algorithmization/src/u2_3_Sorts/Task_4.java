package u2_3_Sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "4. Сортировка обменами. Дана последовательность чисел a1, a2,.., an. Требуется переставить числа в
 * порядке возрастания. Для этого сравниваются два соседних числа ai и a(i+1). Если ai > a(i+1), то делается
 * перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок."
 *
 * Длинна массива n считывается из потока ввода
 * Массив заполняется случайными целыми значениями в диапазоне [-99..99]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_4 {
    public static void main(String[] args) {
        // Считаем динну массива n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input the length of the array n: ");
        int n = in.nextInt();
        in.close();

        // Создадим массив a
        int[] a = new int[n];

        // Заполним массив случайными целыми значениями в диапазоне [-99..99]
        for (int i = 0; i < n; i++) {
            a[i] = ((int) (Math.random() * 199)) - 99;
        }

        // Выведем получившийся массив на экран
        System.out.println("Array:");
        System.out.println(Arrays.toString(a));

        // Реализуем сортировку обменами
        int swap_in_progress = a.length;
        int swap_count = 0;
        int runs = 0;
        int tmp;
        // Будем осуществлять прогоны, пока не надо будет переставлять элементы, т.е. массив не будет отсортирован
        while (swap_in_progress > 0) {
            runs++;
            swap_in_progress = 0;
            // Идем по массиву
            for (int i = 0; i < n-1; i++) {
                // Если ai > a(i+1), производим замену и инкрементируем счетчики
                if (a[i] > a[i+1]) {
                    // Замена
                    tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                    // Счетчики
                    swap_count++;
                    swap_in_progress++;
                }
            }
        }
        // Выведем результат на экран
        System.out.println();
        System.out.println("A total of " + runs + " runs and " + swap_count + " exchanges were made");
        System.out.println("The resulting array:");
        System.out.println(Arrays.toString(a));
    }
}
