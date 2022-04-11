/*
 Project: shopping-mall
 Build: Maven
 Class: ShoppingMall - This is the Main class
*/
package myproj.mall;

import myproj.mall.manage.ManageMall;
import myproj.mall.manage.ManageStore;
import myproj.mall.person.*;
import myproj.mall.shop.CheckOut;
import myproj.mall.shop.Navigate;
import myproj.mall.shop.ShoppingCart;
import myproj.mall.store.Product;
import myproj.mall.store.ProductCatalog;
import myproj.mall.store.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ShoppingMall {
    public static Scanner scanner = new Scanner(System.in);
    private static Navigate navigate = new Navigate(new HashMap<String, String>());
    public static ManageMall manageMall = new ManageMall(new HashSet<Store>(), new HashMap<String, Object>());
    public static ManageStore manageStore = new ManageStore(new ArrayList<ProductCatalog>(),new ArrayList<Product>(),new HashMap<String, Object>());
    public static ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<Product>());
    public static CheckOut checkOut = new CheckOut("",0);

/*****************************************************************
    main method
******************************************************************/

    public static void main(String[] args) {
        String usrIn = "";
        String startMenuKey = "";
        System.out.println("Welcome to Skyline Shopping Mall!\n");
        buildMenus();

        // Start with main menu, the rest drive themselves
        startMenuKey = "001-Main";
        try {
            processMenu(startMenuKey);
        } catch (Exception e) {
            System.out.println("Something was wrong. It's likely that " +
                    "store and/or products are not ready for service." +
                    " Let's start over and set them up first via options " +
                    "2 and 3 in the mall main menu.\n");
            processMenu("001-Main");
        }
    }

/*****************************************************************
     other methods
******************************************************************/

    // Method: build navigation menus
    public static void buildMenus() {
        String menu1Key = "001-Main";
        String menu1 = "Please select from the following menu:\n" +
                "Enter 1 for Customer Store Browsing and Shopping.\n" +
                "Enter 2 for Mall Store Placement and Mall Staffing.\n" +
                "Enter 3 for Store Product and Staff Management\n" +
                "Enter 4 to exit.\n" +
                "==> ";
        String menu2Key = "002-MallMgrMain";
        String menu2 = "Please select from the following menu:\n" +
                "Enter 1 to add a store.\n" +
                "Enter 2 to add a mall employee.\n" +
                "Enter 3 to update a mall employee.\n" +
                "Enter 4 to list mall employees.\n" +
                "Enter 5 to return to the mall manager menu.\n" +
                "Enter 6 to return to the mall main menu.\n" +
                "Enter 7 to exit.\n" +
                "==> ";
        String menu3Key = "003-StoreMgrMain";
        String menu3 = "Please select from the following menu:\n" +
                "Enter 1 to add a store manager.\n" +
                "Enter 2 to add a store staff.\n" +
                "Enter 3 to add a store product.\n" +
                "Enter 4 to return to the store manager menu\n" +
                "Enter 5 to return to the mall main menu\n" +
                "Enter 6 to exit.\n" +
                "==> ";
        String menu4Key = "004-CustomerMain";
        String menu4 = "Please select from the following menu:\n" +
                "Enter 1 to browse stores.\n" +
                "Enter 2 to shop in a store.\n" +
                "Enter 3 to print mall map.\n" +
                "Enter 4 to return to Customer Main Menu.\n" +
                "Enter 5 to return to Mall Main Menu.\n" +
                "Enter 6 to exit.\n" +
                "==> ";
        navigate.buildMenu(menu1Key, menu1);
        navigate.buildMenu(menu2Key, menu2);
        navigate.buildMenu(menu3Key, menu3);
        navigate.buildMenu(menu4Key, menu4);
    }

    // Method: get menu
    public static String getMenu(String menuKey) {
        String menu = "";
        for (String key: navigate.getMenus().keySet()) {
            if (key.equals(menuKey)) {
                menu = navigate.getMenus().get(key);
            }
        }
        return menu;
    }

    // Method: process menus
    public static void processMenu(String menuKey) {
        String usrIn = "";
        String usrInStore = "";
        String nextMenuKey = "";
        int cartItems = 0;
        String cartAction = "";
        System.out.print(getMenu(menuKey));
        usrIn = scanner.next();
        if (menuKey.equals("001-Main")) {
            switch (usrIn) {
                case "1":
                    System.out.print("\n");
                    processMenu("004-CustomerMain");
                    break;
                case "2":
                    System.out.print("\n");
                    processMenu("002-MallMgrMain");
                    break;
                case "3":
                    System.out.print("\n");
                    processMenu("003-StoreMgrMain");
                    break;
                case "4":
                    System.out.print("\n");
                    System.exit(0);
                default:
                    System.out.print("\n");
                    processMenu("001-Main");
                    break;
            }
        }
        if (menuKey.equals("004-CustomerMain")) {
            switch (usrIn) {
                case "1":
                    System.out.print("\n");
                    Navigate.browseStores();
                    System.out.print("\n");
                    processMenu("004-CustomerMain");
                    break;
                case "2":
                    System.out.print("\n");
                    System.out.println("To shop in a store, please enter the name of a store from the store list below:");
                    Navigate.browseStores();
                    System.out.print("==> "); // Enter a store name
                    usrInStore = scanner.next();
                    do {
                        Navigate.browseProducts(usrInStore); // Display store products and get user selection
                        System.out.print("Please enter the ProductID of the " +
                                "product to be added to your Shopping Cart, or enter \"DONE\" when ready to check out. ==> ");
                        usrIn = scanner.next();
                        System.out.println("\n");
                        shoppingCart.addAProductToCart(usrInStore, usrIn); // add item in Cart
                        shoppingCart.printCartItems();
                        // remove item from cart
                        cartItems = shoppingCart.getItems().size();
                        while (!usrIn.equals("DONE")) {
                            if (cartItems > 0) {
                                System.out.print("If you want to remove a product from your Shopping Cart, " +
                                        "please enter the productID, \nor enter \"KEEP\" to continue shopping or checkout. ==> ");
                                cartAction = scanner.next();
                                if (!cartAction.equals("KEEP")) {
                                    // remove a product from CART
                                    shoppingCart.removeAProductFromCart(cartAction);
                                    System.out.println("Item has been removed from your shopping cart.");
                                    // print remaining items in cart
                                    shoppingCart.printCartItems();
                                } else {
                                    break;
                                }
                            }
                        }
                    } while (!usrIn.equals("DONE"));
                    System.out.println("Thank you!! Here is the items you've selected for your purchase:");
                    System.out.println(shoppingCart);
                    System.out.println("Your total payment is: $"+checkOut.calculatePayment(shoppingCart));
                    System.out.println("Thank you so much for your business!");
                    shoppingCart.getItems().clear(); // reset shopping cart
                    System.out.print("\n");
                    processMenu("004-CustomerMain");
                    break;
                case "3":
                    //nextMenu = "003-StoreMgrMain";
                    System.out.print("Printing mall map...");
                    System.out.print("\n");
                    processMenu("004-CustomerMain");
                    break;
                case "4":
                    System.out.print("\n");
                    processMenu("004-CustomerMain");
                    break;
                case "5":
                    System.out.print("\n");
                    processMenu("001-Main");
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.print("\n");
                    nextMenuKey = "004-CustomerMain";
                    System.out.print(getMenu(nextMenuKey));
                    break;
            }
        }
        if (menuKey.equals("002-MallMgrMain")) {
            switch (usrIn) {
                case "1":
                    System.out.println("To add a store...");
                    ManageMall.addAStore();
                    System.out.println("\n");
                    processMenu("002-MallMgrMain");
                    break;
                case "2":
                    System.out.print("To add a mall employee...");
                    try {
                        manageMall.addAEmployee();
                    } catch (Exception e) {
                        System.out.print("Something wrong while adding mall manager. Let's try again.");
                        scanner.reset();
                        manageMall.addAEmployee();
                    }
                    System.out.println("\n");
                    processMenu("002-MallMgrMain");
                    break;
                case "3":
                    System.out.print("To update a mall employee...");
                    System.out.println("\n");
                    manageMall.updateAEmployee();
                    processMenu("002-MallMgrMain");
                    break;
                case "4":
                    System.out.print("To list mall employees...");
                    System.out.println("\n");
                    manageMall.listAllEmployees();
                    processMenu("002-MallMgrMain");
                    break;
                case "5":
                    System.out.println("\n");
                    processMenu("002-MallMgrMain");
                case "6":
                    System.out.println("\n");
                    processMenu("001-Main");
                case "7":
                    System.exit(0);
                default:
                    System.out.print("\n");
                    nextMenuKey = "002-MallMgrMain";
                    //System.out.println(getMenu(nextMenu));
                    break;
            }
        }
        if (menuKey.equals("003-StoreMgrMain")) {
            switch (usrIn) {
                case "1":
                    System.out.print("Adding a store manager... Done!\n");
                    processMenu("003-StoreMgrMain");
                    break;
                case "2":
                    System.out.print("Adding a store staff...\n");
                    processMenu("003-StoreMgrMain");
                    break;
                case "3":
                    System.out.print("\n");
                    System.out.println("Add a product to one of the following stores, please enter name of the store.\n");
                    Navigate.browseStores();
                    System.out.print("==> ");
                    try {
                        ManageStore.addAProduct(scanner.next());
                    } catch (Exception e) {
                        System.out.print("Something wrong while adding product. Let's try again.");
                        scanner.reset();
                        ManageStore.addAProduct(scanner.next());
                    }
                    System.out.println("\n");
                    processMenu("003-StoreMgrMain");
                    break;
                case "4":
                    System.out.println("\n");
                    processMenu("003-StoreMgrMain");
                    break;
                case "5":
                    System.out.println("\n");
                    processMenu("001-Main");
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.print("\n");
                    nextMenuKey = "003-StoreMgrMain";
                    //System.out.println(getMenu(nextMenu));
                    break;
            }
        }
    }
}
