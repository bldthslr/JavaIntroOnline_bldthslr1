package books_catalog;

import dao.CatalogDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Catalog {
    private final static CatalogDAO catalogDAO = new CatalogDAO();
    private final static List<Book> catalog = catalogDAO.getCatalog();

    public static List<Book> getCatalog() {
        return catalog;
    }

    public static boolean addBook(Book book) {
        catalog.add(book);
        return catalogDAO.addBook(book);
        // Рассылка всем пользователям по email
        // Возможно, это будет делать админ)
    }

    // Поиск книги по названию
    public static Book findBook(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // Поиск книги по id
    public static Book findBook(int id) {
        for (Book book : catalog) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Удаление книги по названию
    public static boolean deleteBook(String title) {
        Book findRes = findBook(title);
        if (findRes != null) {
            catalog.remove(findRes);
            return catalogDAO.deleteBook(findRes.getId());
        }
        else {
            return false;
        }
    }

    // Удаление книги по id
    public static boolean deleteBook(int id) {
        Book findRes = findBook(id);
        if (findRes != null) {
            catalog.remove(findRes);
            return catalogDAO.deleteBook(findRes.getId());
        }
        else {
            return false;
        }
    }

    // Возвращает список из названий книг
    public static List<String> getTitles() {
        List<String> res = new ArrayList<>();
        for (Book book : catalog) {
            res.add(book.getTitle());
        }
        return res;
    }

    // Возвращает список из названия, автора(ов), года издания:
    public static List<String> getInfo() {
        List<String> res = new ArrayList<>();
        int i = 1;
        for (Book book : catalog) {
            String str = i + ") Book: " + book.getTitle() + ";" +
                    " Author(s): " + Arrays.toString(book.getAuthors()) + ";" +
                    " year: " + book.getYear() + ".";
            i++;
            res.add(str);
        }
        return res;
    }
}
