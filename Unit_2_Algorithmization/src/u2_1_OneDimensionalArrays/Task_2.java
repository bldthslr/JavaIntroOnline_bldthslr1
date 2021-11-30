package u2_1_OneDimensionalArrays;

import java.util.Scanner;
import java.util.Arrays;
/**
 * "2. Дана последовательность действительных чисел а1 ,а2 ,..., аn. Заменить все ее члены, большие данного Z, этим
 * числом. Подсчитать количество замен."
 *
 * N и Z, a1 и a2 считываются из потока ввода
 * Массив заполняется значениями арифметической прогрессии с шагом a2 - a1
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */
public class Task_2 {
    public static void main(String[] args) {
        // Считываем N, Z, a1, a2
        Scanner in = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = in.nextInt();
        System.out.print("Input Z: ");
        int z = in.nextInt();
        double[] a = new double[n];
        System.out.print("Input a1: ");
        a[0] = in.nextDouble();
        System.out.print("Input a2: ");
        a[1] = in.nextDouble();
        in.close();
        double k = a[1] - a[0];
        //заполним массив
        for (int i = 2; i < n; i++) {
            a[i] = a[i-1] + k;
        }

        //System.out.println(Arrays.toString(a));     //Печать массива до выполнения

        // заменим элементы и подсчитаем количество замен
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > z) {
                a[i] = z;
                count += 1;
            }
        }
        System.out.println(Arrays.toString(a));     //Печать массива после выполнения
        System.out.println("Count = " + count);
    }
}
