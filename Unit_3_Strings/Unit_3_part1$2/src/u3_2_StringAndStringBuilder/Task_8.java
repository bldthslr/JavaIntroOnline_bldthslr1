package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать."
 *
 * Строка s считывается из потока ввода.
 * Если самых длинных слов несколько, результатом будет первое самое длинное слово в строке.
 * Для решения не используются регулярные выражения.
 */

public class Task_8 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string s:");
        String s = in.nextLine();
        in.close();

        // Выведем результат на экран
        System.out.println("The longest word:");
        System.out.println(findLongestWord(s));
    }

    /**
     * В строке, разделенной пробелами, находит самое длинное слово. "Буквами" в слове могут быть любые символы,
     * отличные от пробела.
     * @param s - входная строка
     * @return - самое длинное слово в строке
     */
    public static String findLongestWord (String s) {
        // Добавим в конец строки пробел, он нужен для корректной работы алгоритма
        s += " ";
        // Объявим String для хранения максимального слова
        String longest = "";
        // Создадим int для хранения индекса предъыдущего пробела
        int past_space = -1;
        // В цикле идем по символам строки
        for (int i = 0; i < s.length(); i++) {
            // Если встретили пробел
            if (s.charAt(i) == ' ') {
                // Можно получить текущее слово как подстроку между прошлым пробелом и индексом i
                // Если длинна текущего слова больше самого длинного, то оно станет новым самым длинным словом
                if (s.substring(past_space + 1, i).length() > longest.length()) {
                    longest = s.substring(past_space + 1, i);
                }
                // Обновим индекс прошлого пробела
                past_space = i;
            }
        }
        return longest;
    }
}
