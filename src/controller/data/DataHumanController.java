package controller.data;

import model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataHumanController extends DataController {
    private String fileName;

    @Override
    public boolean writeToFile(Object object, String fileName) {
        Employee employee = (Employee) object;
        if (openFileToWrite(fileName)) {
            String writeData = employee.getID() + " | " + employee.getName() + " | " +
                    employee.getAge() + " | " + employee.getBirthday() + " | " +
                    employee.getAddress() + " | " + employee.getPosition() + " | " +
                    employee.getGender() + " | " + employee.isMarried() + " | " +
                    employee.getPhoneNumber() + " | " + employee.getEmail();
            printWriter.println(writeData);
            closeFileAfterWrite(fileName);
            return true;
        }
        return false;

    }

    @Override
    public ArrayList<Object> readFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<Object> employees = new ArrayList<Object>();

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Employee employee = createEmployeeFromData(data);
            employees.add(employee);
        }
        closeFileAfterRead(fileName);
        return employees;
    }

    @Override
    public boolean refreshFile(ArrayList<Object> contactors, String fileName) {
        if (openFileToUpdate(fileName)){
            closeFileAfterWrite(fileName);
            for (Object e :
                    contactors) {
                writeToFile(e, fileName);
            }
            return true;
        }
        return false;
    }

    private Employee createEmployeeFromData(String data) {
        String[] arrayData = data.split(" \\| ");

        String[] yearMonthDay = arrayData[3].split("-");
        LocalDate birthday = LocalDate.of(Integer.parseInt(yearMonthDay[0]),
                Integer.parseInt(yearMonthDay[1]), Integer.parseInt(yearMonthDay[2]));

        Employee employee = new Employee(Integer.parseInt(arrayData[0]), arrayData[1],
                Integer.parseInt(arrayData[2]), birthday, arrayData[4], arrayData[5],
                arrayData[6], Boolean.parseBoolean(arrayData[7]), Integer.parseInt(arrayData[8]),
                arrayData[9]);
        return employee;
    }
}
