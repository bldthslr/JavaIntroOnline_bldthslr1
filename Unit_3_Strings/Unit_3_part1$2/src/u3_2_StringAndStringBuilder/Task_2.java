package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "2. В строке вставить после каждого символа 'a' символ 'b'."
 *
 * Строка s, символы a, b считываются из потока ввода.
 * Для решения не используются регулярные выражения.
 */

public class Task_2 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = in.nextLine();
        // Считаем символы a, b из потока ввода
        System.out.println("Enter the character 'a' that you want to insert after:");
        char a = in.nextLine().charAt(0);
        System.out.println("Enter the character 'b' you want to insert: ");
        char b = in.nextLine().charAt(0);
        in.close();

        // Выведем на экран стркоу с заменой
        System.out.println("The resulting string: ");
        System.out.println(insertCharAfterChar(s, a ,b));
    }

    /**
     * Возвращает строку, где после каждого символа 'a' вставлен символ 'b'.
     * @param s - входная строка
     * @param a - символ, после которого надо вставлять b
     * @param b - символ, который надо вставлять после a
     * @return  - строка со вставками b после a
     */
    public static String insertCharAfterChar (String s, char a, char b) {
        return s.replace(Character.toString(a), Character.toString(a) + b);
    }
}
