package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него"
 *
 * Размерность матрицы n1, n2 считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [-100..100]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * Для сортировки массивов используем стандартный метод Arrays.sort
 */
public class Task_15 {
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

        // Найдем максимальный элемент в матрице
        int max_elem = a[0][0];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (a[i][j] > max_elem) {
                    max_elem = a[i][j];
                }
            }
        }
        System.out.println("Maximum element: " + max_elem);
        System.out.println();

        // Пройдем по массиву, и каждый нечетный элемент заменим на максимальный элемент
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (a[i][j] % 2 != 0) {
                    a[i][j] = max_elem;
                }
            }
        }

        // Выведем обновленную матрицу на экран
        System.out.println("The resulting matrix:");
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
