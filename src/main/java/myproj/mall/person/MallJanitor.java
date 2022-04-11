/*
 Project: shopping-mall
 Build: Maven
 Class: MallJanitor
*/
package myproj.mall.person;

public class MallJanitor extends Employee{
    // Fields
    private String mallId;
    private String janTitle;
    private int janLvl;

    // Constructors

    public MallJanitor() {
    }

    public MallJanitor(String firstName, String lastName, String gender, String uid, String employeeId, String employeeType, float salary, String mallId, String janTitle, int janLvl) {
        super(firstName, lastName, gender, uid, employeeId, employeeType, salary);
        this.mallId = mallId;
        this.janTitle = janTitle;
        this.janLvl = janLvl;
    }

    // Setters
    public void setMallId(String mallId) {
        this.mallId = mallId;
    }

    public void setJanTitle(String janTitle) {
        this.janTitle = janTitle;
    }

    public void setJanLvl(int janLvl) {
        this.janLvl = janLvl;
    }

    // Getters
    public String getMallId() {
        return mallId;
    }

    public String getJanTitle() {
        return janTitle;
    }

    public int getJanLvl() {
        return janLvl;
    }

    // ToString
    @Override
    public String toString() {
        return "MallJanitor{" +
                "name='" + super.getFirstName() + " " + super.getLastName() + '\'' +
                "mallId='" + mallId + '\'' +
                ", janTitle='" + janTitle + '\'' +
                ", janLvl=" + janLvl + '\'' +
                ", salary=" + super.getSalary() +
                '}';
    }
}
