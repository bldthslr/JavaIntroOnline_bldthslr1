package dao;

import books_catalog.Book;
import books_catalog.BookTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Символы: 001E - "разделитель записей" для разделения между книгами;
 * 001F - "разделитель полей" для разделения между полями
 */
public class CatalogDAO {
    private List<String> content;
    private FileChanger booksFile;
    public final char bookSeparator = (char) 30;
    public final char fieldSeparator = (char) 31;

    // Конструктор
    public CatalogDAO() {
        booksFile = new FileChanger("data", "Books.txt");
        content = new ArrayList<>();
        if (!createContent()) {
            System.out.println("Error when creating a list of strings ");
        }
    }

    private boolean createContent() {
        try {
            Collections.addAll(content, booksFile.read().split(Character.toString(bookSeparator)));
            for (int i = 0; i < content.size(); i++) {
                if (!content.get(i).equals("") && !content.get(i).equals(System.lineSeparator())) {
                    content.set(i, content.get(i) + bookSeparator);
                }
            }
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }

    // Создаем каталог
    private String bookToStr(Book book) {
        StringBuilder res = new StringBuilder();
        res.append(book.getId()).append(fieldSeparator);
        res.append(book.getTitle()).append(fieldSeparator);
        res.append(book.getPublishing()).append(fieldSeparator);
        res.append(book.getYear()).append(fieldSeparator);
        res.append(book.getPages()).append(fieldSeparator);
        res.append(book.getPrice()).append(fieldSeparator);
        res.append(book.getBindingType()).append(fieldSeparator);
        res.append(book.getType().toString()).append(fieldSeparator);
        for (String author : book.getAuthors()) {
            res.append(author).append(fieldSeparator);
        }
        res.append(System.lineSeparator()).append(bookSeparator);
        return res.toString();
    }

    private Book strToBook (String str) {
        try {
            str = str.replaceAll(System.lineSeparator(), "");
            str = str.replaceAll(Character.toString(bookSeparator), "");
            String[] fields = str.split(Character.toString(fieldSeparator));
            int id = Integer.parseInt(fields[0]);
            String title = fields[1];
            String publishing = fields[2];
            int year = Integer.parseInt(fields[3]);
            int pages = Integer.parseInt(fields[4]);
            int price = Integer.parseInt(fields[5]);
            String bindingType = fields[6];
            String BookTypeStr = fields[7];
            BookTypes type;
            try {
                type = BookTypes.valueOf(BookTypeStr);
            }
            catch (IllegalArgumentException e) {
                type = BookTypes.BOOK;
            }
            String[] authors = new String[fields.length - 8];
            for (int i = 8; i < fields.length; i++) {
                authors[i - 8] = fields[i];
            }
            return new Book(id, title, publishing, year, pages, price, bindingType, type, authors);
        }
        catch (RuntimeException e) {
            return null;
        }
    }

    private List<Book> createCatalog() {
        List<Book> res = new ArrayList<>();
        try {
            // Добавляем обычные книги
            for (String bookStr : content) {
                Book tmp = strToBook(bookStr);
                if (tmp != null) {
                    res.add(tmp);
                }
            }
            return res;
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage() + " |createCatalog()");
            res = new ArrayList<>();
            return res;
        }
    }

    public List<Book> getCatalog() {
        return createCatalog();
    }

    public boolean deleteBook(int id) {
        String strId = String.valueOf(id);
        for (String str : content) {
            if (str.contains(strId)) {
                content.remove(str);
                refresh();
                return true;
            }
        }
        return false;
    }

    public boolean addBook(Book book) {
        content.add(bookToStr(book));
        refresh();
        return true;
    }


    public void refresh() {
        StringBuilder res = new StringBuilder();
        for (String str : content) {
            res.append(str);
        }
        booksFile.refresh(res.toString());
    }
}
