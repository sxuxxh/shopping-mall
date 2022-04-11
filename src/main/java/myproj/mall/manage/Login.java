/*
 Project: shopping-mall
 Build: Maven
 Class: Login - authenticate and authorize people to use the mall application
*/
package myproj.mall.manage;

public class Login {
    // Fields
    private String uid;
    private String pwd;

    // Constructors
    public Login() {
    }

    public Login(String uid, String pwd) {
        this.uid = uid;
        this.pwd = pwd;
    }

    // Setters
    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    // Getters
    public String getUid() {
        return uid;
    }

    public String getPwd() {
        return pwd;
    }
}
