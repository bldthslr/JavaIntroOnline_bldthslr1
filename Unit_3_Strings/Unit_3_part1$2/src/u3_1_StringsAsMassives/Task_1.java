package u3_1_StringsAsMassives;

import java.util.Arrays;

/**
 * "1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case."
 *
 * Создадим статический массив в классе решения, и заполним его в коде программы.
 * Запишем результат в другой массив, и выведем его элементы на экран.
 * В данном решении не реализуется проверка на первый char в названиях camelCase.
 * Для решения не используются классы StringBuilder и StringBuffer, а так же регулярные выражения.
 */
public class Task_1 {
    static String[] camelCase = {"itIsCamelCase" , "meTooCamelCase", "manage", "nok", "variousFunctions"};

    public static void main(String[] args) {
        // Используем метод fromCamelToSnake для получения массива в snake_case, и выведем результат на экран
        System.out.println(Arrays.toString(fromCamelToSnake(camelCase)));
    }

    /** Метод получает массив названий в camelCase, и возвращает новый массив названий в snake_case.
     * @param arrOfCamel - входной массив camelCase
     * @return - массив snake_case
     */
    public static String[] fromCamelToSnake (String[] arrOfCamel) {
        // Создадим результирующий массив с длинной, равной входному массиву
        String[] result = new String[arrOfCamel.length];
        // Внешний цикл для прохода по всем элементам массива
        for (int i = 0; i < arrOfCamel.length; i++) {
            // Создадим временную переменную текущей строки
            String tmp = arrOfCamel[i];
            // Внутренний цикл для обхода строки
            for (int j = 1; j < tmp.length(); j++) {
                // Создадим временную переменную для текущего символа
                char ch = tmp.charAt(j);
                // Если теущий символ в UpperCase, меняем подстроку с этим символом (A) на подстроку (_a)
                if (Character.isUpperCase(ch)) {
                    tmp = tmp.replace(Character.toString(ch), "_" + Character.toLowerCase(ch));
                }
            }
            // После выполнения внутреннего цикла временная строка tmp будет в snake_case. Добавим её в результат
            result[i] = tmp;
        }
        // После обхода по внешнему циклу мы получили готовый массив snake_case
        return result;
    }
}
