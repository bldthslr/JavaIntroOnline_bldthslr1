package roles;

import books_catalog.Book;
import books_catalog.Catalog;

import java.util.List;

public class User {
    protected String login;
    protected String password_hash;
    protected String email;
    protected Roles role;

    public User(String login, String password_hash, String email, Roles role) {
        this.login = login;
        this.password_hash = password_hash;
        this.email = email;
        this.role = role;
    }

    public User(String login, String password_hash, String email, int roleID) {
        this.login = login;
        this.password_hash = password_hash;
        this.email = email;
        switch (roleID) {
            case 0:
                this.role = Roles.USER;
                break;
            case 1:
                this.role = Roles.ADMIN;
                break;
            default:
                this.role = Roles.USER;
        }
    }

    // Геттеры
    public String getLogin() {
        return login;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public String getEmail() {
        return email;
    }

    public Roles getRole() {
        return role;
    }

    // Действия пользователя
    public List<String> getInfo() {
        return Catalog.getInfo();
    }

    public String findBook(String name) {
        Book res = Catalog.findBook(name);
        if (res != null) {
            return res.toString();
        }
        else {
            return "No book with that name was found!";
        }
    }

    // Действия Админа:
    public boolean addBook(Book book){
        if (role == Roles.ADMIN) {
            return Catalog.addBook(book);
        }
        else {
            System.out.println("You do not have permission to perform this operation");
            return false;
        }
    }

    public boolean deleteBook(String title) {
        if (role == Roles.ADMIN) {
            return Catalog.deleteBook(title);
        }
        else {
            System.out.println("You do not have permission to perform this operation");
            return false;
        }
    }

    public boolean deleteBook(int id) {
        if (role == Roles.ADMIN) {
            return Catalog.deleteBook(id);
        }
        else {
            System.out.println("You do not have permission to perform this operation");
            return false;
        }
    }
}
