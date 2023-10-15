package Assignments.Assignment1;

public class Faculty extends Human {
    private int empID;
    private int salary;
    private String specalization;

    Faculty(int age, String gender, String name, int empID, int salary, String specalization) {
        super(age, gender, name);
        this.empID = empID;
        this.salary = salary;
        this.specalization = specalization;
    }

    public int getEmpID() {
        return empID;
    }

    public int getSalary() {
        return salary;
    }

    public String getSpecalization() {
        return specalization;
    }
}
