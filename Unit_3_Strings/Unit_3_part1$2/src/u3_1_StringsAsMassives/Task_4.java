package u3_1_StringsAsMassives;

import java.util.Scanner;

/**
 * "4. В строке найти количество чисел."
 *
 * Строка s считывается из потока ввода.
 * За число будем считать любую последовательность цифр, идущих друг за другом.
 * Проверка на вещественные числа (например, 30.251), не реализована, и это будут два разных числа.
 * Для решения не используются классы StringBuilder и StringBuffer, а так же регулярные выражения.
 */

public class Task_4 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        // Выведем на экран стркоу с заменой
        System.out.println(findNumbersInString(s));
    }

    /**
     * Метод возвращает количество целых чисел в строке.
     * @param s - входная строка
     * @return - количество целых чисел в строке s
     */
    public static int findNumbersInString(String s) {
        int count = 0;
        // Будем увеличивать счетчик только тогда, когда следующий за текущим символом символ - не цифра
        // Чтобы не уйти за границы, проверять будем до предпоследнего символа в строке
        for (int i = 0; i < s.length() - 1; i++) {
            if ( (Character.isDigit(s.charAt(i))) && (!Character.isDigit(s.charAt(i+1))) ) {
                count++;
            }
        }
        // Проверка последнего символа строки
        if (Character.isDigit(s.charAt(s.length() - 1))) {
            count++;
        }
        return count;
    }
}
