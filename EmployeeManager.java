//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String employee[] = line.split(",");
                for (String emp : employee) {
                    System.out.println(emp);
                }
            } catch (Exception exception) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                System.out.println(line);
                String employee[] = line.split(",");
                Random random = new Random();
                int index = random.nextInt(employee.length);
                System.out.println(employee[index]);
            } catch (Exception exception) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                String num= args[0].substring(1);
                writer.write(", " + num);
                writer.close();
            } catch (Exception exception) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String employee[] = line.split(",");
                boolean found = false;
                String s = args[0].substring(1);
                for (int i = 0; i < employee.length && !found; i++) {
                    if (employee[i].equals(s)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception exception) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                char[] chars = l.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception exception) {

            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String employee[] = line.split(",");
                String num = args[0].substring(1);
                for (int i = 0; i < employee.length; i++) {
                    if (employee[i].equals(n)) {
                        employee[i] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", e));
                writer.close();
            } catch (Exception exception) {

            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String employee[] = line.split(",");
                String num = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(employee));
                list.remove(num);
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", list));
                writer.close();
            } catch (Exception exception) {

            }
            System.out.println("Data Deleted.");
        }
    }
}
