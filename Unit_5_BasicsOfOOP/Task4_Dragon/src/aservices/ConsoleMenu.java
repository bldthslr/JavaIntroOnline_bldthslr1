package aservices;
import bean.Dragon;
import java.util.Scanner;

/**
 * Класс, описывающий консольный интерфейс взаимодействия с пользователем.
 */
public class ConsoleMenu {
    private Scanner in;
    private Dragon dragon;

    public ConsoleMenu(Dragon dragon) {
        in = new Scanner(System.in);
        System.out.println();
        this.dragon = dragon;
    }

    // Основной метод для вызова из главного метода программы (psvm).
    public void run() {
        System.out.println("Welcome traveler! In front of you is the cave of an ancient dragon, containing many  treasures...");
        main_menu();
    }

    // Основное меню приложения. Оно зациклено, пока пользователь не введет команду выхода (exit())
    private void main_menu() {
        showHelp();
        boolean exit = false;
        while (!exit) {
            System.out.println("1 - show all; 2 - show most expensive; 3 - select for gold; 4 - refresh dragon pit; 0 - exit, h - help");
            try {
                String str = in.next();
                if (str.equals("1")) {
                    showTreasures();
                } else if (str.equals("2")) {
                    showMostExpensiveTreasure();
                } else if (str.equals("3")) {
                    showTreasuresByGold();
                } else if (str.equals("4")) {
                    refresh();
                } else if (str.equals("0")) {
                    exit = exit();
                } else if (str.equals("h")) {
                    showHelp();
                } else {
                    unknown_command();
                }
            } catch (Exception e) {
                System.out.println("An error has occurred! try again!");
                press_enter();
            }
        }
    }

    private void showHelp() {
        System.out.println("What do you want to do?");
        System.out.println("Input 1 to show all the treasures;");
        System.out.println("Input 2 to show the most expensive treasure;");
        System.out.println("Input 3 to select treasures for a given amount;");
        System.out.println("Input 4 to refresh the treasures in the dragon cave;");
        System.out.println("Input 0 to exit");
    }

    // Показывает список сокровищ (не осортированный)
    private void showTreasures() {
        System.out.println("List of all treasures:");
        System.out.println(dragon.toString());
        press_enter();
    }

    // Показывает самое дорогое сокровище
    private void showMostExpensiveTreasure() {
        System.out.println("Most expensive treasure:");
        System.out.println(dragon.getMostExpensive());
        press_enter();
    }

    // Выводит список сокровищ на заданную сумму
    private void showTreasuresByGold() {
        try {
            System.out.println("Input the amount of gold:");
            System.out.println(dragon.BoughtTreasuresToString(in.nextInt()));
            press_enter();
        } catch (Exception e) {
            System.out.println("An error has occurred! try again!");
        }
    }

    // Обновляет список сокровищ
    private void refresh() {
        dragon.refresh();
        System.out.println("The treasures in the Dragon cave have been updated!");
    }

    // Неизвестная команда
    private void unknown_command() {
        System.out.println("Unknown command. Try again...");
        press_enter();
    }

    // Ожидание ввода Enter для продолжения
    private void press_enter() {
        System.out.println("Press enter to continue...");
        in.nextLine();
        while (!in.hasNextLine());
    }

    // Выход из программы
    private boolean exit() {
        System.out.println("Goodbye, traveler!");
        return true;
    }

}
