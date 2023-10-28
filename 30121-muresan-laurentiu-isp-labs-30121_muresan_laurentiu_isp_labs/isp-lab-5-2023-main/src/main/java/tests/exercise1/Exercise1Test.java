package tests.exercise1;

import isp.lab4.exercise1.Product;

public class Exercise1Test {
    public static void main(String[] args) {
        Product product=new Product("12e432","aaaa", 5362);
        System.out.println(product.getProductCategory());
        System.out.println(product.getName());
    }
}
