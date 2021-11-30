package u2_3_Sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "2. Даны две последовательности a1 < a2 < .. an и b1 < b2 < .. < bn. Образовать из них новую последовательность
 * чисел так, чтобы она тоже была неубывающей. Примечание: Дополнительный массив не использовать."
 *
 * Длинна первого и второго массивов n1, n2 считывается из потока ввода
 * Массивы заполняется случайными неубывающими целыми значениями, начиная от 0
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_2 {
    public static void main(String[] args) {
        // Считаем n1, n2 из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input the length of the first array n1: ");
        int n1 = in.nextInt();
        System.out.print("Input the length of the second array n2: ");
        int n2 = in.nextInt();
        in.close();

        // Создадим массивы a, b
        int[] a = new int[n1];
        int[] b = new int[n2];

        // Заполним массивы случайными неубывающими значениями с шагом 5
        for (int i = 0; i < n1; i++) {
            a[i] = ((int) (Math.random() * 5)) + i * 5;
        }
        for (int i = 0; i < n2; i++) {
            b[i] = ((int) (Math.random() * 5)) + i * 5;
        }

        // Выведем полученные массивы на экран
        System.out.println("Array a:");
        System.out.println(Arrays.toString(a));
        System.out.println("Array b:");
        System.out.println(Arrays.toString(b));

        // Заполним результирующий массив
        int index_a = 0;
        int index_b = 0;
        int[] result = new int[n1+n2];
        for (int i = 0; i < result.length; i++) {
            if (a[index_a] < b[index_b]) {
                result[i] = a[index_a];
                if (index_a != a.length-1) {
                    index_a++;
                }
            }
            else {
                result[i] = b[index_b];
                if (index_b != b.length-1) {
                    index_b++;
                }
            }
        }

        // Выведем результат на экран
        System.out.println("The resulting array:");
        System.out.println(Arrays.toString(result));
    }
}
