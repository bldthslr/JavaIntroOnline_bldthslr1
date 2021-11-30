package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца."
 *
 * Размерность матрицы m, n считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [0..1] согласно условию
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_14 {
    public static void main(String[] args) {
        // Считаем n, m из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int m = in.nextInt();
        System.out.print("Input number of columns: ");
        int n = in.nextInt();
        in.close();

        // Заполним матрицу случайными значениями из диапазона [0..1] согласно условию
        int[][] a = new int[m][n];
        int one_count;
        int zero_count;
        for (int j = 0; j < n; j++) {
            one_count = j+1;
            zero_count = m-(j+1);
            for (int i = 0; i < m; i++) {
                if ((one_count > 0) && (zero_count > 0)) {
                    a[i][j] = (int) (Math.random() * 1.99);
                    if (a[i][j] == 1) {
                        one_count--;
                    }
                    else {
                        zero_count--;
                    }
                }
                else if (one_count <= 0){
                    a[i][j] = 0;
                    zero_count--;
                }
                else {
                    a[i][j] = 1;
                    one_count--;
                }
            }
        }


        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
    }
}
