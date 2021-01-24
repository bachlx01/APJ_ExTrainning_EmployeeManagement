package model;

import java.time.LocalDate;

public class Employee {
    public static int id = 100000;
    private int ID;
    private String name;
    private int age;
    private LocalDate birthday;
    private String address;
    private String position;
    private String gender;
    private boolean married;
    private int phoneNumber;
    private String email;

    public Employee() {
        this.ID = id++;
    }

    public Employee(int ID, String name, int age, LocalDate birthday, String address,
                    String position, String gender, boolean married, int phoneNumber, String email) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.gender = gender;
        this.married = married;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Employee withName(String name) {
        this.name = name;
        return this;
    }

    public Employee withAge(int age) {
        this.age = age;
        return this;
    }

    public Employee withBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Employee withAddress(String address) {
        this.address = address;
        return this;
    }

    public Employee withPosition(String position) {
        this.position = position;
        return this;
    }

    public Employee withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Employee withMarried(boolean married) {
        this.married = married;
        return this;
    }

    public Employee withPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Employee withEmail(String email) {
        this.email = email;
        return this;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Employee.id = id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", gender='" + gender + '\'' +
                ", married=" + married +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}' + "\n";
    }
}
