package u3_1_StringsAsMassives;

import java.util.Scanner;

/**
 * "3. В строке найти количество цифр."
 *
 * Строка s считывается из потока ввода.
 * Для решения не используются классы StringBuilder и StringBuffer, а так же регулярные выражения.
 */
public class Task_3 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        // Выведем на экран стркоу с заменой
        System.out.println(findDigitsInString(s));
    }

    /**
     * Метод возвращает количество цифр в строке.
     * @param s - входная строка
     * @return - количество цифр в строке s.
     */
    public static int findDigitsInString (String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
               count++;
            }
        }
        return count;
    }
}
