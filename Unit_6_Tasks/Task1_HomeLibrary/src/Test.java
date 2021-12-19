import books_catalog.Book;
import books_catalog.BookTypes;
import books_catalog.Catalog;
import dao.BladeHash;
import menu.AuthLogic;
import menu.AuthMenu;

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
        //System.out.println(authLogic.addUser("User", "User", "User@gmail.com", "User"));
        System.out.println(AuthMenu.logIn());
    }
}
