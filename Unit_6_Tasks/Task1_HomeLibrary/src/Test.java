import books_catalog.Book;
import books_catalog.BookTypes;
import books_catalog.Catalog;
import dao.BladeHash;

import java.io.File;
import java.sql.Array;
import java.util.Scanner;

public class Test {
    // Добавим несколько книг
    private static final Book book1 = new Book(
            "Маленький принц",
            "Эксмо",
            2015,
            96,
            630,
            "Твердый",
            BookTypes.BOOK,
            "Сент-Экзюпери Антуан де"
    );
    private static final Book book2 = new Book(
            "Мастер и Маргарита",
            "АСТ",
            2016,
            512,
            187,
            "Мягкий",
            BookTypes.BOOK,
            "Булгаков Михаил Афанасьевич"
    );
    private static final Book book3 = new Book(
            "Повелитель мух",
            "АСТ",
            2015,
            320,
            235,
            "Мягкий",
            BookTypes.BOOK,
            "Голдинг Уильям"
    );
    private static final Book book4 = new Book(
            "Собачье сердце",
            "Время",
            2017,
            176,
            152,
            "Твердый",
            BookTypes.BOOK,
            "Булгаков Михаил Афанасьевич"
    );
    private static final Book book5 = new Book(
            "Трудно быть богом",
            "АСТ",
            2019,
            224,
            342,
            "Твердый",
            BookTypes.E_BOOK,
            "Стругацкий Аркадий Натанович", "Стругацкий Борис Натанович"
    );

    public static void main(String[] args) {
        //System.out.println((char) 30);
        //System.out.println((char) 31);
        /*
        Catalog.addBook(book1);
        Catalog.addBook(book2);
        Catalog.addBook(book3);
        Catalog.addBook(book4);
        Catalog.addBook(book5);
        System.out.println(Catalog.getTitles());

        System.out.println(Catalog.deleteBook("123Повелитель мух")); //1249125657
        System.out.println(Catalog.deleteBook(1196044887));

         */
        File kek = new File(".");
        for (String str : Catalog.getInfo()) {
            System.out.println(str);
        }
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        while (!a.equals("X")) {
            System.out.println(BladeHash.bladeHash256(a));
            a = in.nextLine();
        }
    }
}
