package Lab5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProjectPrinter implements Runnable {
    private Project proj;
    private ArrayList<Employee> employeeList;

    public ProjectPrinter(Project proj) {
        this.proj = proj;
        this.employeeList = new ArrayList<>(proj.getListOfEmployee());
    }

    @Override
    public void run() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            for (Employee employee : employeeList) {
                System.out.println("[Project ID: " + proj.getProjectID() + " - " +
                        "Project Duration: " + dateFormat.format(proj.getStartDate()) +
                        " to " + dateFormat.format(proj.getEndDate()) + "]" +
                        "[" + "Name: " + employee.getEmployeeName() + " - " +
                        " Salary/Hour: " + employee.getSalaryPerHour() + "]");
            }
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.out.println("Thread is interrupted");
        }
    }
}