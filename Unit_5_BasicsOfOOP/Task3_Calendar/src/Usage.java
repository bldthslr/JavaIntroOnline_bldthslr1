import java.util.ArrayList;
import java.util.List;

/**
 * Пример использования класса MyCalendar.
 */
public class Usage {
    // Создадим пустой календарь
    static MyCalendar calendar = new MyCalendar();
    // Создадим список для хранения кодов ошибок добавления выходных
    static List<Integer> errorCodes = new ArrayList<>();

    public static void main(String[] args) {
        // Добавим праздники в календарь;
        // Добавим новогодние каникулы - с 1 по 7 января
        for (int i = 0; i < 9; i++) {
            // Поскольку результатом добавления является код ошибки int, мы можем добавить его в список кодов ошибок
            // Поскольку в цикле первым числом идет 0, первый код ошибки будет -1
            errorCodes.add(calendar.addWeekend(i, 1, "новогодние праздники"));
        }
        // Попробуем добавить несуществующий день
        errorCodes.add(calendar.addWeekend(23,23,1000));
        // Добавим рождество
        errorCodes.add(calendar.addWeekend(7, 1, "Christmas"));
        // Добавим 23 февраля
        errorCodes.add(calendar.addWeekend(23,02,"Defender of the Fatherland day"));
        // Добавим 8 марта
        errorCodes.add(calendar.addWeekend(8,03,"International Women's Day"));
        // Добавим Объединенные майские праздники
        for (int i = 1; i < 11; i++) {
            errorCodes.add(calendar.addWeekend(i,05,"United May Holidays"));
        }
        // Выведем список праздников на экран
        System.out.println("Holidays:");
        System.out.println(calendar.toString());

        // Добавим все субботы и воскресения в текущем году (!!!)
        errorCodes.add(calendar.addAllSatAndSun());

        // Выведем обновленный список праздников и выходных на экран
        System.out.println();
        System.out.println("Holidays and Weekends, not sorted:");
        System.out.println(calendar.toString());

        // Попробуем удалить один из выходных (конец январских праздников)
        errorCodes.add(calendar.deleteWeekend(8,1));


        // Выведем обновленный отсортированный список
        System.out.println();
        System.out.println("Holidays and Weekends, SORTED(!):");
        System.out.println(calendar.toStringWithSort());

        // Выведем список с кодами ошибок (ожидается первый и восьмой элемент -1, остальные - 0)
        System.out.println("Error Codes:");
        System.out.println(errorCodes.toString());
    }
}
