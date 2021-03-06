package u2_3_Sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "7. Пусть даны две неубывающие последовательности действительных чисел  a1 < a2 < .. an и b1 < b2 < .. < bn.
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 < b2 < .. < bn в первую
 * последовательность так, чтобы новая последовательность оставалась возрастающей."
 *
 * Длинна первого и второго массивов n1, n2 считывается из потока ввода
 * Массивы заполняются случайными неубывающими действительными значениями, начиная от 0.
 * Для каждого элемента последовательности b будем находить места в последовательности a, при этом будем считать
 * что последовательность a не меняется.
 * Для наглядности шаг заполнения в последовательности b сделаем в 4 раза больше, чем в последовательности a,
 * поэтому рекомендуется задавать длину массива n1 больше длинны n2 в 4 раза (например, n1 = 20 и n2 = 5).
 * Подразумевается, что на первом месте расположен элемент a[0], на втором - a[1] и т.д.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 */

public class Task_7 {
    public static void main(String[] args) {
        // Считаем n1, n2 из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input the length of the first array n1: ");
        int n1 = in.nextInt();
        System.out.print("Input the length of the second array n2: ");
        int n2 = in.nextInt();
        in.close();

        // Создадим массивы a, b
        double[] a = new double[n1];
        double[] b = new double[n2];

        // Заполним массивы случайными неубывающими значениями с шагом 5 для a, и шагом 20 для b,
        // оставив 2 знака после запятой
        for (int i = 0; i < n1; i++) {
            a[i] = (double) (int) (((Math.random() * 5) + i * 5) * 100) / 100;
        }
        for (int i = 0; i < n2; i++) {
            b[i] = (double) (int) (((Math.random() * 20) + i * 20) * 100) / 100;
        }

        // Выведем полученные массивы на экран
        System.out.println("Array a:");
        System.out.println(Arrays.toString(a));
        System.out.println("Array b:");
        System.out.println(Arrays.toString(b));

        // Начнем поиск индексов в массиве a, на которые необходимо поставить элемент  из массива b
        // Объявляем переменную для хранения индекса массива A
        int cur_a = 0;
        // Для каждого элемента массива B будем увеличевать индекс A, пока элемент b[i] > a[cur_a]
        // Когда условие внутреннего цикла перестает выполнятся, индекс cur_a будет является индексом вставки
        for (int i = 0; i < n2; i++) {
            while (b[i] > a[cur_a]) {
                if (cur_a == n1-1) {
                    break;
                }
                cur_a++;
            }
            System.out.println((i + 1) + "'st array B element " + b[i] + " Must be in place " + (cur_a + 1) + " in array A");

        }
    }
}
