package aservices;

import bean.Dragon;

/**
 * Основной класс программы, включающий точку доступа (метод main).
 */
public class Main {
    static Dragon dragon;
    static ConsoleMenu console;

    // Точка входа в программу
    public static void main(String[] args) {
        dragon = new Dragon();
        console = new ConsoleMenu(dragon);
        console.run();
    }
}
