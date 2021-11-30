package u4_2_Agregation_And_Composition.task2;

import java.util.Scanner;

/**
 * Класс с методом main - Пример использования класса Car.
 */

public class Usage {
    // Создадим объект "колесо"
    public static Wheel wheel = new Wheel("Nordman SX2","Nokian", 15, 195, 65);
    // Создадим ещё один объект колесо
    public static Wheel spareWheel = new Wheel("Nordman SX1", "Nokian", 15, 185, 65);
    // Создадим объект "двигатель"
    public static Engine engine = new Engine("XV70", 181, 2.5, 6, 8.7);
    // Создадим объект "Автомобиль"
    public static Car car = new Car("Camry", "Toyota", engine, wheel, 60);

    public static void main(String[] args) {
        // Выведем информацию об авто в консоль
        System.out.println(car.toString());
        // Начнем поездку
        car.drive(3600, 120);
        // Заменим колесо
        System.out.println(car.changeWheel(spareWheel, 1));
        // Заправим машину
        System.out.println(car.refuel());
        // Откроем сканер и введем с консоли параметры для метода drive
        Scanner in = new Scanner(System.in);
        System.out.println("Input the time ratio 'k':");
        int k = in.nextInt();
        System.out.println("Input the maximum speed:");
        int maxSpeed = in.nextInt();
        car.drive(k, maxSpeed);
    }
}
