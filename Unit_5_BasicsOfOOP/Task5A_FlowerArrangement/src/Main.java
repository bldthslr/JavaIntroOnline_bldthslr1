import java.util.List;
import java.util.Scanner;

/**
 * Главный класс, содержащий точку входа в программу (метод main).
 * В методе main прописан пользовательский интерфейс для работы консольного приложения
 */
public class Main {
    // Откроем новый поток ввода
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // Создадим новый объект консольного меню, передав туда поток ввода
        ConsoleMenu cm = new ConsoleMenu(in);
        System.out.println("Greeting! This is a program for creating Gifts!");
        System.out.println("Let's start with packaging.");
        Packaging packaging = cm.createPackaging();
        System.out.println("Let's fill our gift with candies!");
        List<Candy> candies = cm.createCandiesList();
        System.out.println("Our gift is ready!!!");
        // Создаем объект "Подарка", и выведем его метод toString() в консоль
        Gift gift = new Gift(packaging, candies);
        System.out.println(gift);
    }
}
