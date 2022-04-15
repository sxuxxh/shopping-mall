/*
 Project: shopping-mall
 Build: Maven
 Class: ShoppingCart - build list of products to buy
*/
package myproj.mall.shop;

import myproj.mall.manage.ManageStore;
import myproj.mall.store.Product;

import java.util.ArrayList;

public class ShoppingCart {
    // Fields
    private ArrayList<Product> items;

    // Constructors
    public ShoppingCart() {
    }

    public ShoppingCart(ArrayList<Product> items) {
        this.items = items;
    }

    // Setters
    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    // Getters
    public ArrayList<Product> getItems() {
        return items;
    }

    // ToString
    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                '}';
    }

    // Method: add a product to Cart
    public void addAProductToCart(String storeName, String productId) {
        this.items.add(ManageStore.getAProduct(storeName, productId));
    }

    // Method: remove a product from Cart
    public void removeAProductFromCart(String productId) {
        Product removeItem = new Product();
        for (Product item: this.items
             ) {
            if (item.getProductId().equals(productId)) {
                removeItem = item;
            }
        }
        this.items.remove(removeItem);
    }

    // Method: print items in Cart
    public void printCartItems() {
        if (this.items.size()>0) {
            System.out.println("\nYour shopping cart has:");
            for (Product product : this.items
            ) {
                if (!(product == null)) {
                    System.out.println(product);
                }
            }
        } else {
            System.out.println("\nYour shopping cart is empty.");
        }
    }
}
