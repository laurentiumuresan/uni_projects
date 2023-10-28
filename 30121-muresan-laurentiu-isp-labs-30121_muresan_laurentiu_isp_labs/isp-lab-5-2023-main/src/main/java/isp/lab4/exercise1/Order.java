package isp.lab4.exercise1;

import java.time.LocalDateTime;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice = 0;
    private Product[] products = new Product[10];

    public String getOrderId() {
        return orderId;
    }

    public void calculateTotalPrice() {
        for (Product product : products) {
            this.totalPrice += product.getPrice();
        }
        System.out.println("The total price is equal to " + totalPrice);
    }
}


