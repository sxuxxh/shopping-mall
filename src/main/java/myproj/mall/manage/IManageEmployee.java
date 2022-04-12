/*
 Project: shopping-mall
 Build: Maven
 Interface: IManageEmployee - methods for managing employees
*/
package myproj.mall.manage;

public interface IManageEmployee {
    void addAEmployee();
    void listAllEmployees();
    Object getAEmployee(String emplId);
    void updateAEmployee();
    void deleteAEmployee();
}
