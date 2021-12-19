package dao;

import roles.Roles;
import roles.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersDAO {
    private List<User> users;
    private List<String> content;
    private FileChanger usersFile;
    public final char USER_SEPARATOR = (char) 30;
    public final char ATTR_SEPARATOR = (char) 31;

    // Конструктор
    public UsersDAO() {
        usersFile = new FileChanger("data", "Users.txt");
        content = new ArrayList<>();
        if (!createContent()) {
            System.out.println("Error when creating a list of strings ");
        }
        else {
            this.users = createCatalog();
        }
    }

    private boolean createContent() {
        try {
            Collections.addAll(content, usersFile.read().split(Character.toString(USER_SEPARATOR)));
            for (int i = 0; i < content.size(); i++) {
                if (!content.get(i).equals("") && !content.get(i).equals(System.lineSeparator())) {
                    content.set(i, content.get(i) + USER_SEPARATOR);
                }
            }
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }

    // Создаем каталог
    private String userToStr(User user) {
        StringBuilder res = new StringBuilder();
        res.append(user.getLogin()).append(ATTR_SEPARATOR);
        res.append(user.getPassword_hash()).append(ATTR_SEPARATOR);
        res.append(user.getEmail()).append(ATTR_SEPARATOR);
        res.append(user.getRole().toString()).append(ATTR_SEPARATOR);
        res.append(System.lineSeparator()).append(USER_SEPARATOR);
        return res.toString();
    }

    private User strToUser (String str) {
        try {
            str = str.replaceAll(System.lineSeparator(), "");
            str = str.replaceAll(Character.toString(USER_SEPARATOR), "");
            String[] fields = str.split(Character.toString(ATTR_SEPARATOR));
            String login = fields[0];
            String password_hash = fields[1];
            String email = fields[2];
            Roles role;
            String roleType = fields[3];
            try {
                role = Roles.valueOf(roleType);
            }
            catch (IllegalArgumentException e) {
                role = Roles.USER;
            }
            return new User(login, password_hash, email, role);
        }
        catch (RuntimeException e) {
            return null;
        }
    }

    private List<User> createCatalog() {
        List<User> res = new ArrayList<>();
        try {
            // Добавляем обычные книги
            for (String userStr : content) {
                User tmp = strToUser(userStr);
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

    public List<User> getCatalog() {
        if (users != null) {
            return users;
        }
        else {
            return createCatalog();
        }
    }

    public void refresh() {
        StringBuilder res = new StringBuilder();
        for (String str : content) {
            res.append(str);
        }
        usersFile.refresh(res.toString());
        this.users = createCatalog();
    }

    public boolean addUser(User user) {
        try {
            content.add(userToStr(user));
            refresh();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


}
