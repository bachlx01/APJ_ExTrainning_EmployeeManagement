package controller;

import controller.data.DataHumanController;
import controller.functions.CreateNewEmployee;
import controller.functions.UpdateEmployee;
import model.Employee;
import view.UserInterface;

import java.util.ArrayList;

public class Controller {
    public static final String HUMAN_PATH = "human.txt";
    UserInterface userInterface;
    private DataHumanController controller;
    private CreateNewEmployee createNewEmployee;
    private UpdateEmployee updateEmployee;
    public static ArrayList<Object> employees;

    public Controller() {
        userInterface = UserInterface.getInstance();
        controller = new DataHumanController();
        createNewEmployee = new CreateNewEmployee();
        updateEmployee = new UpdateEmployee();
        employees = controller.readFromFile(HUMAN_PATH);
    }

    public void execute(String optionString) {
        int option = checkOption(optionString);
        int ID;
        switch (option){

            case 1:
                userInterface.showMessage(employees.toString());
                break;
            case 2:
                Employee employee = createNewEmployee.createEmployee();
                employees.add(employee);
//                controller.writeToFile(employee, HUMAN_PATH);
                break;
            case 3:
                try {
                    ID = Integer.parseInt(userInterface.prompt("Enter the employee ID your want to update: "));
                    updateEmployee.editEmployee(ID);
                } catch (Exception e) {
                    userInterface.showMessage("It does not exist!");
                }
                break;
            case 4:
                try {
                    ID = Integer.parseInt(userInterface.prompt("Enter the employee ID your want to update: "));
                    updateEmployee.deleteEmployee(ID);
                } catch (Exception e) {
                    userInterface.showMessage("It does not exist!");
                }
                break;
            case 5:
                break;
            case 6:
                controller.refreshFile(employees, HUMAN_PATH);
                break;
            case 0:
                break;

        }
    }

    public int checkOption(String option) {
        try {
            return Integer.parseInt(option);
        } catch (Exception e) {
            userInterface.showMessage("Not an option");
        }
        return -1;
    }
}
