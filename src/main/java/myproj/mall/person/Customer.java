/*
 Project: shopping-mall
 Build: Maven
 Class: Customer
*/
package myproj.mall.person;

public class Customer extends Person{
    // Fields
    private String uid;
    private boolean retrnCus;

    // Constructors
    public Customer() {
    }

    public Customer(String firstName, String lastName, String gender, String uid, boolean retrnCus) {
        super(firstName, lastName, gender);
        this.uid = uid;
        this.retrnCus = retrnCus;
    }

    // Setters
    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setRetrnCus(boolean retrnCus) {
        this.retrnCus = retrnCus;
    }

    // Getters
    public String getUid() {
        return uid;
    }

    public boolean isRetrnCus() {
        return retrnCus;
    }

    // ToString
    @Override
    public String toString() {
        return "Customer{" +
                "uid='" + uid + '\'' +
                ", retrnCus=" + retrnCus +
                '}';
    }
}
