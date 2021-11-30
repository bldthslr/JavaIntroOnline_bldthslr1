package u4_2_Agregation_And_Composition.task5;

import java.util.Scanner;

/**
 * Исполняемый класс с методом main, демонстрирующий работу классов TouristPackage и TouristPackageAggregator.
 *
 * В данном классе:
 * 1) Создаются путевки - объекты класса TouristPackage;
 * 2) Создается список путевок - объект класса TouristPackageList;
 * 3) В методе main:
 * 3.1) Дублируется список путевок, с которым в дальнейшем ведется работа в методе main;
 * 3.2) Создается объект "сканера" для чтения данных из консоли;
 * 3.3) Методично проводится поиск по категориям: Тип путевки, транспорт, питание, минимальное и максимальное количество дней;
 * 3.4) На консоль выводится результат поиска.
 *
 * В данном классе НЕ производится никаких проверок на валидность вводимых с консоли данных,
 * В данном классе НЕ предусмотрена обработка исключений.
 */
public class Usage {
    // Создадим путевки:
    static TouristPackage touristPackage1 = new TouristPackage(TouristPackage.Type.SEATOUR, TouristPackage.Transport.BUS, TouristPackage.Meals.FULL, "Crimea, hotel \"coastal\"", 45000, 12);
    static TouristPackage touristPackage2 = new TouristPackage(TouristPackage.Type.EXCURSION, TouristPackage.Transport.BUS, TouristPackage.Meals.NO, "Saint Petersburg, Hermitage Museum", 7000, 1);
    static TouristPackage touristPackage3 = new TouristPackage(TouristPackage.Type.CRUISE, TouristPackage.Transport.SHIP, TouristPackage.Meals.FULL, "Baltic Sea Cruise", 25000, 3);
    static TouristPackage touristPackage4 = new TouristPackage(TouristPackage.Type.SHOPPING, TouristPackage.Transport.AIRPLANE, TouristPackage.Meals.NO, "Milan shopping", 50000, 3);
    static TouristPackage touristPackage5 = new TouristPackage(TouristPackage.Type.TREATMENT, TouristPackage.Transport.BUS, TouristPackage.Meals.FULL, "Yalta, Kirov", 44000, 7);
    static TouristPackage touristPackage6 = new TouristPackage(TouristPackage.Type.SEATOUR, TouristPackage.Transport.AIRPLANE, TouristPackage.Meals.FULL, "Marmaris, Turkey", 120000, 10);
    static TouristPackage touristPackage7 = new TouristPackage(TouristPackage.Type.CRUISE, TouristPackage.Transport.SHIP, TouristPackage.Meals.FULL, "Сruises on the rivers of russia", 30000, 6);
    static TouristPackage touristPackage8 = new TouristPackage(TouristPackage.Type.SEATOUR, TouristPackage.Transport.AIRPLANE, TouristPackage.Meals.BREAKFAST, "Greece, hotel \"Poseydon\"", 110000, 12);
    static TouristPackage touristPackage9 = new TouristPackage(TouristPackage.Type.EXCURSION, TouristPackage.Transport.BUS, TouristPackage.Meals.NO, "Sights of Minsk", 28000, 2);
    static TouristPackage touristPackage10 = new TouristPackage(TouristPackage.Type.SHOPPING, TouristPackage.Transport.BUS, TouristPackage.Meals.NO, "Moscow shopping centers", 14000, 1);
    static TouristPackage touristPackage11 = new TouristPackage(TouristPackage.Type.SEATOUR, TouristPackage.Transport.AIRPLANE, TouristPackage.Meals.FULL, "Egypt, Sharm El Sheikh", 111000, 15);
    static TouristPackage touristPackage12 = new TouristPackage(TouristPackage.Type.TREATMENT, TouristPackage.Transport.CAR, TouristPackage.Meals.FULL, "Pine grove 4*, Crimea", 55000, 7);
    static TouristPackage touristPackage13 = new TouristPackage(TouristPackage.Type.SEATOUR, TouristPackage.Transport.TRAIN, TouristPackage.Meals.FULL, "Crimea, hotel \"Pobeda\"", 55000, 14);


    // Создадим объеки класса-агрегатора путевок
    static TouristPackageAggregator aggregator1 = new TouristPackageAggregator(touristPackage3, touristPackage1,
            touristPackage2, touristPackage4, touristPackage11, touristPackage5, touristPackage6, touristPackage7, touristPackage8,
            touristPackage9, touristPackage10, touristPackage12);

    public static void main(String[] args) {
        // Создадим новый объект агрегатора result, который будет изменяться в ходе метода main
        TouristPackageAggregator result = new TouristPackageAggregator(aggregator1.getPackages());
        // Отсортируем список путевок по их id
        result.moveToAggregator(result.sortById());
        // Создадим сканнер для получения данных из консоли
        Scanner in = new Scanner(System.in);
        System.out.println("Let's search for tourist packages!\n" +
                "Enter the required type of package (enter an empty line, if it is not important):");
        // Создадим необходимые переменные
        boolean flag = false;

        // Поиск по типу путевки
        String line = in.nextLine();            // seatour
        // Если была введена не пустая строка, начнем процедуру поиска
        if (!line.equals("")) {
            result.moveToAggregator(result.searchByType(line));
        }

        // Поиск по транспорту
        System.out.println("Enter the required transport of package (enter an empty line, if it is not important):");
        line = in.nextLine();                  // airplane
        if (!line.equals("")) {
            result.moveToAggregator(result.searchByTransport(line));
        }

        // Поиск по типу питания
        System.out.println("Enter the required type of meals of package (enter an empty line, if it is not important):");
        line = in.nextLine();                  // full
        if (!line.equals("")) {
            result.moveToAggregator(result.searchByMeals(line));
        }

        // Поиск по числу дней
        System.out.println("Enter the minimum number of days of package (enter an empty line, if it is not important):");
        line = in.nextLine();                  // 1
        int min = 0;
        if (!line.equals("")) {
            min = Integer.parseInt(line);
        }
        System.out.println("Enter the maximum number of days of package (enter an empty line, if it is not important):");
        line = in.nextLine();                  // 14
        int max = 9999;
        if (!line.equals("")) {
            max = Integer.parseInt(line);
        }
        // Проведем поиск
        System.out.println(min + " " + max);
        result.moveToAggregator(result.searchByDays(min, max));


        // Отсортируем оставшиеся путевки по цене, и выведем результат поиска на экран
        if (result.getPackages() == null) {
            System.out.println("No tourist packages were found for these categories!");
        }
        else {
            System.out.println(result.toStr(result.sortByPrice()));
                                                                        // Результат работы
                                                                        // Travel package №6: [type: SEATOUR, transport:AIRPLANE, meals: FULL, place: Marmaris, Turkey, price: 120000.0, numberOfDays: 10]
        }
    }
}
