package menu;

import dao.BladeHash;
import dao.UsersDAO;
import roles.Roles;
import roles.User;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthLogic {
    private static UsersDAO usersDAO = new UsersDAO();
    private static List<User> users = usersDAO.getCatalog();
    private static User currentUser = null;

    public AuthLogic() {
        usersDAO = new UsersDAO();
        users = usersDAO.getCatalog();
    }

    /**
     * Метод для авторизации. Возвращает код, сообщающий о результате авторизации:
     * 0 - Вход успешный, роль - пользователь;
     * 1 - Вход успешный, роль - администратор;
     * 1000 - Вход не выполнен, неверный логин;
     * 1001 - Вход не выполнен, неверный пароль;
     * -1 - Вход не выполнен, непредвиденная ошибка.
     * @param login - Логин;
     * @param password - Пароль;
     * @return - Код авторизации.
     */
    public static int auth(String login, String password) {
        try {
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    if (user.getPassword_hash().equals(BladeHash.bladeHash256(password))) {
                        // Если нашли такого пользователя, то выберем его роль и вернем соответствующий код.
                        switch (user.getRole()) {
                            case USER -> {
                                // Присваиваем текущего юзера к CurrentUser;
                                currentUser = user;
                                return 0;
                            }
                            case ADMIN -> {
                                currentUser = user;
                                return 1;
                            }
                        }
                    }
                    // Если не найден пароль, то ЛОГИН верный, а пароль нет
                    else {
                        return 1001;
                    }
                }
            }
            // После прохода по циклу логин не был найден
            return 1000;
        }
        catch (Exception e) {
            return -1;
        }
    }

    // Возвращает текущего пользователя
    public static User getCurrentUser() {
        return currentUser;
    }


    /**
     * Проверка, существует ли пользователь с таким Логином.
     * @param login - Логин;
     * @return - false - если логин найден(проверка не пройдена), иначе true(проверка пройдена).
     */
    private static boolean checkLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка на валидность email адреса.
     * @param email - Адрес.
     * @return - True, если проверка пройдена, иначе false.
     */
    private static boolean checkValidEmail(String email) {
        Pattern pt = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Matcher mt = pt.matcher(email);
        return mt.find();
    }


    /**
     * Метод для добавления нового пользователя. Это может быть как регистрация, так и добавление пользователя админом.
     * Метод возвращает код:
     * 0 - Пользователь успешно добавлен;
     * 2001 - Ошибка, такой логин уже существует;
     * 2002 - Ошибка, такой роли не существует;
     * 2003 - Ошибка, Email не валидный;
     * -1 - Непредвиденная ошибка;
     * -2 - Ошибка во время записи в файл.
     * @param login - Логин;
     * @param password - Пароль;
     * @param email - Электронный адрес;
     * @param role - Роль (типа String);
     * @return - код выполнения метода.
     */
    public static int addUser(String login, String password, String email, String role) {
        // Проверим, есть ли существующая роль, если нет, вернем код ошибки
        Roles curRole = null;
        for (Roles rol: Roles.values()) {
            if (rol.toString().equals(role.toUpperCase(Locale.ROOT))) {
                curRole = rol;
            }
        }
        if (curRole == null) {
            return 2002;
        }
        // Если проверка на логин пройдена
        if (checkLogin(login)) {
            try {
                // Проверим email на валидность, если проверка не пройдена, вернем код ошибки
                if (!checkValidEmail(email)) {
                    return 2003;
                }
                if (usersDAO.addUser(new User(login, BladeHash.bladeHash256(password), email, curRole))) {
                    users = usersDAO.getCatalog();
                    return 0;
                }
                else {
                    return -2;
                }
            }
            catch (Exception e) {
                return -1;
            }
        }
        // Ошибка: такой логин уже существует
        else {
            return 2001;
        }
    }
}
