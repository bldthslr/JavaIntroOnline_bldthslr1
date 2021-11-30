package u4_1_SimpleClasses.task10;

import java.util.Locale;
import java.util.Scanner;

/**
 * Использование классов Airlane и AirlaneArray.
 *
 * Создадим несколько объектов типа Airlane внутри данного класса.
 *
 * Далее через консоль введем:
 * a) Пункт назначения, и выведем список всех рейсов в данный пункт назначения;
 * b) День недели, и выведем список рейсов по заданному дню недели;
 * c) Время вылета, и выведем список рейсов для заданного дня недели, время вылета для которых больше заданного.
 * Некоторые методы Airlane и AirlaneArray могут не использоваться.
 */
public class AirlaneUsage {
    // Создадим несколько объектов типа Airlane
    private static final Airlane airlane1 = new Airlane("Moscow",
            122,
            "Boeing 737",
            "22:18",
            "TUESDAY"
            );
    private static final Airlane airlane2 = new Airlane("Tokyo",
            454,
            "Boeing 747",
            "06:58",
            "MONDAY"
    );
    private static final Airlane airlane3 = new Airlane("Osaka",
            455,
            "Airbus A320",
            "14:18",
            "WEDNESDAY"
    );
    private static final Airlane airlane4 = new Airlane("Moscow",
            123,
            "Boeing 737",
            "19:30",
            "THURSDAY"
    );
    private static final Airlane airlane5 = new Airlane("Saint Petersburg",
            126,
            "Boeing 737",
            "02:00",
            "FRIDAY"
    );
    private static final Airlane airlane6 = new Airlane("New York",
            660,
            "Boeing 747",
            "15:13",
            "SATURDAY"
    );
    private static final Airlane airlane7 = new Airlane("Chicago",
            661,
            "Boeing 747",
            "19:00",
            "SUNDAY"
    );
    private static final Airlane airlane8 = new Airlane("Los Angeles",
            663,
            "Boeing 737",
            "04:15",
            "WEDNESDAY"
    );
    private static final Airlane airlane9 = new Airlane("Minsk",
            891,
            "Boeing 737",
            "13:01",
            "SUNDAY"
    );
    private static final Airlane airlane10 = new Airlane("Minsk",
            892,
            "Airbus A320",
            "09:43",
            "THURSDAY"
    );

    // Создадим массив класса AirlanesArray
    private static final AirlaneArray airlanes = new AirlaneArray(airlane1, airlane2, airlane3, airlane4, airlane5,
            airlane6, airlane7, airlane8, airlane9, airlane10);

    // В методе main реализуем ввод данных для поиска через консоль, а так же вывод результатов поиска
    public static void main(String[] args) {
        // "Откроем" новый сканнер
        Scanner in = new Scanner(System.in);
        /*
         * Найти и вывести:
         * a) список рейсов для заданного пункта назначения;
         */
        // При вводе в консоль пункт назначения "destination" чувствителен к регистру
        System.out.println("Input destination:");
        // Считаем пункт назначения из консоли
        String destination = in.nextLine();
        // Объявим результирующий Stringbuilder
        StringBuilder result = new StringBuilder();
        // В цикле пройдем по всем элементам Airlanes
        for (int i = 0; i < airlanes.getLength(); i++) {
            // Если нашли нужный рейс, добавим в результирующий Stringbuilder .toString этого рейса
            if (airlanes.getAirlane(i).getDestination().equals(destination)) {
                result.append("Airlane #").append(i + 1).append("\n");
                result.append(airlanes.getAirlane(i).toString()).append("\n");
            }
        }
        String res = result.toString();
        // Если ничего не нашли, оповестим об этом
        if (res.equals("")) {
            System.out.println("Airlanes for that destination was NOT found!");
        }
        // Иначе выведем результат поиска на экран
        else {
            System.out.println(res);
        }

        /*
         * Найти и вывести:
         * b) список рейсов для заданного дня недели;
         */
        // Алгоритм похож на поиск
        System.out.println("Input day of the week:");
        // Считаем из консоли день недели.
        String day = in.nextLine().toUpperCase(Locale.ROOT);
        // Проверим, является ли введеная строка днем недели. Если введен неверный день недели, попробуем ещё раз
        while (!airlane1.checkDayOfTheWeek(day)) {
            System.out.println("Wrong day of the week! try again:");
            day = in.nextLine().toUpperCase(Locale.ROOT);
        }
        // Обнулим результирующий StringBuffer
        result.setLength(0);
        // В цикле пройдем по массиву airlanes, и найдем все совпадения по дням недели, и добавим в результат
        for (int i = 0; i < airlanes.getLength(); i++) {
            if (airlanes.getAirlane(i).getDayOfTheWeekString().equals(day)) {
                result.append("Airlane #").append(i + 1).append("\n");
                result.append(airlanes.getAirlane(i).toString()).append("\n");
            }
        }
        res = result.toString();
        if (res.equals("")) {
            System.out.println("Airlanes for that day of the week was NOT found!");
        }
        else {
            System.out.println(res);
        }


        /*
         * Найти и вывести:
         * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
         */
        // Сначала считаем и проверим день недели, а затем считаем время вылета.
        System.out.println("Input day of the week:");
        // Считаем из консоли день недели.
        day = in.nextLine().toUpperCase(Locale.ROOT);
        // Проверим, является ли введеная строка днем недели. Если введен неверный день недели, попробуем ещё раз
        while (!airlane1.checkDayOfTheWeek(day)) {
            System.out.println("Wrong day of the week! try again:");
            day = in.nextLine().toUpperCase(Locale.ROOT);
        }
        // Введем время вылета, при этом отдельно введем часы, а отдельно - минуты
        System.out.println("Input departure time:");
        System.out.println("Input hours: ");
        int hours = in.nextInt();
        System.out.println("Input minutes: ");
        int minutes = in.nextInt();
        // Проверим время на валидность. Если введены неправильные часы или минуты, попробуем ещё раз
        while ((minutes < 0) || (minutes > 59) || (hours < 0) || (hours > 23)) {
            System.out.println("Invalid time value! Try again: ");
            System.out.println("Input hours: ");
            hours = in.nextInt();
            System.out.println("Input minutes: ");
            minutes = in.nextInt();
        }
        // Обнулим результирующий StringBuffer
        result.setLength(0);
        // В цикле пройдем по массиву airlanes, и найдем все совпадения по дням недели, а затем проверим по времени
        // вылета. Если рейс airlane проходит условия, добавим его toString в результат.
        for (int i = 0; i < airlanes.getLength(); i++) {
            if (airlanes.getAirlane(i).getDayOfTheWeekString().equals(day)) {
                if ((airlanes.getAirlane(i).getDepartureHour() > hours) ||
                        ((airlanes.getAirlane(i).getDepartureHour() == hours) && (airlanes.getAirlane(i).getDepartureMinute() > minutes))) {
                    result.append("Airlane #").append(i + 1).append("\n");
                    result.append(airlanes.getAirlane(i).toString()).append("\n");
                }
            }
        }
        res = result.toString();
        if (res.equals("")) {
            System.out.println("Airlanes for that day of the week and after the specified time was NOT found!");
        }
        else {
            System.out.println(res);
        }
    }
}
