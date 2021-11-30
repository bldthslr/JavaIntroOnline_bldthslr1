package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "6. Из заданной строки получить новую, повторив каждый символ дважды."
 *
 * Строка s считывается из потока ввода.
 * Для решения не используются регулярные выражения.
 */

public class Task_6 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string s:");
        String s = in.nextLine();
        in.close();

        // Выведем результат на экран
        System.out.println("Resulting string:");
        System.out.println(copyEverySymbol(s));
    }

    /**
     * Возвращает строку, в которой каждый символ повторен дважды.
     * @param s - входная строка
     * @return - строка с повтроенными дважды символами
     */
    public static String copyEverySymbol (String s) {
        // Создадим StringBuilder для сбора результирующей строки
        StringBuilder result = new StringBuilder();
        // Каждый элемент добавим в результат дважды
        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i)).append(s.charAt(i));
        }
        // Вернем результат как String
        return result.toString();
    }
}
