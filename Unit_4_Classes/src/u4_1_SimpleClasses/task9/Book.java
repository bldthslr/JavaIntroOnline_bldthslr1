package u4_1_SimpleClasses.task9;

import java.util.Arrays;

/**
 * "9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
 * метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 *
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года."
 *
 * Класс, агрегирующий массив типа Book, предствален в классе BookArray
 * Код, демонстрирующий возможности класса предстваленн в классе "BookUsage".
 */
public class Book {
    private int id, year, pages, price;
    private String title, publishing, bindingType;
    private String[] authors;

    // Конструктор, который принимает все значения, кроме id
    public Book(String title, String publishing, int year, int pages, int price, String bindingType, String ... authors) {
        id = (int) (Math.random() * 2147483646);
        this.title = title;
        this.publishing = publishing;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
        this.authors = authors;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishing() {
        return publishing;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public int getPrice() {
        return price;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getBindingType() {
        return bindingType;
    }


    // Сеттеры
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Поскольку мы имеем массив авторов, предусмотрим добавление и удаление автора
    public void addAuthor(String author) {
        authors = Arrays.copyOf(authors, author.length() + 1);
        authors[authors.length - 1] = author;
    }

    public void deleteAuthor(String author) {
        // Проходим по массиву
        for (int i = 0; i < authors.length; i++) {
            // Если нашли совпадение, то от текущего индекса делаем смещение и удаление последнего элемента
            if (authors[i] == author) {
                for (int j = i; j < authors.length - 1; j++) {
                    authors[i] = authors[i + 1];
                }
                // "Обрезаем" массив
                authors = Arrays.copyOf(authors, author.length() - 1);
            }
        }
    }

    //toString
    @Override
    public String toString() {
        return "ID: "            + id                         + ";\n" +
                "Title: "        + title                      + ";\n" +
                "Publishing: "   + publishing                 + ";\n" +
                "Year: "         + year                       + ";\n" +
                "Pages: "        + pages                      + ";\n" +
                "Price: "        + price                      + ";\n" +
                "Binding type: " + bindingType                + ";\n" +
                "Authors: "      + Arrays.toString(authors)   + ".\n";
    }
}

