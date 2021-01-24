package view;

import java.util.Scanner;

public class UserInterface {
    private static UserInterface instance;
    Scanner scanner;

    private UserInterface() {
        scanner = new Scanner(System.in);
    }

    public synchronized static UserInterface getInstance() {
        if (instance == null) {
            instance = new UserInterface();
        }
        return instance;
    }

    public void showMenu() {
        showMessage("---------- HUMAN MANAGEMENT MENU ----------");
        showMessage("1. Show list employee.");
        showMessage("2. Add new employee.");
        showMessage("3. Update.");
        showMessage("4. Delete.");
        showMessage("5. Search.");
        showMessage("6. Save change");
        showMessage("0. Exit.");
    }

    public boolean login() {
        String userID = "admin";
        String pass = "1";

        String ID = prompt("ID: ");
        String password = prompt("Password: ");

        String confirm;

        if (ID.equals(userID)  && password.equals(pass)) {
            return true;
        } else if (ID.equals(userID)) {
            confirm = prompt("password was wrong! Do you want to again(y/n):");
            if (confirm.equals("y")) {
                return login();
            }
        } else if (pass.equals(password)) {
            confirm = prompt("ID was wrong! Do you want to again(y/n):");
            if (confirm.equals("y")) {
                return login();
            }
        } else {
            confirm = prompt("Login info was wrong! Do you want to again(y/n):");
            if (confirm.equals("y")) {
                return login();
            }
        }

        return false;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public String prompt() {
        return scanner.nextLine();
    }
}
