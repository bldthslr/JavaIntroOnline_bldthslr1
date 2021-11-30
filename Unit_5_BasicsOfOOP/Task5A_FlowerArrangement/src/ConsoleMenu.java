import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Класс, описывающий методы консольного меню
 */
public class ConsoleMenu {
    Scanner in;
    // Конструктор
    public ConsoleMenu(Scanner in) {
        this.in = in;
    }

    // Метод для создания объекта "package"
    public Packaging createPackaging() {
        System.out.println("What is the name of your packaging?");
        String packagingName = in.nextLine();
        System.out.println("What color is your package?");
        Colours packagingColor = readColour();
        System.out.println("What material is the packaging made of?");
        String packagingMaterial = in.nextLine();
        System.out.println("Our gift now has packaging!");
        return new Packaging(packagingName, packagingColor, packagingMaterial);
    }

    // Метод для создания списка объектов "Candy"
    public List<Candy> createCandiesList() {
        List<Candy> candies = new ArrayList<>();
        boolean flag = false;
        while (!flag) {
            Candy candy = createCandy();
            System.out.println("How many candies do you want to add?");
            int count;
            try {
                count = in.nextInt();
                in.nextLine();
            }
            catch (Exception e) {
                System.out.println("Oops! An input error occurred, adding 1 candy!");
                count = 1;
            }
            for (int i = 0; i < count; i++) {
                candies.add(candy);
            }
            System.out.println(count + " candy(ies) have been added to the gift!");
            System.out.println("Do you want add another candies? (\"y\" - YES, any other key - NO)");
            String check = in.nextLine().toLowerCase();
            if (!check.equals("y")) {
                flag = true;
            }
            else {
                System.out.println("Let's add another candy!");
            }
        }
        return candies;
    }

    // Метод для создания одного объекта "Candy"
    private Candy createCandy() {
        System.out.println("What is the name of candy?");
        String name = in.nextLine();
        System.out.println("What color is candy?");
        Colours color = readColour();
        System.out.println("What filling is candy?");
        String filling = in.nextLine();
        return new Candy(name, color, filling);
    }

    // Метод для считывания с консоли элемента перечисления "Colours"
    private Colours readColour() {
        boolean flag = false;
        Colours rez = null;
        while (!flag) {
            try {
                System.out.println("Available colors: " + getColours());
                rez = Colours.valueOf(in.nextLine().toUpperCase());
                flag = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("This color is not in the list! Try again...");
            }
        }
        return rez;
    }

    // Метод возвращает "палитру" - все элементы перечисления "Colours" в виде String
    private String getColours() {
        return Arrays.toString(Colours.values());
    }
}
