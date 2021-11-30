package u2_2_ArraysOfArrays;

import java.util.Arrays;

/**
 * "11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
 * которых число 5 встречается три и более раз."
 *
 * Матрица заполняется случайными целыми значениями из диапазона [0..15]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_11 {
    public static void main(String[] args) {
        // зададим размерность матрицы
        int n1 = 10;
        int n2 = 20;

        // Заполним матрицу случайными значениями из диапазона [0..15]
        int[][] a = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                a[i][j] = (int) (Math.random() * 15);
            }
        }

        // Выведем матрицу на экран
        System.out.println("Matrix:");
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        // Выведем строки, в которых число 5 встречается 5 и более раз
        int five_count;
        for (int i = 0; i < n1; i++) {
            five_count = 0;
            for (int j = 0; j < n2; j++) {
                if (a[i][j] == 5) {
                    five_count++;
                }
            }
            if (five_count >= 3) {
                System.out.println("Row #" + (i+1));
                System.out.println(Arrays.toString(a[i]));
            }
        }
    }
}
