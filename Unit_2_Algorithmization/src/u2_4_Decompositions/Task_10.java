package u2_4_Decompositions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
 * являются цифры числа N."
 *
 * Число N считывается из потока ввода.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_10 {
    public static void main(String[] args) {
        // Считаем N из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number N: ");
        int n = in.nextInt();
        in.close();
        // Выведем результат на экран
        System.out.println(Arrays.toString(createArrayOfDigits(n)));
    }

    /**
     * Метод получает натуральное число и возвращает массив, состоящий из цифр, входящих в это число.
     * Длинна массива будет равна количеству цифр.
     * @param n - входное целое число
     * @return - массив из цифр, входящих в число n
     */
    public static int[] createArrayOfDigits (int n) {
        // Найдем количество цифр в числе, и сделаем это количество размером возвращаемого массива
        byte size = 1;
        int temp_n = Math.abs(n);
        while ((temp_n / 10) > 0) {
            size++;
            temp_n /= 10;
        }
        // Создадим результирующий массив
        int[] res = new int[size];
        // Заполним этот массив цифрами
        int div = (int) Math.pow(10, size-1);
        for (int i = 0; i < size; i++) {
            res[i] = (n / div) % 10;
            div /= 10;
        }
        return res;
    }
}