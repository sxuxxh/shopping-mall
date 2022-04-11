/*
 Project: shopping-mall
 Build: Maven
 Class: Employee
*/
package myproj.mall.person;

public class Employee extends Person{
    // Fields
    private String uid;
    private String employeeId;
    private String employeeType;
    private float salary;

    // Constructors
    public Employee() {
    }

    public Employee(String firstName, String lastName, String gender, String uid, String employeeId, String employeeType, float salary) {
        super(firstName, lastName, gender);
        this.uid = uid;
        this.employeeId = employeeId;
        this.employeeType = employeeType;
        this.salary = salary;
    }

    // Setters
    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Getters
    public String getUid() {
        return uid;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public float getSalary() {
        return salary;
    }

    // ToString
    @Override
    public String toString() {
        return "Employee{" +
                "uid='" + uid + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", salary=" + salary +
                '}';
    }
}
