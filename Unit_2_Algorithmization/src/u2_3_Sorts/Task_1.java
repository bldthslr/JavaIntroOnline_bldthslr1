package u2_3_Sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив."
 *
 * Длинна первого и второго массивов n1, n2 считывается из потока ввода
 * Для решения задачи будем считать, что если k = 3, то это 3ий по счету элемент (его индекс будет равен 2)
 * Массивы заполняется случайными значениями из диапазона целых чисел [0..99]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_1 {
    public static void main(String[] args) {
        // Считаем n1, n2, k из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input the length of the first array n1: ");
        int n1 = in.nextInt();
        System.out.print("Input the length of the second array n2: ");
        int n2 = in.nextInt();
        System.out.print("Input k: ");
        int k = in.nextInt();
        in.close();

        // Заполним массивы случайными значениями из диапазона [0..99]
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++) {
            a[i] = (int) (Math.random() * 99);
        }
        for (int i = 0; i < n2; i++) {
            b[i] = (int) (Math.random() * 99);
        }

        // Если k не меньше длинны масива, то соединение двух массивов возможно:
        if ((k < n1) && (k > 0)) {
            // Создаем результируюший массив
            int[] result = new int[n1+n2];
            // Создадим переменную для сохранения индекса результирующего массива
            int res_i = 0;

            // Заполним финальный массив:
            for (int i = 1; i < k+1; i++) {
                result[i-1] = a[i-1];
                res_i++;
            }
            for (int i = 0; i < n2; i++) {
                result[res_i] = b[i];
                res_i++;
            }
            for (int i = k+1; i < n1; i++) {
                result[res_i] = a[i];
                res_i++;
            }

            // Выведем результат:
            System.out.println("Array a:");
            System.out.println(Arrays.toString(a));
            System.out.println("Array b:");
            System.out.println(Arrays.toString(b));
            System.out.println("The resulting array:");
            System.out.println(Arrays.toString(result));
        }
        else {
            System.out.println("Program aborted. Input correct k!");
        }
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
    }
}
