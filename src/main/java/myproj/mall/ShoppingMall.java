/*
 Project: shopping-mall
 Build: Maven
 Class: ShoppingMall - This is the Main class
*/
package myproj.mall;

import myproj.mall.manage.Login;
import myproj.mall.manage.ManageMall;
import myproj.mall.manage.ManageStore;
import myproj.mall.person.*;
import myproj.mall.shop.CheckOut;
import myproj.mall.shop.MallMap;
import myproj.mall.shop.Navigate;
import myproj.mall.shop.ShoppingCart;
import myproj.mall.store.Product;
import myproj.mall.store.ProductCatalog;
import myproj.mall.store.Store;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class ShoppingMall {
    public static Scanner scanner = new Scanner(System.in);
    public static Logger logger = null;
    private static Login myLogin = new Login();
    public static final Path passFilePath = Paths.get(System.getProperty("user.dir")+"\\src\\main\\resources\\passes.txt");
    private static final Path menuFilePath = Paths.get(System.getProperty("user.dir")+"\\src\\main\\resources\\menus.txt");
    public static final Path storeFilePath = Paths.get(System.getProperty("user.dir")+"\\src\\main\\resources\\stores.txt");
    public static final Path productFilePath = Paths.get(System.getProperty("user.dir")+"\\src\\main\\resources\\products-00%s.txt");
    private static Navigate navigate = new Navigate(new HashMap<String, String>());
    public static ManageMall manageMall = new ManageMall(new HashSet<Store>(), new HashMap<String, Object>());
    public static ManageStore manageStore = new ManageStore(new ArrayList<ProductCatalog>(),new ArrayList<Product>(),new HashMap<String, Object>());
    public static ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<Product>());
    public static CheckOut checkOut = new CheckOut("",0);
    private static final String menu1Key = "001-Main";
    private static final String menu1 = "Please select from the following menu:\n" +
            "Enter 1 for Customer Store Browsing and Shopping.\n" +
            "Enter 2 for Mall Store Placement and Mall Staffing.\n" +
            "Enter 3 for Store Product and Staff Management\n" +
            "Enter 4 to exit.\n" +
            "==> ";
    private static final String menu2Key = "002-MallMgrMain";
    private static final String menu2 = "Please select from the following menu:\n" +
            "Enter 1 to add a store.\n" +
            "Enter 2 to add a mall employee.\n" +
            "Enter 3 to update a mall employee.\n" +
            "Enter 4 to list mall employees.\n" +
            "Enter 5 to return to the mall manager menu.\n" +
            "Enter 6 to return to the mall main menu.\n" +
            "Enter 7 to exit.\n" +
            "==> ";
    private static final String menu3Key = "003-StoreMgrMain";
    private static final String menu3 = "Please select from the following menu:\n" +
            "Enter 1 to add a store manager.\n" +
            "Enter 2 to add a store staff.\n" +
            "Enter 3 to add a store product.\n" +
            "Enter 4 to return to the store manager menu\n" +
            "Enter 5 to return to the mall main menu\n" +
            "Enter 6 to exit.\n" +
            "==> ";
    private static final String menu4Key = "004-CustomerMain";
    private static final String menu4 = "Please select from the following menu:\n" +
            "Enter 1 to browse stores.\n" +
            "Enter 2 to shop in a store.\n" +
            "Enter 3 to print mall map.\n" +
            "Enter 4 to return to Customer Main Menu.\n" +
            "Enter 5 to return to Mall Main Menu.\n" +
            "Enter 6 to exit.\n" +
            "==> ";
    private static final String menuFileContent = menu1Key+"~"+menu1+"#"+
    menu2Key+"~"+menu2+"#"+menu3Key+"~"+menu3+"#"+menu4Key+"~"+menu4;

/*****************************************************************
    main method
******************************************************************/

    public static void main(String[] args) {
        var usrIn = "";
        var startMenuKey = "";
        var role = "";
        System.out.println("\n*********************************************");
        System.out.println("      Welcome to Skyline Shopping Mall!     ");
        System.out.println("*********************************************");
        menus();
        logger.info("System starting...");
        manageMall.loadStores();
        manageStore.loadProducts();

        // Login
        myLogin.getUidPwd();
        myLogin.authnAuthz();
        try {
            switch (myLogin.getRole()) {
                case "MM":
                    System.out.println("\nHello "+myLogin.getUid()+"! Welcome to Skyline Mall Management!");
                    processMenu("002-MallMgrMain");
                    break;
                case "MC":
                    System.out.println("\nHello "+myLogin.getUid()+"! Welcome to Skyline Mall Shopping!");
                    processMenu("004-CustomerMain");
                    break;
                case "SM":
                    System.out.println("\nHello "+myLogin.getUid()+"! Welcome to Skyline Store Management!");
                    processMenu("003-StoreMgrMain");
                    break;
                default: processMenu("001-Main");
            }
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
    public static void menus() {
        var menuKey = "";
        var allMenuStr = "";
        createFile(menuFilePath); // create menus.txt
        updateFile(menuFilePath, menuFileContent); // update menus.txt
        allMenuStr = readFile(menuFilePath);
        List<String> menuLst = Arrays.asList(allMenuStr.split("#"));
        List<String> menuPropLst = new ArrayList<>();
        for (String menu: menuLst
             ) {
            menuPropLst = Arrays.asList(menu.split("~"));
            navigate.buildMenu(menuPropLst.get(0), menuPropLst.get(1));
        }
    }

    //Method: create file
    public static void createFile(Path filePath) {
        try {
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method: update file
    public static void updateFile(Path filePath, String fileContent) {
        try {
            if (Files.exists(filePath)) {
                Files.writeString(filePath, fileContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method: read file
    public static String readFile(Path filePath) {
        var retStr = "";
        try {
            if (Files.exists(filePath)) {
                retStr = Files.readString(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            retStr = "";
        } finally {
            return retStr;
        }
    }

    //Method: delete menus.txt
    public static void deleteWordsFile(Path filePath) {
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method: get menu
    public static String getMenu(String menuKey) {
        var menu = "";
        for (String key: navigate.getMenus().keySet()) {
            if (key.equals(menuKey)) {
                menu = navigate.getMenus().get(key);
            }
        }
        return menu;
    }

    // Method: process menus
    public static void processMenu(String menuKey) {
        var usrIn = "";
        var usrInStore = "";
        var nextMenuKey = "";
        var cartItems = 0;
        var cartAction = "";
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
                    System.out.print("Goodbye "+myLogin.getUid()+"! See you again soon.\n");
                    logger.info(myLogin.getUid()+" exited mall.");
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
                        System.out.println("");
                        Navigate.browseProducts(usrInStore); // Display store products and get user selection
                        System.out.print("\nPlease enter the ProductID of the " +
                                "product to be added to your Shopping Cart, or enter \"DONE\" when ready to check out. ==> ");
                        usrIn = scanner.next();
                        shoppingCart.addAProductToCart(usrInStore, usrIn); // add item in Cart
                        logger.info("Customer: "+myLogin.getUid()+" added a product to shopping cart in store: "+usrInStore);
                        shoppingCart.printCartItems();
                        // remove item from cart
                        cartItems = shoppingCart.getItems().size();
                        while (!usrIn.equals("DONE")) {
                            if (cartItems > 0) {
                                System.out.print("\nIf you want to remove a product from your Shopping Cart, " +
                                        "please enter the productID, \nor enter \"C\" to continue shopping or checkout. ==> ");
                                cartAction = scanner.next();
                                if (!cartAction.equals("C")) {
                                    // remove a product from CART
                                    shoppingCart.removeAProductFromCart(cartAction);
                                    logger.info("Customer: "+myLogin.getUid()+" removed a product from shopping cart in store: "+usrInStore);
                                    System.out.println("\nItem has been removed from your shopping cart.");
                                    // print remaining items in cart
                                    shoppingCart.printCartItems();
                                } else {
                                    break;
                                }
                            }
                        }
                    } while (!usrIn.equals("DONE"));
                    System.out.println("\nThank you!! Here are the items you've selected for your purchase:");
                    shoppingCart.printCartItems();
                    System.out.println("\nYour total payment is: $"+checkOut.calculatePayment(shoppingCart));
                    System.out.println("Thank you "+myLogin.getUid()+ " for your business!\nPlease shop with "+usrInStore+" again.");
                    logger.info("Customer: "+myLogin.getUid()+" checked out from store: "+usrInStore);
                    shoppingCart.getItems().clear(); // reset shopping cart
                    System.out.print("\n");
                    processMenu("004-CustomerMain");
                    break;
                case "3":
                    //nextMenu = "003-StoreMgrMain";
                    MallMap.printMap();
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
                    System.out.print("Goodbye "+myLogin.getUid()+"! See you again soon.\n");
                    logger.info(myLogin.getUid()+" exited mall.");
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
                    System.out.print("Goodbye "+myLogin.getUid()+"! See you again soon.\n");
                    logger.info(myLogin.getUid()+" exited mall.");
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
                    System.out.print("Goodbye "+myLogin.getUid()+"! See you again soon.\n");
                    logger.info(myLogin.getUid()+" exited mall.");
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
