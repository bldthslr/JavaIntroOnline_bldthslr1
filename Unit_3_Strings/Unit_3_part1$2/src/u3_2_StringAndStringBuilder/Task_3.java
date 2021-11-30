package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "3. Проверить, является ли заданное слово палиндромом."
 *
 * Строка s считывается из потока ввода.
 * Проверка на то, что введенная строка является словом(т.е. содержит только символы [a-z][A-Z]) не выполняется.
 * Регистр не учитывается.
 * Для решения не используются регулярные выражения.
 */

public class Task_3 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string s:");
        String s = in.nextLine();
        in.close();

        // Выведем на экран стркоу с заменой
        if (isPalindrome(s)) {
            System.out.println("The string \"" + s + "\" is a palindrome.");
        }
        else {
            System.out.println("The string \"" + s + "\" is NOT a palindrome.");
        }
    }

    /**
     * Проверяет, является ли строка s палиндромом.
     *
     * @param s - входная строка
     * @return - true, если s - париндром, false - если не палиндром.
     */
    public static boolean isPalindrome (String s) {
        // Создадим "Обратную" строку с нижним регистром
        StringBuilder reverse = new StringBuilder(s.toLowerCase()).reverse();
        // Сравним её со входной строкой с нижним регистром
        return reverse.toString().equals(s.toLowerCase());
    }
}
