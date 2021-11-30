package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы."
 *
 * Размерность матрицы n1, n2, а так же k, p считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [0..9]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_3 {
    public static void main(String[] args) {
        // Считаем n1, n2, k, p из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int n1 = in.nextInt();
        System.out.print("Input number of columns: ");
        int n2 = in.nextInt();
        System.out.println("Input k: ");
        int k = in.nextInt();
        System.out.println("Input p: ");
        int p = in.nextInt();
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

        // Выведем k-ю строку, если это возможно
        System.out.println("Row №" + k + ":");
        if ((k > 0) && (k <= n1)) {
            for (int i = 0; i < n2; i++) {
                System.out.print(a[k-1][i] + " ");
            }
        }
        else {
            System.out.println("invalid k value");
        }
        System.out.println();
        System.out.println();

        // Выведем p-й столбец, если это возможно
        System.out.println("Column №" + p + ":");
        if ((p > 0) && (p <= n2)) {
            for (int i = 0; i < n1; i++) {
                System.out.print(a[i][p - 1] + " ");
            }
        }
        else {
            System.out.println("invalid p value");
        }
    }
}
