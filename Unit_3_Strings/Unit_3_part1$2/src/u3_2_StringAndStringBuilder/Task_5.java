package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”."
 *
 * Строка s считывается из потока ввода.
 * "а" - символ русской расскладки (скопировано из условия задачи).
 * Для решения не используются регулярные выражения.
 */

public class Task_5 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string s:");
        String s = in.nextLine();
        in.close();

        // Выведем результат на экран
        System.out.println("Number of entries of the character \"а\" : " + numberOfEntries(s, 'а'));
    }

    /**
     * Находит количество вхождений символа в строку
     * @param s - входная строка
     * @param a - символ, вхождения которого необходимо подсчитать
     * @return - количество вхождений символа в строку
     */
    public static int numberOfEntries (String s, char a) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                count++;
            }
        }
        return count;
    }
}
