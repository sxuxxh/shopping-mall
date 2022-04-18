/*
 Project: shopping-mall
 Build: Maven
 Class: Login - authenticate and authorize people to use the mall application
*/
package myproj.mall.manage;

import myproj.mall.ShoppingMall;

import java.io.Console;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Login {
    // Fields
    private String uid;
    private String pwd;
    private String role;

    // Constructors
    public Login() {
        ShoppingMall.logger = Logger.getLogger(Login.class.getName());
    }

    public Login(String uid, String pwd, String role) {
        this.uid = uid;
        this.pwd = pwd;
        this.role = role;
    }

    // Setters
    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setRole(String role) { this.role = role;}

    // Getters
    public String getUid() {
        return uid;
    }

    public String getPwd() {
        return pwd;
    }

    public String getRole() {
        return role;
    }

    // Method: get uid/pwd
    public void getUidPwd() {
        Console console = System.console();
        if (!(console == null)) {
            ShoppingMall.logger.info("Getting user name...");
            this.setUid(console.readLine("Please enter your user name: "));
            ShoppingMall.logger.info("Getting user password...");
            this.setPwd(new String(console.readPassword("Please enter your password:  ")));
        } else {
            ShoppingMall.logger.info("Getting user name...");
            System.out.print("Please enter your user name: ");
            this.setUid(ShoppingMall.scanner.next());
            ShoppingMall.logger.info("Getting user name...");
            System.out.print("Please enter your password: ");
            this.setPwd(ShoppingMall.scanner.next());
        }
    }

    // Method: authenticate and authorize login, return role
    public void authnAuthz() {
        String[] loginArr = new String[3];
        String role = "";
        String allUsrContent = ShoppingMall.readFile(ShoppingMall.passFilePath);
        List<String> usrLst = Arrays.asList(allUsrContent.split("#"));
        for (String usr: usrLst
        ) {
            loginArr = usr.split(",");
            if (this.getUid().equals(loginArr[0]) && String.valueOf(this.getPwd().hashCode()).equals(loginArr[1])) {
                this.setRole(loginArr[2]);
                ShoppingMall.logger.info("User: "+this.getUid()+" is authorized with user role: "+this.getRole());
                break;
            }
        }
        if (this.getRole()==null || this.getRole().equals("")) {
            ShoppingMall.logger.info("Invalid user login.");
            System.out.println("\nInvalid Login. Possible causes:\n   " +
                    "1. You may have entered invalid userid/password.\n   " +
                    "2. You have not registered an account.\n" +
                    "Please do the needful.\nGoodbye!");
            System.exit(0);
        }
    }
}
