/*
 Project: shopping-mall
 Build: Maven
 Class: StoreStaff
*/
package myproj.mall.person;

public class StoreStaff extends Employee{
    // Fields
    private String storeId;
    private String staffTitle;
    private int staffLvl;

    // Constructors
    public StoreStaff() {
    }

    public StoreStaff(String firstName, String lastName, String gender, String uid, String employeeId, String employeeType, float salary, String storeId, String staffTitle, int staffLvl) {
        super(firstName, lastName, gender, uid, employeeId, employeeType, salary);
        this.storeId = storeId;
        this.staffTitle = staffTitle;
        this.staffLvl = staffLvl;
    }

    // Setters
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public void setStaffLvl(int staffLvl) {
        this.staffLvl = staffLvl;
    }

    // Getters
    public String getStoreId() {
        return storeId;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public int getStaffLvl() {
        return staffLvl;
    }

    // ToString
    @Override
    public String toString() {
        return "StoreStaff{" +
                "name='" + super.getFirstName() + " " + super.getLastName() + '\'' +
                ", staffTitle='" + staffTitle + '\'' +
                ", staffLvl=" + staffLvl + '\'' +
                ", salary=" + super.getSalary() +
                '}';
    }
}
