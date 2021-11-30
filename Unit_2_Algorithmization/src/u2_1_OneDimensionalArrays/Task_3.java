package u2_1_OneDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов."
 *
 * N считывается из потока ввода
 * Массив заполняется случайными значениями из диапазона [-10.0..10.0]
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 * Из-за особенности заполнения массива нулевых значений довольно мало
 */
public class Task_3 {
    public static void main(String[] args) {
        // Считываем N
        Scanner in = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = in.nextInt();
        in.close();
        // инициализируем массив и заполним случайными значениями от [-10..10]
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = (Math.random() * 20) - 10;
        }
        // Подсчитаем количество положительных, отрицательных и нулевых элементов
        // Нулевым будем считать элемент, меньше некого малого эпсилон
        double eps = 0.01;
        int pos = 0;
        int neg = 0;
        int zer = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(a[i]) < eps) {                     // Проверка на ноль
                zer += 1;
            }
            else if (a[i] > 0) {
                pos += 1;
            }
            else {
                neg += 1;
            }
        }
        // Выведем результаты на экран
        //System.out.println(Arrays.toString(a));           //Печать массива
        System.out.println("Negative elements: " + neg);
        System.out.println("Null elements: " + zer);
        System.out.println("Positive elements: " + pos);
    }
}
