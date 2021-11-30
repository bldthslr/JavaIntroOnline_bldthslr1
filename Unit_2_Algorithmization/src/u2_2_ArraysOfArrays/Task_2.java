package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали."
 *
 * Размерность матрицы n считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [0..9]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * В данном решении печатаются как главная, так и побочная диагонали
 */
public class Task_2 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = in.nextInt();
        in.close();

        // Заполним матрицу случайными значениями из диапазона [0..9]
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * 9);
            }
        }

        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        // Выведем главную диагональ на экран
        System.out.println("Primary diagonal: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print(a[i][j]);
                    if (i != n-1) {
                        System.out.print(", ");
                    }
                    else {
                        System.out.println(".");
                    }
                }
            }
        }
        System.out.println();

        // Выведем побочную диагональ на экран
        System.out.println("Secondary diagonal: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == (n-1) - j) {
                    System.out.print(a[i][j]);
                    if (i != n-1) {
                        System.out.print(", ");
                    }
                    else {
                        System.out.println(".");
                    }
                }
            }
        }
    }
}
