/*
 Project: shopping-mall
 Build: Maven
 Class: CheckOut
*/
package myproj.mall.shop;

import myproj.mall.store.Product;

public class CheckOut {
    // Fields
    private String payMethod;
    private float payTotal;

    // Constructors
    public CheckOut() {
    }

    public CheckOut(String payMethod, float payTotal) {
        this.payMethod = payMethod;
        this.payTotal = payTotal;
    }

    // Setters
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public void setPayTotal(float payTotal) {
        this.payTotal = payTotal;
    }

    // Getters
    public String getPayMethod() {
        return payMethod;
    }

    public float getPayTotal() {
        return payTotal;
    }

    // ToString
    @Override
    public String toString() {
        return "CheckOut{" +
                "payMethod='" + payMethod + '\'' +
                ", payTotal=" + payTotal +
                '}';
    }

    // Method: calculate total payment
    public float calculatePayment(ShoppingCart shoppingCart) {
        float totalPayment = 0;
        for (Product product: shoppingCart.getItems()
        ) {
            if (!(product == null)) {
                totalPayment += product.getPrice();
            }
        }
        return totalPayment;
    }
}
