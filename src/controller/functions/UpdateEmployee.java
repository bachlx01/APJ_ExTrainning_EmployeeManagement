package controller.functions;

import controller.Controller;
import controller.data.DataHumanController;
import model.Employee;
import view.UserInterface;

import java.util.ArrayList;

public class UpdateEmployee {
    private UserInterface userInterface;
    private DataHumanController controller;
    private String fileName = Controller.HUMAN_PATH;

    public UpdateEmployee() {
        userInterface = UserInterface.getInstance();
        controller = new DataHumanController();
        Controller.employees = Controller.employees;
    }

    public void editEmployee(int ID) {
        if (!checkExistID(ID)) {
            userInterface.showMessage("This phone does not exist");
            return;
        }
        int option = getOption();
        switch (option) {
            case 1:
                String newClass = userInterface.prompt("Enter new name: ");
                updateClass(ID, newClass);
                break;
            case 2:
                String newName = userInterface.prompt("Enter new name: ");
                updateName(ID, newName);
                break;

        }
    }

    public void deleteEmployee(int ID) {
        if (!checkExistID(ID)) {
            userInterface.showMessage("This phone does not exist");
            return;
        }
        Controller.employees.removeIf(e -> ((Employee) e).getID() == ID);
        String confirm = userInterface.prompt("Are you sure delete(y/n): ");
        if (confirm.equals("y")) {
            controller.refreshFile(Controller.employees, fileName);
            userInterface.showMessage("Done!");
        }
    }


    private int getOption() {
        userInterface.showMessage("1. Update name.");
        userInterface.showMessage("2. Update position.");
        int choice;
        try {
            choice = Integer.parseInt(userInterface.prompt("Enter your choice: "));
        } catch (Exception e) {
            userInterface.showMessage("Not an option. Please again");
            return getOption();
        }
        while (choice < 1 || choice > 2) {
            userInterface.showMessage("Not an option. Please again");
            return getOption();
        }
        return choice;
    }

    public void updateClass(int ID, String newName) {
        for (Object e:
                Controller.employees) {
            if (((Employee) e).getID() == ID) {
                ((Employee) e).setName(newName);
            }
        }
//        controller.refreshFile(employees, fileName);
    }

    public void updateName(int ID, String newPosition) {
        for (Object e:
                Controller.employees) {
            if (((Employee) e).getPhoneNumber() == ID) {
                ((Employee) e).setName(newPosition);
            }
        }
//        controller.refreshFile(employees, fileName);
    }

    public boolean checkExistID(int ID){
        for (Object e:
                Controller.employees) {
            if (((Employee) e).getID() == ID){
                return true;
            }
        }
        return false;
    }
}
