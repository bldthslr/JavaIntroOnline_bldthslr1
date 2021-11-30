package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное)"
 *  (1 1 1..1 1 1)
 *  (0 1 1..1 1 0)
 *  (0 0 1..1 0 0)
 *  .............
 *  (0 0 1..1 0 0)
 *  (0 1 1..1 1 0)
 *  (1 1 1..1 1 1)
 *
 * Размерность матрицы n считывается из потока ввода
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * Если n - нечетное, программа не выполняется
 */
public class Task_6 {
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
                if ( ((i > j) && (n-i > j+1)) || !((i > j-1) || (n-i > j)) ) {
                    a[i][j] = 0;
                }
                else {
                    a[i][j] = 1;
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

