/*
 Project: shopping-mall
 Build: Maven
 Class: Product
*/
package myproj.mall.store;

public class Product {
    // Fields
    private String productId;
    private String name;
    private String size;
    private String color;
    private float price;

    // Constructors
    public Product() {
    }

    public Product(String productId, String name, String size, String color, float price) {
        this.productId = productId;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    // Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    // ToString
    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
