/*
 Project: shopping-mall
 Build: Maven
 Class: Navigate - to flow through the menu based shopping mall system
*/
package myproj.mall.shop;

import myproj.mall.ShoppingMall;
import myproj.mall.manage.ManageMall;
import myproj.mall.store.Product;
import myproj.mall.store.Store;

import java.util.HashMap;
import java.util.Map;

public class Navigate {
    // Fields
    private Map<String, String> menus;

    // Constructors
    public Navigate() {
    }

    public Navigate(Map<String, String> menus) {
        this.menus = menus;
    }

    // Setters
    public void setMenus(Map<String, String> menus) {
        this.menus = menus;
    }

    // Getters
    public Map<String, String> getMenus() {
        return menus;
    }

    // ToString
    @Override
    public String toString() {
        return "Navigate{" +
                "menus=" + menus +
                '}';
    }

    // Method: build menus
    public void buildMenu(String key, String menu) {
        this.menus.put(key, menu);
    }

    // Method: print list of stores for browsing
    public static void browseStores() {
        System.out.print("List of stores in the mall:\n");
        for (Store store : ShoppingMall.manageMall.getStores()
        ) {
            System.out.println("Store Name: "+store.getName()+" || Store Type: "+store.getType()+" || Store Location: "+store.getLotId());
        }
        ShoppingMall.logger.info("Customer browsed stores.");
    }

    // Method: print list of store products for browsing
    public static void browseProducts(String storeName) {
        System.out.print("Store: "+storeName+" has the following products for shopping:\n");
        for (Product product : ManageMall.getAStore(storeName).getProducts()
        ) {
            System.out.println("Product ID: "+product.getProductId()+" Product Name: "+product.getName()+
                    " Product Size: "+product.getSize()+" Product Price: $"+product.getPrice());
        }
        ShoppingMall.logger.info("Customer browsed store: "+storeName+" products.");
    }
}
