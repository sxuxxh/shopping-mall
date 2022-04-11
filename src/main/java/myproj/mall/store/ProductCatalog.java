/*
 Project: shopping-mall
 Build: Maven
 Class: ProductCatalog
*/
package myproj.mall.store;

import java.util.ArrayList;

public class ProductCatalog {
    // Fields
    private String what;
    private String style;
    private String brand;
    private ArrayList<Product> products;

    // Constructors
    public ProductCatalog() {
    }

    public ProductCatalog(String what, String style, String brand, ArrayList<Product> products) {
        this.what = what;
        this.style = style;
        this.brand = brand;
        this.products = products;
    }

    // Setters
    public void setWhat(String what) {
        this.what = what;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    // Getters
    public String getWhat() {
        return what;
    }

    public String getStyle() {
        return style;
    }

    public String getBrand() {
        return brand;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    // ToString
    @Override
    public String toString() {
        return "ProductCatalog{" +
                "what='" + what + '\'' +
                ", style='" + style + '\'' +
                ", brand='" + brand + '\'' +
                ", products=" + products +
                '}';
    }
}
