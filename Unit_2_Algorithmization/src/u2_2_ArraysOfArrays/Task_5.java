package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное)"
 *  (1 1 1..1 1 1)
 *  (2 2 2..2 2 0)
 *  (3 3 3..3 0 0)
 *  (n-1 n-1 0..0)
 *  (n 0 0..0 0 0)
 *
 * Размерность матрицы n считывается из потока ввода
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * Если n - нечетное, программа не выполняется
 */

public class Task_5 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input even n: ");
        int n = in.nextInt();
        in.close();

        // Если n - нечетное, прерываем выполнение
        if (n % 2 == 1) {
            System.out.println("n is not even, aborting...");
            return;
        }

        // Заполним матрицу, исходя из условия
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((n-i) > (j)) {
                    a[i][j] = i+1;
                }
                else {
                    a[i][j] = 0;
                }
            }
        }

        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
    }
}
