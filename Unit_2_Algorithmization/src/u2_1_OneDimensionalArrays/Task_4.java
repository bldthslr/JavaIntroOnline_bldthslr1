package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы"
 *
 * n считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона действительных чисел [-100.0..100.0]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * В качестве результата напечатаем массив, максимальный и минимальный элемент, и массив после перестановки
 */
public class Task_4 {
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
        // Найдем индексы максимального и минимального элемента в массиве
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > a[max]) {
                max = i;
            }
            if (a[i] < a[min]) {
                min = i;
            }
        }
        // Выведем результат на экран
        System.out.println(Arrays.toString(a));
        System.out.println("Min elem: " + a[min]);
        System.out.println("Max elem: " + a[max]);
        // Заменим значения максимального и минимального элементов, и напечатаем массив после замены
        a[min] += a[max];
        a[max] = a[min] - a[max];
        a[min] = a[min] - a[max];
        System.out.println(Arrays.toString(a));
    }
}
