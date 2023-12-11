package Lab5;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Project {
    private String projectID;
    private Date startDate, endDate;
    private int estimateBudget;
    private ArrayList<Employee> listOfEmployee;

    public Project(String projectID, Date startDate, Date endDate, int estimateBudget, ArrayList<Employee> listOfEmployee) {
        this.projectID = projectID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estimateBudget = estimateBudget;
        this.listOfEmployee = listOfEmployee;
    }
    
    public long estimateBudget() {
        int budget = 0; 
        for (Employee employee : listOfEmployee) {
            budget = budget + employee.getSalaryPerHour() * 24 * 7;     //Weekly salary
        }
        
        long milliSecondsElapsed = endDate.getTime() - startDate.getTime();
        long diff = TimeUnit.MINUTES.convert(milliSecondsElapsed, TimeUnit.MILLISECONDS);
        diff = diff / (1440 * 7);
        return budget * diff;
    }

    public String toString () {
        String listE = ""; 
        for (Employee employee : listOfEmployee) {
            listE = listE + "\n" + employee;
        }
        return listE;
    }


    // Gettters and Setters
     public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Employee> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(ArrayList<Employee> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public int getEstimatedBudget() {
        return estimateBudget;
    }

    public void setEstimatedBudget (int estimateBudget) {
        this.estimateBudget = estimateBudget;
    }
}