//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

import javax.swing.SpringLayout.Constraints;

public class EmployeeManager {
    public static void main(String[] args) {
        // Check arguments
        if(arg[0]!=1){
            System.out.println("Usage: EmployeeManager <options>");
            System.out.println("Options : ");
            System.out.println("l : list the employees");
            System.out.println("s : show a random employee");
            System.out.println("+<name> : add new employee");
            System.out.println("?<name> : search the employee");
            System.out.println("c : count the number of words");
            System.out.println("u<name> : update the employee");
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                
                String[] employee = readEmployeesFromFile();
                for (String emp : employee) {
                    System.out.println(emp);
                }
            } catch (Exception exception) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
               
                String[] employee = readEmployeesFromFile();
                Random random = new Random();
                int index = random.nextInt(employee.length);
                System.out.println(employee[index]);
            } catch (Exception exception) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String num= args[0].substring(1);
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                
               
            } catch (Exception exception) {
                bufferedWriter.write(", " + num);
                bufferedWriter.close();
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String[] employee = readEmployeesFromFile();
                boolean found = false;
                String searchEmployees = args[0].substring(1);
                for (int i = 0; i < employee.length && !found; i++) {
                    if (employee[i].equals(searchEmployees)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception exception) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String[] employee = readEmployeesFromFile();
                int wordcount = 0;
                for(String employees : employee){
                    wordcount+=employees.split(" ").length;
                }
            } catch (Exception exception) {
            System.out.println(wordcount + "Words found");
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String[] employee = readEmployeesFromFile();
                String employeeToUpdate = args[0].substring(1);
                for (int i = 0; i < employee.length; i++) {
                    if (employee[i].equals(employeeToUpdate)) {
                        employee[i] = "Updated";
                    }
                }
                writeEmployeesToFile();
            } catch (Exception exception) {

            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
               String[] employee = readEmployeesFromFile();
                String employeeToDelete = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(employee));
                employeeList.remove(employeeToDelete);
                writeEmployeesToFile(employeeList.toArray(new String[0]));
                
            } catch (Exception exception) {

            }
            System.out.println("Data Deleted.");
        }
    }
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