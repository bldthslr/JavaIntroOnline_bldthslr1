package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "7. Сформировать квадратную матрицу порядка N по правилу: A[i,j] = sin((i^2 - j^2)/n) и подсчитать количество
 * положительных элементов в ней."
 *
 * Размерность матрицы n считывается из потока ввода
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_7 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = in.nextInt();
        in.close();

        // Заполним матрицу, исходя из условия, и подсчитаем количество положительных элементов
        double[][] a = new double[n][n];
        int positive_count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Math.sin((i*i - j*j)/(double) n);
                if (a[i][j] > 0) {
                    positive_count++;
                }
            }
        }

        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        // Выведем количество положительных элементов
        System.out.println("Number of positive elements: " + positive_count);
    }
}
