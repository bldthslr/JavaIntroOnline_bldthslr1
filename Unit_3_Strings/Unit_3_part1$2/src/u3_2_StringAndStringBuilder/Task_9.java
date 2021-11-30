package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
 * Учитывать только английские буквы."
 *
 * Строка s считывается из потока ввода.
 * Для решения не используются регулярные выражения.
 */

public class Task_9 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string s:");
        String s = in.nextLine();
        in.close();

        // Выведем результат на экран
        System.out.println("Let's count the number of lowercase and uppercase letters in a string (only the letters of the English alphabet are counting");
        System.out.println("the number of lowercase letters in the string = " + countLowerCase(s));
        System.out.println("the number of uppercase letters in the string = " + countUpperCase(s));
    }

    /**
     * Подсчитывает количество строчных (маленьких) английских букв в строке.
     * @param s - входная строка
     * @return - количество строчных английских букв в строке
     */
    public static int countLowerCase (String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) {
                count++;
            }
        }
        return count;
    }

    /**
     * Подсчитывает количество прописных (больших) английских букв в строке.
     * @param s - входная строка
     * @return - количество прописных английских букв в строке
     */
    public static int countUpperCase (String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
                count++;
            }
        }
        return count;
    }
}
