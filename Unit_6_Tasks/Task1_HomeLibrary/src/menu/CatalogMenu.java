package menu;

import roles.Roles;
import roles.User;

import java.util.Scanner;

public class CatalogMenu {
    private final Scanner in = new Scanner(System.in);
    private static User currentUser;

    public static void run(){
        currentUser = AuthMenu.logIn();
        switch (currentUser.getRole()) {
            case ADMIN -> runAdminSession();
            case USER -> runUserSession();
            default -> runUserSession();
        }
    }

    private static void runAdminSession(){

    }

    private static void runUserSession(){

    }
}
