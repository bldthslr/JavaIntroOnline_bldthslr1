package u4_1_SimpleClasses.task9;

import java.util.Arrays;

/**
 * Класс, агрегирующий массив Book, и включающий логику работы с этим массивом.
 */
public class BookArray {
    private Book[] books;

    // Конструктор
    public BookArray (Book ... books) {
        this.books = books;
    }

    // Добавление книги в конец массива
    public void addBook (Book book) {
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = book;
    }

    // Удаление книги по индексу
    public void deleteBook(int index) {
        // Сдвиг влево
        for (int i = index; i < books.length - 1; i++) {
            books[i] = books[i-1];
        }
        // "Обрезаем" последний элемент
        books = Arrays.copyOf(books, books.length - 1);
    }

    // Геттеры
    public Book getBook(int number) {
        return books[number];
    }

    public int getLength() {
        return books.length;
    }

    public int[] getAllIDs() {
        int[] res = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            res[i] = books[i].getId();
        }
        return res;
    }

    public String[] getAllTitles() {
        String[] res = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            res[i] = books[i].getTitle();
        }
        return res;
    }

    public String[] getAllPublishing() {
        String[] res = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            res[i] = books[i].getPublishing();
        }
        return res;
    }

}
