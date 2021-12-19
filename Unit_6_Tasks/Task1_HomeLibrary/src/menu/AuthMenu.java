package menu;

import roles.User;

import java.util.Locale;
import java.util.Scanner;

public class AuthMenu {
    private static Scanner in = new Scanner(System.in);

    public static User logIn() {
        System.out.println("The program “Accounting of books in the home library\" welcomes you! " + "\n" +
                "If you want to register, enter \"r\" or \"registration\". " + "\n" +
                "Enter an empty string (or any other character) if you want to log in.");
        String isReg = in.nextLine();
        if ((isReg.toLowerCase(Locale.ROOT).equals("r")) || (isReg.toLowerCase(Locale.ROOT).equals("registration"))) {
            return registration();
        }
        else return authorization();
    }

    public static User authorization() {
        System.out.println("Login:");
        String login = in.nextLine();
        System.out.println("Password:");
        String password = in.nextLine();
        switch (AuthLogic.auth(login, password)) {
            case 0, 1 -> {
                User currentUser = AuthLogic.getCurrentUser();
                System.out.println("Login completed, u logged as "
                        + currentUser.getRole().toString() + " \"" + currentUser.getLogin() + "\".");
                return currentUser;
            }
            case 1000 -> {
                System.out.println("Error! Invalid Login! Please try again...");
                return authorization();
            }
            case 1001 -> {
                System.out.println("Error! Invalid Password! Please try again...");
                return authorization();
            }
            default -> {
                System.out.println("An unexpected exception! Please try again...");
                return authorization();
            }
        }
    }

    /**
     * Меню регистрации нового пользователя
     * @return
     */
    public static User registration(){
        System.out.println("Enter your username(login)");
        String login = in.nextLine();
        System.out.println("Enter your password:");
        String password = in.nextLine();
        System.out.println("Enter your email:");
        String email = in.nextLine();
        switch (AuthLogic.addUser(login, password, email, "user")) {
            case 0 -> {
                // Если пользователь успешно добавлен, сразу проводим авторизацию
                int authCode = AuthLogic.auth(login, password);
                if (authCode == 0) {
                    User currentUser = AuthLogic.getCurrentUser();
                    System.out.println("Registration completed, u logged as "
                            + currentUser.getRole().toString() +" \"" + currentUser.getLogin() + "\".");
                    return currentUser;
                }
                else {
                    System.out.println("You have registered, but an unexpected error occurred during authorization! " + "\n" +
                            "Error # " + authCode + "\n" +
                            "Try logging in...");
                    return authorization();
                }
            }
            case 2001 -> {
                System.out.println("Error! This login is already occupied! Please try again...");
                return registration();
            }
            case 2002 -> {
                System.out.println("Error! It is not possible to register a user with such a role! Please try again...");
                return registration();
            }
            case 2003 -> {
                System.out.println("Error! Invalid email! Please try again...");
                return registration();
            }
            case -1 -> {
                System.out.println("Unexpected error! Input 0 to go to the main menu, or any other key to try again...");
                String isExit = in.nextLine();
                if (isExit.equals("0")) {
                    return logIn();
                }
                else {
                    return registration();
                }
            }
            case -2  -> {
                System.out.println("Error while writing to a file! Input 0 to go to the main menu, or any other key to try again...");
                String isExit = in.nextLine();
                if (isExit.equals("0")) {
                    return logIn();
                }
                else {
                    return registration();
                }
            }
            default -> {
                System.out.println("Something gone completely wrong! returning to main menu:");
                return logIn();
            }
        }
    }
}