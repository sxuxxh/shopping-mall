/*
 Project: shopping-mall
 Build: Maven
 Class: Store
*/
package myproj.mall.store;

import myproj.mall.person.StoreMgr;
import myproj.mall.person.StoreStaff;

import java.util.ArrayList;

public class Store {
    // Fields
    private String id;
    private String name;
    private String type;
    private String lotId;
    private ArrayList<StoreMgr> mgrs;
    private ArrayList<StoreStaff> staffs;
    private ArrayList<ProductCatalog> catalogs;
    private ArrayList<Product> products;

    // Constructors
    public Store() {
    }

    public Store(String id, String name, String type, String lotId, ArrayList<StoreMgr> mgrs, ArrayList<StoreStaff> staffs, ArrayList<ProductCatalog> catalogs, ArrayList<Product> products) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lotId = lotId;
        this.mgrs = mgrs;
        this.staffs = staffs;
        this.catalogs = catalogs;
        this.products = products;
    }

    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public void setMgrs(ArrayList<StoreMgr> mgrs) {
        this.mgrs = mgrs;
    }

    public void setStaffs(ArrayList<StoreStaff> staffs) {
        this.staffs = staffs;
    }

    public void setCatalogs(ArrayList<ProductCatalog> catalogs) {
        this.catalogs = catalogs;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLotId() {
        return lotId;
    }

    public ArrayList<StoreMgr> getMgrs() {
        return mgrs;
    }

    public ArrayList<StoreStaff> getStaffs() {
        return staffs;
    }

    public ArrayList<ProductCatalog> getCatalogs() {
        return catalogs;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    // ToString
    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", lotId='" + lotId + '\'' +
                ", mgrs=" + mgrs +
                ", staffs=" + staffs +
                ", catalogs=" + catalogs +
                ", products=" + products +
                '}';
    }
}
