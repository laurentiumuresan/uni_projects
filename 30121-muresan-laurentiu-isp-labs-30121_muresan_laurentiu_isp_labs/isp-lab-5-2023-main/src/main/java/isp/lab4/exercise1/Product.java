package isp.lab4.exercise1;

import java.util.Random;

public class Product {
    private String productId;
    private String name;
    private double price;
    private ProductCategory productCategory;
    private Customer costumer;

    public Product() {
    }

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
