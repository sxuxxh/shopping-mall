/*
 Project: shopping-mall
 Build: Maven
 Class: ManageStore - manage store employees and products
*/
package myproj.mall.manage;

import java.nio.file.Path;
import java.util.*;

import myproj.mall.ShoppingMall;
import myproj.mall.person.StoreMgr;
import myproj.mall.person.StoreStaff;
import myproj.mall.store.Product;
import myproj.mall.store.ProductCatalog;
import myproj.mall.store.Store;

public class ManageStore implements IManageEmployee {
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

    // Method: manually add a product
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

    // Method: init to load products into stores
    public void loadProducts() {
        String productsContent = "";
        List<String> productLst = new ArrayList<>();
        List<String> productPropLst = new ArrayList<>();
        ShoppingMall.logger.info("System initializing with loading store products...");
        for (int i=1; i<=4; i++) { // loop through products-storeId.txt files
            productsContent = ShoppingMall.readFile(Path.of(String.format(String.valueOf(ShoppingMall.productFilePath),i)));
            productLst = Arrays.asList(productsContent.split("#"));
            for (String productStr: productLst
            ) {
                Product product = new Product();
                productPropLst = Arrays.asList(productStr.split(","));
                product.setProductId(productPropLst.get(0));
                product.setName(productPropLst.get(1));
                product.setSize(productPropLst.get(2));
                product.setColor(productPropLst.get(3));
                product.setPrice(Float.parseFloat(productPropLst.get(4)));
                for (Store store: ShoppingMall.manageMall.getStores()) {
                    ArrayList<Product> products = new ArrayList<>();
                    if (Integer.parseInt(store.getId())==i) {
                        if (store.getProducts() == null) {
                            products.add(product);
                            store.setProducts(products);
                            ShoppingMall.logger.info("Loaded product: "+product.getProductId()+" -- "+product.getName()+" in store: "+store.getName());
                        } else {
                            store.getProducts().add(product);
                            ShoppingMall.logger.info("Loaded product: "+product.getProductId()+" -- "+product.getName()+" in store: "+store.getName());
                        }
                    }
                }
            }
        }
        ShoppingMall.logger.info("System initializing with all store products loaded.");
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
