package u2_4_Decompositions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
 * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
 * использовать декомпозицию."
 *
 * Число k считывается из потока ввода.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_14 {
    public static void main(String[] args) {
        // Считаем k из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number n: ");
        int k = in.nextInt();
        in.close();
        // Выведем результат на экран
        System.out.println(Arrays.toString(findArmstrongs(1, k)));
    }

    /**
     * Проверяет, является ли k числом Армстронга
     * @param k - входное число
     * @return - true, если это число Армстронга, false - если нет
     */
    public static boolean isArmstrong (int k) {
        // Найдем количество цифр в числе
        int size = 1;
        int temp_k = Math.abs(k);
        while ((temp_k / 10) > 0) {
            size++;
            temp_k /= 10;
        }
        // Создадим переменную для суммы результата
        int sum = 0;
        // Найдем сумму цифр, возведенных в степень, равную количеству цифр (size)
        int div = (int) Math.pow(10, size-1);
        for (int i = 0; i < size; i++) {
            sum += Math.pow((k / div) % 10, size);
            div /= 10;
        }
        return sum == k;
    }

    /**
     * Формирует новый массив из массива a. Убирает все элементы из массива после первого найденного нуля.
     * @param a - входной массив
     * @return - результирующий массив
     */
    public static int[] removeZeros(int[] a) {
        int count = 0;
        while (a[count] != 0) {
            count++;
        }
        int[] result = new int[count];
        System.arraycopy(a, 0, result, 0, result.length);
        return result;
    }

    /**
     * Находит все числа Армстронга на отрезке [first, last]
     * @param first - Начало отрезка
     * @param last - Конец отрезка
     * @return - массив int[] со всеми числами Армстронга
     */
    public static int[] findArmstrongs (int first, int last) {
        // Cоздадим результирующий массив и переменную для его индекса
        int[] res = new int[last - first];
        int index = 0;
        // Пройдем по отрезку, и если число является числом Армстронга, запишем его в массив
        for (int i = first; i <= last; i++) {
            if (isArmstrong(i)) {
                res[index] = i;
                index++;
            }
        }
        // "Обрежем" массив, удалив нули в конце
        res = removeZeros(res);
        return res;
    }
}
