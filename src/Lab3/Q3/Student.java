package Q3;

public class Student extends Person {
    private String school;
    private int year;
    private double fee;

    public Student(String name, String address, String school, int year, double fee) {
        super(name, address);
        this.school = school;
        this.year = year;
        this.fee = fee;
    }

    public String getSchool() {
        return school;
    }

    public int getYear() {
        return year;
    }

    public double getFee() {
        return fee;
    }
}