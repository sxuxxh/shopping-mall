/*
 Project: shopping-mall
 Build: Maven
 Class: Manage - managing stores and mall employees
*/
package myproj.mall.manage;

import java.util.*;

import myproj.mall.ShoppingMall;
import myproj.mall.person.MallJanitor;
import myproj.mall.person.MallMgr;
import myproj.mall.person.MallSecurity;
import myproj.mall.store.Store;

public class ManageMall implements IManageEmployee {
    // Fields
    private Set<Store> stores;
    private Map<String, Object> mallEmpls;

    // Constructors
    public ManageMall() {
    }

    public ManageMall(Set<Store> stores, Map<String, Object> mallEmpls) {
        this.stores = stores;
        this.mallEmpls = mallEmpls;
    }

    // Setters
    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public void setMallEmpls(Map<String, Object> mallEmpls) {
        this.mallEmpls = mallEmpls;
    }

    // Getters
    public Set<Store> getStores() {
        return stores;
    }

    public Map<String, Object> getMallEmpls() {
        return mallEmpls;
    }

    // ToString
    @Override
    public String toString() {
        return "ManageMall{" +
                "stores=" + stores +
                ", mallEmpls=" + mallEmpls +
                '}';
    }

    // Method: add a store manually
    public static void addAStore() {
        Store store = new Store();
        System.out.print("Enter store id: ");
        store.setId(ShoppingMall.scanner.next());
        ShoppingMall.scanner.nextLine(); // consume rest of the line from previous input
        System.out.print("Enter store name: ");
        store.setName(ShoppingMall.scanner.nextLine());
        System.out.print("Enter store type: ");
        store.setType(ShoppingMall.scanner.next());
        System.out.print("Enter store lotId: ");
        store.setLotId(ShoppingMall.scanner.next());
        ShoppingMall.manageMall.stores.add(store);
        System.out.println("You have added: " + store + " in the mall.");
    }

    // Method: init to load stores from file
    public void loadStores() {
        String storesContent = ShoppingMall.readFile(ShoppingMall.storeFilePath);
        List<String> storeLst = Arrays.asList(storesContent.split("#"));
        List<String> storePropLst = new ArrayList<>();
        for (String storeStr: storeLst
        ) {
            Store store = new Store();
            storePropLst = Arrays.asList(storeStr.split(","));
            store.setId(storePropLst.get(0));
            store.setName(storePropLst.get(1));
            store.setType(storePropLst.get(2));
            store.setLotId(storePropLst.get(3));
            ShoppingMall.manageMall.stores.add(store);
        }
    }

    // Method: get a store
    public static Store getAStore(String storeName) {
        for (Store store : Collections.unmodifiableSet(ShoppingMall.manageMall.getStores())
        ) {
            if (store.getName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }

    @Override
    public void addAEmployee() {
        String emplType = "";
        String emplId = "";
        System.out.print("Enter Employee Type (Manager-MM; Security-MS; Janitor-MJ): ");
        emplType = ShoppingMall.scanner.next();
        System.out.print("Enter Employee Id: ");
        emplId = ShoppingMall.scanner.next();
        if (emplType.equals("MM")) {
            MallMgr mallMgr = new MallMgr();
            System.out.print("Enter First Name: ");
            mallMgr.setFirstName(ShoppingMall.scanner.next());
            System.out.print("Enter Last Name: ");
            mallMgr.setLastName(ShoppingMall.scanner.next());
            System.out.print("Enter Gender: ");
            mallMgr.setGender(ShoppingMall.scanner.next());
            System.out.print("Enter User Id: ");
            mallMgr.setUid(ShoppingMall.scanner.next());
            mallMgr.setEmployeeId(emplId);
            mallMgr.setEmployeeType(emplType);
            System.out.print("Enter Salary: ");
            mallMgr.setSalary(ShoppingMall.scanner.nextFloat());
            System.out.print("Enter Manager Level: ");
            mallMgr.setMgrLvl(ShoppingMall.scanner.nextInt());
            ShoppingMall.scanner.nextLine(); // consume rest of the line from previous input
            System.out.print("Enter Manager Title: ");
            mallMgr.setMgrTitle(ShoppingMall.scanner.nextLine());
            System.out.print("Enter Mall Id: ");
            mallMgr.setMallId(ShoppingMall.scanner.next());
            ShoppingMall.manageMall.mallEmpls.put(emplId,mallMgr);
            System.out.println("You have added mall employee: " + mallMgr);
        }
        if (emplType.equals("MS")) {
            MallSecurity mallSecurity = new MallSecurity();
            System.out.print("Enter First Name: ");
            mallSecurity.setFirstName(ShoppingMall.scanner.next());
            System.out.print("Enter Last Name: ");
            mallSecurity.setLastName(ShoppingMall.scanner.next());
            System.out.print("Enter Gender: ");
            mallSecurity.setGender(ShoppingMall.scanner.next());
            System.out.print("Enter User Id: ");
            mallSecurity.setUid(ShoppingMall.scanner.next());
            mallSecurity.setEmployeeId(emplId);
            mallSecurity.setEmployeeType(emplType);
            System.out.print("Enter Salary: ");
            mallSecurity.setSalary(ShoppingMall.scanner.nextFloat());
            System.out.print("Enter Security Level: ");
            mallSecurity.setSecLvl(ShoppingMall.scanner.nextInt());
            ShoppingMall.scanner.nextLine(); // consume rest of the line from previous input
            System.out.print("Enter Manager Title: ");
            mallSecurity.setSecTitle(ShoppingMall.scanner.nextLine());
            System.out.print("Enter Mall Id: ");
            mallSecurity.setMallId(ShoppingMall.scanner.next());
            ShoppingMall.manageMall.mallEmpls.put(emplId,mallSecurity);
            System.out.println("You have added mall employee: " + mallSecurity);
        }
    }

    @Override
    public void listAllEmployees() {
        for (String key: ShoppingMall.manageMall.getMallEmpls().keySet()
             ) {
            System.out.println(ShoppingMall.manageMall.getMallEmpls().get(key));
        }
    }

    @Override
    public Object getAEmployee(String emplId) {
        for (String key: ShoppingMall.manageMall.getMallEmpls().keySet()
             ) {
            if (key.equals(emplId)) {
                return ShoppingMall.manageMall.getMallEmpls().get(emplId);
            }
        }
        return null;
    }

    @Override
    public void updateAEmployee() {
        Object empl = new Object();
        System.out.print("Enter employee id: ");
        empl = getAEmployee(ShoppingMall.scanner.next());
        if (empl instanceof MallMgr) {
            System.out.print("Enter new manager level: ");
            ((MallMgr) empl).setMgrLvl(ShoppingMall.scanner.nextInt());
            ShoppingMall.scanner.nextLine(); // consume rest of the line
            System.out.print("Enter new manager title: ");
            ((MallMgr) empl).setMgrTitle(ShoppingMall.scanner.nextLine());
            System.out.print("Enter new salary: ");
            ((MallMgr) empl).setSalary(ShoppingMall.scanner.nextFloat());
        }
        if (empl instanceof MallSecurity) {
            System.out.print("Enter new security level: ");
            ((MallSecurity) empl).setSecLvl(ShoppingMall.scanner.nextInt());
            ShoppingMall.scanner.nextLine(); // consume rest of the line
            System.out.print("Enter new security title: ");
            ((MallSecurity) empl).setSecTitle(ShoppingMall.scanner.nextLine());
            System.out.print("Enter new salary: ");
            ((MallSecurity) empl).setSalary(ShoppingMall.scanner.nextFloat());
        }
        if (empl instanceof MallJanitor) {
            System.out.print("Enter new janitor level: ");
            ((MallJanitor) empl).setJanLvl(ShoppingMall.scanner.nextInt());
            ShoppingMall.scanner.nextLine(); // consume rest of the line
            System.out.print("Enter new janitor title: ");
            ((MallJanitor) empl).setJanTitle(ShoppingMall.scanner.nextLine());
            System.out.print("Enter new salary: ");
            ((MallJanitor) empl).setSalary(ShoppingMall.scanner.nextFloat());
        }
    }

    @Override
    public void deleteAEmployee() {

    }
}
