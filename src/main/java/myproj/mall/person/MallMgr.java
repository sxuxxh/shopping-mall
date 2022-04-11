/*
 Project: shopping-mall
 Build: Maven
 Class: MallMgr
*/
package myproj.mall.person;

import myproj.mall.ShoppingMall;

public class MallMgr extends Employee{
    // Fields
    private String mallId;
    private String mgrTitle;
    private int mgrLvl;

    // Constructors

    public MallMgr() {
    }

    public MallMgr(String firstName, String lastName, String gender, String uid, String employeeId, String employeeType, float salary, String mallId, String mgrTitle, int mgrLvl) {
        super(firstName, lastName, gender, uid, employeeId, employeeType, salary);
        this.mallId = mallId;
        this.mgrTitle = mgrTitle;
        this.mgrLvl = mgrLvl;
    }

    // Setters
    public void setMallId(String mallId) {
        this.mallId = mallId;
    }

    public void setMgrTitle(String mgrTitle) {
        this.mgrTitle = mgrTitle;
    }

    public void setMgrLvl(int mgrLvl) {
        this.mgrLvl = mgrLvl;
    }

    // Getters
    public String getMallId() {
        return mallId;
    }

    public String getMgrTitle() {
        return mgrTitle;
    }

    public int getMgrLvl() {
        return mgrLvl;
    }

    // ToString
    @Override
    public String toString() {
        return "MallMgr{" +
                "name='" + super.getFirstName() + " " + super.getLastName() + '\'' +
                ", mgrTitle='" + mgrTitle + '\'' +
                ", mgrLvl=" + mgrLvl + '\'' +
                ", salary=" + super.getSalary() +
                '}';
    }
}
