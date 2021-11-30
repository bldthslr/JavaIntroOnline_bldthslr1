package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
 * решения задачи использовать декомпозицию."
 *
 * Число n считывается из потока ввода.
 * Подразумевается, что и первый, и второй "близнец" входят в границы отрезка.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_13 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number n: ");
        int n = in.nextInt();
        in.close();
        // Выведем результат на экран
        System.out.println("Search for twins on a segment: [" + n + ", " + (n*2) + "].");
        for (int i = n; i < n * 2 - 1; i++) {
            if ((isPrime(i)) && (primeTwin(i) != 0)) {
                System.out.println(i + " " + primeTwin(i));
            }
        }
    }

    /**
     * Метод проверяет, является ли число простым
     * @param a - входное число
     * @return - true, если число простое; false - если нет.
     */
    public static boolean isPrime (int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает старшего простого "близнеца" числа, если он существует, и 0, если нет
     * @param prime - входное простое число
     * @return - "близнец", если он есть, иначе 0.
     */
    public static int primeTwin (int prime) {
        if (isPrime(prime+2)) {
            return prime + 2;
        }
        return 0;
    }
}
