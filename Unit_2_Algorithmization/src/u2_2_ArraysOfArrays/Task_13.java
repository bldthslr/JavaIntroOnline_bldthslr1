package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "13. Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов."
 *
 * Размерность матрицы n1, n2 считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [-100..100]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * Для сортировки массивов используем стандартный метод Arrays.sort
 */
public class Task_13 {
    public static void main(String[] args) {
        // Считаем n1 и n2 из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int n1 = in.nextInt();
        System.out.print("Input number of columns: ");
        int n2 = in.nextInt();
        in.close();

        // Заполним матрицу случайными значениями из диапазона [-100..100]
        int[][] a = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                a[i][j] = (int) (Math.random() * 200) - 100;
            }
        }

        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        // Отсортируем столбцы матрицы по возростанию
        System.out.println("Sorted columns in ascending order:");
        int[] temp = new int[n1];
        for (int j = 0; j < n2; j++) {
            for (int i = 0; i < n1; i++) {
                temp[i] = a[i][j];
            }
            Arrays.sort(temp);
            for (int i = 0; i < n1; i++) {
                a[i][j] = temp[i];
            }
        }
        // Выведем отсортированный массив на экран
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();


        // Отсортируем столбцы матрицы по убыванию
        System.out.println("Sorted columns in ascending order:");
        for (int j = 0; j < n2; j++) {
            for (int i = 0; i < n1; i++) {
                temp[i] = a[i][j];
            }
            Arrays.sort(temp);
            for (int i = 0; i < n1; i++) {
                a[i][j] = temp[n1-(i+1)];
            }
        }
        // Выведем отсортированный массив на экран
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
