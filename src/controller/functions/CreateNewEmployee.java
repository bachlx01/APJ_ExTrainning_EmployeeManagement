package controller.functions;

import model.Employee;
import org.omg.CORBA.PRIVATE_MEMBER;
import view.UserInterface;

import java.time.LocalDate;

public class CreateNewEmployee {
    UserInterface userInterface;
    private final String PHONE_PATTERN = "[0-9]{9,10}";
    private final String EMAIL_PATTERN = "^[a-zA-z][a-zA-z0-9_]+@[a-zA-z]+(\\.[a-zA-z]+)$";

    public CreateNewEmployee() {
        this.userInterface = UserInterface.getInstance();
    }

    public Employee createEmployee() {
        int phoneNumber, age;
        String contactClass, name, gender, address, email, position;
        LocalDate birthday;
        boolean married;

        name = userInterface.prompt("Full name: ");
        age = getAge();
        birthday = getBirthday();
        address = userInterface.prompt("Address: ");
        position = userInterface.prompt("Position: ");
        gender = getGender();
        married = getMarried();
        phoneNumber = getPhoneNumber();
        email = getEmail();

        Employee employee = new Employee().withName(name).withAge(age).withBirthday(birthday);
        employee.withAddress(address).withPosition(position).withGender(gender).withMarried(married);
        employee.withPhoneNumber(phoneNumber).withEmail(email);
        return employee;
    }

    private boolean getMarried() {
        String married = userInterface.prompt("Married(y/n): ");
        return married.equals("y")?true:false;
    }

    private int getAge() {
        try {
            return Integer.parseInt(userInterface.prompt("Age: "));
        } catch (Exception e) {
            userInterface.showMessage("It is not age! Please again!");
            return getAge();
        }
    }

    private String getEmail() {
        String email = userInterface.prompt("Email: ");
        while (!email.matches(EMAIL_PATTERN)) {
            email = userInterface.prompt("Please enter valid email (ex: abc@gmail.com): ");
        }
        return email;
    }

    private LocalDate getBirthday() {
        userInterface.showMessage("_Birthday_");
        String day = userInterface.prompt("Day: ");
        String month = userInterface.prompt("Month: ");
        String year = userInterface.prompt("Year: ");
        try {
            return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (Exception e) {
            userInterface.showMessage("Invalid birthday, please try again.");
            return this.getBirthday();
        }
    }

    private String getGender() {
        int genderIndex;
        String[] arrayGender = {"Male", "Female", "Other"};
        userInterface.showMessage("Option gender: ");
        userInterface.showMessage("1. Male.\n2. Female.\n3. Other.");
        try {
            genderIndex = Integer.parseInt(userInterface.prompt("Enter your choice:"));
        } catch (Exception e) {
            userInterface.showMessage("Not an option. Please again: ");
            return getGender();
        }
        if (genderIndex < 1 || genderIndex >3) {
            userInterface.showMessage("Not an option. Please again: ");
            return getGender();
        }
        return arrayGender[genderIndex-1];
    }

    private int getPhoneNumber() {
        String phoneString = userInterface.prompt("Phone Number: ");

        while (!phoneString.matches(PHONE_PATTERN)) {
            phoneString = userInterface.prompt("Phone Number have 9-11 digits: ");
        }

        return Integer.parseInt(phoneString);
    }

}
