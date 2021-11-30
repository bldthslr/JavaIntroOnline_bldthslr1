package u4_1_SimpleClasses.task9;

import java.util.Scanner;

/**
 * Использование классов Book и BookArray.
 *
 * Создадим несколько книг внутри данного класса.
 * Далее через консоль введем:
 * a) Автора, и выведем список книг заданного автора;
 * b) Издательство, и выведем список книг заданного издательства;
 * c) Год, и выведем список книг, выпущенных после заданного года
 * Многие методы классов (в классах Book и BookArray) не используются.
 */

public class BookUsage {
    // Добавим несколько книг
    private static final Book book1 = new Book("Маленький принц",
            "Эксмо",
            2015,
            96,
            630,
            "Твердый",
            "Сент-Экзюпери Антуан де"
    );
    private static final Book book2 = new Book("Мастер и Маргарита",
            "АСТ",
            2016,
            512,
            187,
            "Мягкий",
            "Булгаков Михаил Афанасьевич"
    );
    private static final Book book3 = new Book("Повелитель мух",
            "АСТ",
            2015,
            320,
            235,
            "Мягкий",
            "Голдинг Уильям"
    );
    private static final Book book4 = new Book("Собачье сердце",
            "Время",
            2017,
            176,
            152,
            "Твердый",
            "Булгаков Михаил Афанасьевич"
    );
    private static final Book book5 = new Book("Трудно быть богом",
            "АСТ",
            2019,
            224,
            342,
            "Твердый",
            "Стругацкий Аркадий Натанович", "Стругацкий Борис Натанович"
    );

    // Создаем массив BookArray
    private static final BookArray books = new BookArray(book1, book2, book3, book4, book5);


    // Основной алгоритм
    public static void main(String[] args) {

        /*
        Найти и вывести:
        a) список книг заданного автора;
        */
        // Считаем автора из консоли
        System.out.println("Input the author name:");
        Scanner in = new Scanner(System.in);
        String author_name = in.nextLine();                                                                             //Булгаков Михаил Афанасьевич
        // Попробуем найти книги заданного автора, и добавим их в строку результата
        // Имя автора, введеное из консоли, должно полностью совпадать с автором из книги
        StringBuilder result = new StringBuilder();
        int counter = 0;
        // Найдем в цикле все названия книг, и добавим их в результирующий StringBuilder
        for (int i = 0; i < books.getLength(); i++) {
            String[] authors =  books.getBook(i).getAuthors();
            for (int j = 0; j < authors.length; j++) {
                if (authors[j].equals(author_name)) {
                    result.append("\n").append(books.getBook(i).toString());
                    counter++;
                }
            }
        }
        // Выведем результат на экран. Если по автору книг не найдено, сообщим об этом.
        if (result.toString().equals("")) {
            System.out.println("Books by this author were not found!");
        }
        else {
            System.out.println(counter + " book(s) of this author were found:");                                        //2 book(s) of the specified author were found:
            System.out.println(result);                                                                                 //"Мастер и Маргарита", "Собачье сердце".
        }
        System.out.println();


         /*
        Найти и вывести:
        b) список книг, выпущенных заданным издательством;
        */
        // Считаем издательство с консоли
        System.out.println("Input the publisher:");
        String publishing = in.nextLine();
        // Обнулим результирующую строку и счетчик
        result.setLength(0);
        counter = 0;
        // Цикл поиска
        for (int i = 0; i < books.getLength(); i++) {
            if (books.getBook(i).getPublishing().equals(publishing)) {
                result.append("\n").append(books.getBook(i).toString());
                counter++;
            }
        }
        // Выведем результат на экран. Если по издательству книг не найдено, сообщим об этом.
        if (result.toString().equals("")) {
            System.out.println("Books from this publishing were not found!");
        }
        else {
            System.out.println(counter + " book(s) of this publishing were found:");
            System.out.println(result);
        }


        /*
        Найти и вывести:
        c) список книг, выпущенных после заданного года.
        */
        // Считаем год с консоли
        System.out.println("input the year after which need to find the books:");
        int min_year = in.nextInt();
        // Обнулим результирующую строку и счетчик
        result.setLength(0);
        counter = 0;
        // Цикл поиска
        for (int i = 0; i < books.getLength(); i++) {
            if (books.getBook(i).getYear() > min_year) {
                result.append("\n").append(books.getBook(i).toString());
                counter++;
            }
        }
        // Выведем результат на экран. Если по издательству книг не найдено, сообщим об этом.
        if (result.toString().equals("")) {
            System.out.println("Books released after this year were not found!");
        }
        else {
            System.out.println(counter + " book(s) released after a this year:");
            System.out.println(result);
        }
    }
}
