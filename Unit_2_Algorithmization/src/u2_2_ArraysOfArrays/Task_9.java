package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму."
 *
 * Размерность матрицы n1, n2 считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [0..9]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_9 {
    public static void main(String[] args) {
        // Считаем n1 и n2 из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int n1 = in.nextInt();
        System.out.print("Input number of columns: ");
        int n2 = in.nextInt();
        in.close();

        // Заполним матрицу случайными значениями из диапазона [0..9]
        int[][] a = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                a[i][j] = (int) (Math.random() * 9);
            }
        }

        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        // Подсчитаем сумму элементов в каждом столбце, выведем её на экран, и определим наибольшую из сумм
        int max_sum = 0;
        int cur_sum;
        int max_ind = 0;
        for (int j = 0; j < n2; j++) {
            cur_sum = 0;
            for (int i = 0; i < n1; i++) {
                cur_sum += a[i][j];
            }
            System.out.println("Sum of " + (j+1) + " column is: " + cur_sum + ".");
            if (j == 0) {
                max_sum = cur_sum;
            }
            else if (cur_sum > max_sum) {
                max_sum = cur_sum;
                max_ind = j + 1;
            }
        }
        System.out.println();

        // Выведем максимальную сумму и номер столбца с этой суммой
        System.out.println("Max sum is: " + max_sum + " of the " + max_ind + " column" );
    }
}
