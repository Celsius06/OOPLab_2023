package Lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Scanner;

// Main
public class Main {
    public static Date stringToDate(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formatter.parse(dateInString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Employee createEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Enter employee name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter hourly salary: ");
        int salaryPerHour = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter number of leaving days: ");
        int noOfLeavingDay = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter number of travel days: ");
        int noOfTravelDay = scanner.nextInt();
        scanner.nextLine();
        return new Employee(employeeID, employeeName, salaryPerHour, noOfLeavingDay, noOfTravelDay);
    }

    public static Project createProject(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter project ID: ");
        String projectID = scanner.nextLine();

        System.out.print("Enter start date of the project (dd/mm/yyyy): ");
        Date startDate = stringToDate(scanner.nextLine());
        System.out.print("Enter end date of the project (dd/mm/yyyy): ");
        Date endDate = stringToDate(scanner.nextLine());

        return new Project(projectID, startDate, endDate, 0,  employees);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Employee> byDate = new Employee.byDate();

        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 1; i <= numEmployees; i++) {
            System.out.println("\nEnter details for employee " + i + ": ");
            employees.add(createEmployee(scanner));
        }

        System.out.println("\nEnter details for the project: ");
        Project project = createProject(employees, scanner);

        ProjectPrinter pp = new ProjectPrinter(project);
        Thread thread = new Thread(pp);
        thread.start();
        
        System.out.println(project.toString());
        System.out.println("Estimated Budget: " + project.estimateBudget());
        System.out.println("Comparison: ");

        if (employees.size() >= 2) {
            System.out.println("Employee 1 -> 2 is: " + byDate.compare(employees.get(0), employees.get(1)));
            System.out.println("Employee 2 -> 1 is: " + byDate.compare(employees.get(1), employees.get(0)));
        } 
        if (employees.size() > 2) {
            System.out.println("Employee 1 -> 3 is: " + byDate.compare(employees.get(0), employees.get(2)));
            System.out.println("Employee 2 -> 3 is: " + byDate.compare(employees.get(1), employees.get(2)));
        } 
        if (employees.size() < 2) {
            System.out.print("Not enough employees for comparison. ");
        }
        // Use byDate comparator to sort the employees
        Collections.sort(employees, byDate);
        // Rank the employees
        System.out.println("Rank of the employees after the comparison:");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println((i + 1) + ". " + employee.getEmployeeName() + " - Leaving days: " + employee.getNoOfLeavingDay() + " - Travel days: " + employee.getNoOfTravelDay());
        }
        scanner.close();
    }
}