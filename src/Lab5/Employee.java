package Lab5;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    private String employeeID, employeeName;
    private int salaryPerHour, noOfLeavingDay, noOfTravelDay;

    // Constructor
    public Employee (String employeeID, String employeeName, int salaryPerHour, int noOfLeavingDay, int noOfTravelDay) {
        this.employeeID = employeeID; 
        this.employeeName = employeeName;
        this.salaryPerHour = salaryPerHour;
        this.noOfLeavingDay = noOfLeavingDay;
        this.noOfTravelDay = noOfTravelDay;
    }
    
    public int calculateWeeklySalary () {
        return salaryPerHour * 8 * (5 - noOfLeavingDay + noOfTravelDay / 2);
    }

    public String toString() {
        return ("[Name: " + employeeName + " - " + "Salary/Hour: " + salaryPerHour + " - " +
                "Weekly Salary: " + calculateWeeklySalary() + "]");
    }

    @Override
    public int compareTo(Employee other) {
        return this.employeeID.compareTo(other.getEmployeeID());
    }
    
    public static class byDate implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            if (employee1.noOfTravelDay > employee2.noOfTravelDay)
                return 1;
            else if (employee1.noOfTravelDay < employee2.noOfTravelDay)
                return -1;
            else {
                if (employee1.noOfLeavingDay > employee2.noOfLeavingDay)
                    return 1;
                else if (employee1.noOfLeavingDay < employee2.noOfLeavingDay)
                    return -1;
                        else 
                            return 0;
            }       
        }
    }


    // Getters and Setters
     public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int getNoOfLeavingDay() {
        return noOfLeavingDay;
    }

    public void setNoOfLeavingDay(int noOfLeavingDay) {
        this.noOfLeavingDay = noOfLeavingDay;
    }

    public int getNoOfTravelDay() {
        return noOfTravelDay;
    }

    public void setNoOfTravelDay(int noOfTravelDay) {
        this.noOfTravelDay = noOfTravelDay;
    }
}