package u2_3_Sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "6.  Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1.
 * Если  ai > ai+1, то продвигаются на один элемент вперед. Если ai <= ai+1,
 * то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки."
 *
 * Длинна массива n считывается из потока ввода
 * Массив заполняется случайными действительными значениями в диапазоне [-99.99..99.99]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 *
 * Так же сделаем отдельный метод для данной сортировки, чтобы можно было использовать его в других задачах :)
 */

public class Task_6 {
    public static void main(String[] args) {
        // Считаем длину массива n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input the length of the array n: ");
        int n = in.nextInt();
        in.close();

        // Создадим массив a
        double[] a = new double[n];

        // Заполним массив случайными значениями в диапазоне [-99.99..99.99]
        for (int i = 0; i < n; i++) {
            a[i] = ((double) (int) (((Math.random() * 200) - 100) * 100) ) / 100;
        }

        // Выведем получившийся массив на экран
        System.out.println("Array:");
        System.out.println(Arrays.toString(a));

        // Отсортируем массив. Во внешнем цикле for пройдем по элементам массива, а во внутреннем цикле будем
        // "откатываться" назад до тех пор, пока верно условие a[i] > a[i+1].
        double temp;
        for (int i = 0; i < n-1; i++) {
            while (a[i] > a[i+1]) {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                if (i > 0) {
                    i--;
                }
            }
        }

        // Выведлем результат на экран
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(a));
    }

    public static void shellSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length-1; i++) {
            while (a[i] > a[i+1]) {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                if (i > 0) {
                    i--;
                }
            }
        }
    }

    public static void shellSort(double[] a) {
        double temp;
        for (int i = 0; i < a.length-1; i++) {
            while (a[i] > a[i+1]) {
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                if (i > 0) {
                    i--;
                }
            }
        }
    }
}
