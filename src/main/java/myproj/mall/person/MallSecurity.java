/*
 Project: shopping-mall
 Build: Maven
 Class: MallSecurity
*/
package myproj.mall.person;

public class MallSecurity extends Employee{
    // Fields
    private String mallId;
    private String secTitle;
    private int secLvl;

    // Constructors
    public MallSecurity() {
    }

    public MallSecurity(String firstName, String lastName, String gender, String uid, String employeeId, String employeeType, float salary, String mallId, String secTitle, int secLvl) {
        super(firstName, lastName, gender, uid, employeeId, employeeType, salary);
        this.mallId = mallId;
        this.secTitle = secTitle;
        this.secLvl = secLvl;
    }

    // Setters
    public void setMallId(String mallId) {
        this.mallId = mallId;
    }

    public void setSecTitle(String secTitle) {
        this.secTitle = secTitle;
    }

    public void setSecLvl(int secLvl) {
        this.secLvl = secLvl;
    }

    // Getters
    public String getMallId() {
        return mallId;
    }

    public String getSecTitle() {
        return secTitle;
    }

    public int getSecLvl() {
        return secLvl;
    }

    // ToString
    @Override
    public String toString() {
        return "MallSecurity{" +
                "name='" + super.getFirstName() + " " + super.getLastName() + '\'' +
                "mallId='" + mallId + '\'' +
                ", secTitle='" + secTitle + '\'' +
                ", secLvl=" + secLvl + '\'' +
                ", salary=" + super.getSalary() +
                '}';
    }
}
