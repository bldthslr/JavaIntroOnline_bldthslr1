package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
 * действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию."
 *
 * Число n считывается из потока ввода.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_17 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number n: ");
        int n = in.nextInt();
        in.close();

        // Выведем результат на экран
        System.out.println("The number of subtractions of the sum of digits from a number until it turns out to be 0:");
        System.out.println(findNumberOfSubtractions(n));
    }

    /**
     * Возвращает сумму цифр, входящих в число k
     * @param k - число
     * @return - сумма цифр в числе
     */
    public static int sumOfDigits (int k) {
        byte size = 1;
        int temp_k = Math.abs(k);
        while ((temp_k / 10) > 0) {
            size++;
            temp_k /= 10;
        }
        // Создадим переменную для суммы
        int sum = 0;
        // Найдем сумму цифр
        int div = (int) Math.pow(10, size-1);
        for (int i = 0; i < size; i++) {
            sum += (k / div) % 10;
            div /= 10;
        }
        return sum;
    }

    /**
     * Находит количество вычитаний суммы цифр из числа, пока не получится 0.
     * @param n - входное число
     * @return - число вычитаний
     */
    public static int findNumberOfSubtractions (int n) {
        int count = 0;
        while (n > 0) {
            n -= sumOfDigits(n);
            count++;
        }
        return count;
    }
}
