package u4_1_SimpleClasses.task4;

import java.util.Scanner;

/**
 * Использование класса "Train". Необходимо:
 *
 * "Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массива по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления."
 */
public class TrainUsage {
    // Создание массива из пяти элементов класса Train
    private static Train[] trains = new Train[5];

    // Инициализация массива класса Train
    public static void InitializeTrains() {
        trains[0] = new Train("Саратов", 254,12,20);
        trains[1] = new Train("Ростов", 128,0,5);
        trains[2] = new Train("Калуга", 123,14,44);
        trains[3] = new Train("Минск", 151,23,59);
        trains[4] = new Train("Минск", 151,03,00);
    }

    // Сортировка массива по номерам поездов без использования компаратора. Сортируем Шеллом :)
    public static void sortTrainsByNumbers() {
        for (int i = 0; i < trains.length - 1; i++) {
            while (trains[i].getNumber() > trains[i+1].getNumber()) {
                Train temp = trains[i];
                trains[i] = trains[i+1];
                trains[i+1] = temp;
                if (i > 0) {
                    i--;
                }
            }
        }
    }

    // Вывод информации о поезде (или поездах) по номеру
    public static String getInfoByNumber(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].getNumber() == number) {
                result.append(trains[i].getDestination()).append(", ").append(trains[i].getDepartureTime()).append(".\n");
            }
        }
        if (result.toString().equals("")) {
            return "No matches were found for the specified train number";
        }
        return result.toString();
    }

    // Чтение из потока ввода номера, а так же логика работы по выводу информации о поезде по номеру и печать на экран.
    public static void printInfoByNumber() {
        Scanner in = new Scanner(System.in);
        String msg = "Input train number (input 0 to exit)";
        System.out.println(msg);
        int number = in.nextInt();
        while (number != 0) {
            System.out.println(getInfoByNumber(number));
            System.out.println();
            System.out.println(msg);
            number = in.nextInt();
        }
    }

    // Сортировка по пункту назначения, при этом если пункт назначения один, то сортирует по времени прибытия.
    public static void sortTrainsByDestination() {
        // Сортировка Шеллом по пункту назначения
        for (int i = 0; i < trains.length - 1; i++) {
            while (trains[i].getDestination().compareTo(trains[i+1].getDestination()) > 0) {
                Train temp = trains[i];
                trains[i] = trains[i+1];
                trains[i+1] = temp;
                if (i > 0) {
                    i--;
                }
            }
        }
        // Проходим по массиву, и, если названия пунктов назначения одинаковые, то создаем подиндексы start и end.
        int start, end;
        for (int i = 0; i < trains.length - 1; i++) {
            if (trains[i].getDestination().equals(trains[i+1].getDestination())) {
                start = i;
                while (trains[i].getDestination().equals(trains[i+1].getDestination())) {
                    i++;
                }
                end = i;
                // Сортировка шелла для времени прибытия от start до end
                for (int j = start; j < end; j++) {
                    while (trains[j].getDepartureTime().compareTo(trains[j+1].getDepartureTime()) > 0) {
                        Train temp = trains[j];
                        trains[j] = trains[j+1];
                        trains[j+1] = temp;
                        if (j > start) {
                            j--;
                        }
                    }
                }
            }
        }
    }

    // Вывод на экран всех элементов массива
    public static void printTrains() {
        for (int i = 0; i < trains.length; i++) {
            System.out.println(trains[i].getDestination() + ", #" + trains[i].getNumber() + ", " + trains[i].getDepartureTime());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Заполним массив данными
        InitializeTrains();
        // Выведем на экран элементы массив
        System.out.println("Initial array:");
        printTrains();
        // Отсортируем массив по номерам поездов, и выведем на экран
        System.out.println("Sorted array by train numbers:");
        sortTrainsByNumbers();
        printTrains();
        // Отсортируем массив по пункту назначения, и выведем на экран
        System.out.println("Sorted array by destination:");
        sortTrainsByDestination();
        printTrains();
        // Считываем номер поезда, и выдаем информацию по номеру
        printInfoByNumber();
    }
}
