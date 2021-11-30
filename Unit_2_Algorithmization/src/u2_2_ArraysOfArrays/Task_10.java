package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "10. Найти положительные элементы главной диагонали квадратной матрицы."
 *
 * Размерность матрицы n считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [-9..9]
 * В данном решении не реализуются проверки на попадание в бесконечный циккл, а так же обработка исключений
 */
public class Task_10 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input even n: ");
        int n = in.nextInt();
        in.close();

        // Заполним матрицу случайными значениями из диапазона [-9..9]
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * 18) - 9;
            }
        }

        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        // Найдем положительные элементы главной диагонали и выведем их на экран
        System.out.println("Positive elements of the main diagonal: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j) && (a[i][j] > 0)) {
                    System.out.print(a[i][j] + " ");
                }
            }
        }
    }
}
