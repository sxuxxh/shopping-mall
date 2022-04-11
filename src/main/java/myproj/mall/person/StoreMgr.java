/*
 Project: shopping-mall
 Build: Maven
 Class: StoreMgr
*/
package myproj.mall.person;

public class StoreMgr extends Employee{
    // Fields
    private String storeId;
    private String mgrTitle;
    private int mgrLvl;

    // Constructors
    public StoreMgr() {
    }

    public StoreMgr(String firstName, String lastName, String gender, String uid, String employeeId, String employeeType, float salary, String storeId, String mgrTitle, int mgrLvl) {
        super(firstName, lastName, gender, uid, employeeId, employeeType, salary);
        this.storeId = storeId;
        this.mgrTitle = mgrTitle;
        this.mgrLvl = mgrLvl;
    }

    // Setters
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setMgrTitle(String mgrTitle) {
        this.mgrTitle = mgrTitle;
    }

    public void setMgrLvl(int mgrLvl) {
        this.mgrLvl = mgrLvl;
    }

    // Getters
    public String getStoreId() {
        return storeId;
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
        return "StoreMgr{" +
                "name='" + super.getFirstName() + " " + super.getLastName() + '\'' +
                ", mgrTitle='" + mgrTitle + '\'' +
                ", mgrLvl=" + mgrLvl + '\'' +
                ", salary=" + super.getSalary() +
                '}';
    }
}
