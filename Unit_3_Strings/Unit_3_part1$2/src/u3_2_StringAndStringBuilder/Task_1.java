package u3_2_StringAndStringBuilder;

import java.util.Scanner;

/**
 * "1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем."
 *
 * Строка s считывается из потока ввода.
 * Для решения не используются регулярные выражения.
 */

public class Task_1 {
    public static void main(String[] args) {
        // Считаем строку s из потока ввода
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        // Выведем на экран стркоу с заменой
        System.out.println(findNumberRowSpaces(s));
    }

    /**
     * Находит в строке наибольшее количество подряд идущих пробелов
     * @param s - входная строка
     * @return - максимальное количество подряд идущих пробелов
     */
    public static int findNumberRowSpaces (String s) {
        // Создадим переменные для хранения текущего числа пробелов и максимального числа
        int count = 0;
        int maxCount = 0;
        // Пройдем по строке
        for (int i = 0; i < s.length(); i++) {
            // Если текущий символ пробел, увеличим текущее число пробелов
            if (s.charAt(i) == ' ') {
                count++;
            }
            // Если пробелы закончились, то сравним текущие количество с максимальным, а так же обнулим текущее количество
            else if (s.charAt(i - 1) == ' '){
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        return maxCount;
    }
}
