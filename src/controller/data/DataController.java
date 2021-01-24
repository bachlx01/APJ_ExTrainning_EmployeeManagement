package controller.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DataController {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter printWriter;
    Scanner scanner;


    public abstract boolean writeToFile(Object object, String fileName);

    public abstract ArrayList<Object> readFromFile(String fileName);

    public abstract boolean refreshFile(ArrayList<Object> contactors, String fileName);

    public boolean openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeFileAfterWrite(String fileName) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean openFileToUpdate(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void openFileToRead(String fileName) {
        try {
            scanner = new Scanner(Paths.get(fileName), "UTF-8");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void closeFileAfterRead(String fileName) {
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
