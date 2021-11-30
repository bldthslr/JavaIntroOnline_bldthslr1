package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено
 * "abc cde def", то должно быть выведено "abcdef"."
 *
 * Строка s считывается из потока ввода.
 * Для решения не используются регулярные выражения.
 */

public class Task_7 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string s:");
        String s = in.nextLine();
        in.close();

        // Выведем результат на экран
        System.out.println("Resulting string:");
        System.out.println(deleteDuplicatesAndSpaces(s));
    }

    /**
     * Проверяет, входит ли символ ch в строку s.
     * @param s - входная строка
     * @param ch - символ для провекри
     * @return - true, если символ входит в строку, иначе false
     */
    public static boolean isCharInStringBuilder (StringBuilder s, char ch) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет из строки повторяющиеся символы и пробелы.
     * @param s - входная стркоа
     * @return - строка без повторов и пробелов
     */
    public static String deleteDuplicatesAndSpaces (String s) {
        // Создадим StringBuilder для сбора результирующей строки
        StringBuilder result = new StringBuilder();
        // Каждый элемент добавим в результат дважды
        for (int i = 0; i < s.length(); i++) {
            // Если элемент не пробел
            if (s.charAt(i) != ' ') {
                // Если элемента нет в результирующей строке, добавим его
                if (!isCharInStringBuilder(result, s.charAt(i))) {
                    result.append(s.charAt(i));
                }
            }
        }
        // Вернем результат как String
        return result.toString();
    }
}
