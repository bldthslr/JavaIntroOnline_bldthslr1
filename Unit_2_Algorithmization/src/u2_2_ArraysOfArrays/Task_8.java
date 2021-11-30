package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры."
 *
 * Размерность матрицы n1, n2, а так же номера столбцов p1, p2 считывается из потока ввода
 * Матрица заполняется случайными целыми значениями из диапазона [0..9]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_8 {
    public static void main(String[] args) {
        // Считаем n1, n2, p1, p2 из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        int n1 = in.nextInt();
        System.out.print("Input number of columns: ");
        int n2 = in.nextInt();
        System.out.println("Input number of the first column: ");
        int p1 = in.nextInt();
        System.out.println("Input number of the second column: ");
        int p2 = in.nextInt();
        in.close();

        // Если первый или второй номер столбца не в диапазоне [1..n2], прервем выполнение
        if ((p1<1) || (p1 > n2)) {
            System.out.println("invalid value for the first column number, aborting...");
            return;
        }
        if ((p2<1) || (p2 > n2)) {
            System.out.println("invalid value for the first column number, aborting...");
            return;
        }

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
        System.out.println();

        //поменяем значения в столбцах местами
        for (int i = 0; i < n1; i++) {
            a[i][p1-1] = a[i][p1-1] + a[i][p2-1];
            a[i][p2-1] = a[i][p1-1] - a[i][p2-1];
            a[i][p1-1] = a[i][p1-1] - a[i][p2-1];
        }

        // Выведем обновленную матрицу на экран
        System.out.println("Updated Matrix:");
        for (int i = 0; i < n1; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
