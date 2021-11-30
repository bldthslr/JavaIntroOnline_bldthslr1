package u2_4_Decompositions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию."
 *
 * Число n считывается из потока ввода.
 * Очевидно, что самым малым таким числом будет 12, а самым большим - 123456789. Поэтому алгоритм будет работать для
 * n равных 2 <= n <= 9.
 * Для решения задачи используем обычный перебор, без методов оптимизации вычислений.
 * Для n = 7,8,9 может понадобиться много времени на вычисления.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_15 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number n (from the range [2..9]): ");
        int n = in.nextInt();
        in.close();

        // Проверим n:
        if ((n < 2) || (n > 9)) {
            System.out.println("Invalid n value. Aborting!!!.");
            return;
        }

        // Выведем результат на экран
        System.out.println(Arrays.toString(findAllIncrSeq(n)));
    }

    /**
     * Проверяет, образуют ли цифры в числе строго возрастающую последовательность.
     * @param k - входное число
     * @return - true, если цифры образуют строго возрастающую последовательность, false - если нет.
     */
    public static boolean isIncrSeq (int k) {
        // Найдем количество цифр в числе
        int size = 1;
        int temp_k = Math.abs(k);
        while ((temp_k / 10) > 0) {
            size++;
            temp_k /= 10;
        }
        // Создадим переменную для хранения цифры.
        int cur = 0;
        // Для каждой следующей цифры проведем проверку. Если она меньше или равна предыдущей, выкинем false
        int div = (int) Math.pow(10, size-1);
        for (int i = 0; i < size; i++) {
            int newNum = (k / div) % 10;
            div /= 10;
            if (newNum <= cur) {
                return false;
            }
            cur = newNum;
        }
        // Если false не был выкинут, значит цифры образуют строго возрастающую последовательность
        return true;
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
     * Возвращает массив из всех n-значных чисел, цифры которых образуют возрастающую последовательность.
     * @param n - разрядность(значность) чисел
     * @return - массив из всех n-значных чисел, цифры которых образуют возрастающую последовательность
     */
    public static int[] findAllIncrSeq (int n) {
        // Создадим результирующий массив и переменную для его индекса
        int[] res = new int[(int)Math.pow(10, n) / 2];
        int index = 0;
        // Пройдем по отрезку, и если цифры в числе образуют строго возрастающую последовательность, запишем в массив
        for (int i = (int) Math.pow(10, n-1); i < (int) Math.pow(10, n); i++) {
            if (isIncrSeq(i)) {
                res[index] = i;
                index++;
            }
        }
        // "Обрежем" массив, удалив нули в конце
        res = removeZeros(res);
        return res;
    }
}

