/*
 Project: shopping-mall
 Build: Maven
 Class: ManageStore - manage store employees and products
*/
package myproj.mall.manage;

import java.util.*;

import myproj.mall.ShoppingMall;
import myproj.mall.person.StoreMgr;
import myproj.mall.person.StoreStaff;
import myproj.mall.store.Product;
import myproj.mall.store.ProductCatalog;
import myproj.mall.store.Store;

public class ManageStore implements ManageEmployee {
    // Fields
    private List<ProductCatalog> catalogs;
    private List<Product> products;
    private Map<String, Object> storeEmpls;

    // Constructors
    public ManageStore() {
    }

    public ManageStore(List<ProductCatalog> catalogs, List<Product> products, Map<String, Object> storeEmpls) {
        this.catalogs = catalogs;
        this.products = products;
        this.storeEmpls = storeEmpls;
    }

    // Setters
    public void setCatalogs(List<ProductCatalog> catalogs) {
        this.catalogs = catalogs;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setStoreEmpls(Map<String, Object> storeEmpls) {
        this.storeEmpls = storeEmpls;
    }

    // Getters
    public List<ProductCatalog> getCatalogs() {
        return catalogs;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Map<String, Object> getStoreEmpls() {
        return storeEmpls;
    }

    // ToString
    @Override
    public String toString() {
        return "ManageStore{" +
                "catalogs=" + catalogs +
                ", products=" + products +
                ", storeEmpls=" + storeEmpls +
                '}';
    }

    // Method: add a product
    public static void addAProduct(String storeName) {
        Product product = new Product();
        System.out.print("Enter product id: ");
        product.setProductId(ShoppingMall.scanner.next());
        System.out.print("Enter product name: ");
        product.setName(ShoppingMall.scanner.next());
        System.out.print("Enter product size: ");
        product.setSize(ShoppingMall.scanner.next());
        System.out.print("Enter product color: ");
        product.setColor(ShoppingMall.scanner.next());
        System.out.print("Enter product price: ");
        product.setPrice(ShoppingMall.scanner.nextFloat());

        for (Store store: ShoppingMall.manageMall.getStores()) {
            ArrayList<Product> products = new ArrayList<>();
            if (store.getName().equals(storeName)) {
                if (store.getProducts() == null) {
                    products.add(product);
                    store.setProducts(products);
                } else {
                    store.getProducts().add(product);
                }
                System.out.println("You have added: " + product + " to store: "+store);
            }
        }
    }

    // Method: get a product
    public static Product getAProduct(String storeName, String productId) {
        for (Product product : ManageMall.getAStore(storeName).getProducts()
        ) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Method: delete a product
    public static void deleteAProduct(String storeName, String productId) {
        for (Product product : ManageMall.getAStore(storeName).getProducts()
        )
            if (product.getProductId().equals(productId)) {
                ManageMall.getAStore(storeName).getProducts().remove(product);
            }
    }

    @Override
    public void addAEmployee() {

    }

    @Override
    public void listAllEmployees() {
        System.out.println("test");
    }

    @Override
    public Object getAEmployee(String emplId) {
        return null;
    }

    @Override
    public void updateAEmployee() {
        System.out.println("test");
    }

    @Override
    public void deleteAEmployee() {

    }
}
