package books_catalog;

import java.util.Arrays;

public class Book {
    private int id;
    private int year, pages, price;
    private String title;
    private String publishing;
    private String bindingType;
    private String[] authors;
    private BookTypes type;

    // Конструктор, который принимает все значения, кроме id
    public Book(int id, String title, String publishing, int year, int pages, int price, String bindingType, BookTypes type, String ... authors) {
        this.id = id;
        this.title = title;
        this.publishing = publishing;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
        this.type = type;
        this.authors = authors;
    }
    // Конструктор, который принимает все значения, кроме id
    public Book(String title, String publishing, int year, int pages, int price, String bindingType, BookTypes type, String ... authors) {
        id = (int) (Math.random() * 2147483646);
        this.title = title;
        this.publishing = publishing;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
        this.type = type;
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

    public BookTypes getType() {
        return type;
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
        return
                "ID: "           + id                         + ";\n" +
                "Title: "        + title                      + ";\n" +
                "Publishing: "   + publishing                 + ";\n" +
                "Year: "         + year                       + ";\n" +
                "Pages: "        + pages                      + ";\n" +
                "Price: "        + price                      + ";\n" +
                "Binding type: " + bindingType                + ";\n" +
                "Authors: "      + Arrays.toString(authors)   + ".\n";
    }
}
