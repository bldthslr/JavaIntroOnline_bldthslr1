package u3_1_StringsAsMassives;

import java.util.Scanner;

/**
 * "2. Замените в строке все вхождения 'word' на 'letter'."
 *
 * Строка s считывается из потока ввода.
 * Для решения не используются классы StringBuilder и StringBuffer, а так же регулярные выражения.
 */
public class Task_2 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();

        // Выведем на экран стркоу с заменой
        System.out.println(s.replace("word", "letter"));
    }
}
