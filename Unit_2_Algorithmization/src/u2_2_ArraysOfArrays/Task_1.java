package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего."
 *
 * Размерность матрицы n1 и n2 считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [0..9]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_1 {
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

        // Пройдем по всем нечетным столбцам, и, если условие верно, выведем столбец на экран
        for (int j = 0; j < n2; j += 2) {
            if (a[0][j] > a[n1-1][j]) {
                System.out.println("row N " + (j+1));
                for (int i = 0; i < n1; i++) {
                    System.out.println(a[i][j]);
                }
            }
        }
    }
}
