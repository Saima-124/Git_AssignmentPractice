//File Name: EmployeeManager.java
import java.io.*;
import java.util.*;

import javax.swing.SpringLayout.Constraints;

public class EmployeeManager {
    public static void main(String[] args) {
        // Check arguments
        if(arg[0]!=1){
           menu();
           return;
        }
         // List all employees
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                for (String emp : readEmployeesFromFile()) {
                    System.out.println(emp);
                }
            } catch (Exception exception) {
                exception.printStackTrace();

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            // Show a random employee
            System.out.println("Loading data ...");
            try {
               
                String[] employee = readEmployeesFromFile();
                System.out.println(employee[new Random().nextInt(employee.length)]);
            } catch (Exception exception) {
            exception.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            // Add new employee
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(Constants.EMPLOYEES_FILE_PATH, true));
                        bufferedWriter.write(args[0].substring(1));
               
            } catch (Exception exception) {
             exception.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            // Search employee
            System.out.println("Loading data ...");
            try {
                String[] employee = readEmployeesFromFile();
                String searchEmployee = args[0].substring(1);
                boolean found = Arrays.asList(employee).contains(searchEmployee);
                if(found){
                    System.out.println("Employee is found");
                }else{
                    System.out.println("Employee is not found");
                }
            } catch (Exception exception) {
                exception.printStackTrace();

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            // Count the words 
            System.out.println("Loading data ...");
            try {
                int totalCount = 0;
                for(String employeeName : readEmployeesFromFile()){
                    totalCount+=employeeName.split(" ").length;
                }
                System.out.println(wordcount + "Words found");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            // Update employee
            System.out.println("Loading data ...");
            try {
                for (String employees : readEmployeesFromFile()) {
                    if (employee[i].equals(args[0].substring(1))) {
                        employee[i] = "Updated";
                    }
                }
                writeEmployeesToFile();
            } catch (Exception exception) {
                exception.printStackTrace();

            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            //Delete employee
            System.out.println("Loading data ...");
            try {
                List<String> list = new ArrayList<>(Arrays.asList(readEmployeesFromFile()));
                employeeList.remove(args[0].substring(1));
                writeEmployeesToFile(employeeList.toArray(new String[0]));
                
            } catch (Exception exception) {
                exception.printStackTrace();

            }
            System.out.println("Data Deleted.");
        }
        else{
            menu();
        }
    }
}
public static void menu(){
    System.out.println("Invalid options. Please enter the following options :");
    System.out.println("l : list the employees");
    System.out.println("s : show a random employee");
    System.out.println("+<name> : add new employee");
    System.out.println("?<name> : search the employee");
    System.out.println("c : count the number of words");
    System.out.println("u<name> : update the employee");
}
public static String[] readEmployeeFromFile() throws IOException{
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(
                new FileInputStream(Constants.EMPLOYEES_FILE_PATH)));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            return line.split(" ");
}
public static String[] rwriterEmployeeToFile() throws IOException{
    BufferedReader bufferedWriter = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEES_FILE_PATH));
            bufferedWriter.write(String.join(",",employee));
            bufferedReader.close();
            
}