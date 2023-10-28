package isp.lab3.exercise6;

import isp.lab3.exercise5.VendingMachine;

import java.util.Scanner;

public class SingletonVendingMachine {

    private static volatile SingletonVendingMachine instance;
    private int credit;
    private String[] Products = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    private int[] ids = {10, 20, 30, 40, 50, 60, 70, 80, 90};


    private SingletonVendingMachine() {
        this.credit = 0;
    }

    public SingletonVendingMachine(int credit) {
        this.credit = credit;
    }

    public static SingletonVendingMachine getInstance(int credit) {
        if (instance == null) {
            synchronized (SingletonVendingMachine.class) {
                if (instance == null) {
                    instance = new SingletonVendingMachine();
                }
            }
        }
        return instance;
    }


    public void displayProducts() {
        System.out.println("Products available: ");
        for (int i = 0; i < Products.length; i++) {
            System.out.println("Product: " + Products[i] + " id: " + ids[i]);
        }
        System.out.println("\n");
    }

    public void selectProduct(int id) {

        isp.lab3.exercise5.VendingMachine VM = new isp.lab3.exercise5.VendingMachine();
        int available = 0;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id) {
                System.out.println("The selected product is " + Products[i]);
                available++;
            }
        }
        if (available == 0) {
            System.out.println("Product unavailable! Please try again.");
        }

    }

    public void insertCoin(int value) {
        this.credit += value;
        System.out.println("You added " + value + "$ coins. Your credit is now " + this.credit + "$");
    }

    public void displayCredit() {
        System.out.println("The credit is " + this.credit + "$");
    }

    public void returnToUserMenu() {
        isp.lab3.exercise5.VendingMachine VM = new isp.lab3.exercise5.VendingMachine();
        Scanner returnkey = new Scanner(System.in);
        System.out.println("Press 0 to return.");
        int myreturnkey = returnkey.nextInt();
        if (myreturnkey == 0) {
            VM.userMeniu();
        } else {
            VM.returnToUserMenu();
        }
    }

    public String userMeniu() {
        isp.lab3.exercise5.VendingMachine VM = new isp.lab3.exercise5.VendingMachine();
        Scanner key = new Scanner(System.in);
        System.out.println("Hello! Please press a key to continue. \n" +
                "Press 1 to display products. \n" +
                "Press 2 to select product. \n" +
                "Press 3 to insert coin. \n" +
                "Press 4 display credit. \n");
        int mykey = key.nextInt();
        if (mykey == 1) {
            VM.displayProducts();
            VM.returnToUserMenu();
        }

        if (mykey == 2) {
            Scanner id = new Scanner(System.in);
            System.out.println("Please select the id.\n");
            int myid = id.nextInt();
            VM.selectProduct(myid);
            VM.returnToUserMenu();
        }
        if (mykey == 3) {
            Scanner coin = new Scanner(System.in);
            System.out.println("Please select the coin value.\n");
            int mycoin = coin.nextInt();
            VM.insertCoin(mycoin);
            VM.returnToUserMenu();
        }
        if (mykey == 4) {
            VM.displayCredit();
            VM.returnToUserMenu();
        } else {
            return "Please select a valid number! \n";
        }

        return null;
    }

    public static void main(String[] args) {
        isp.lab3.exercise5.VendingMachine MyVendingMachine = new isp.lab3.exercise5.VendingMachine();
        MyVendingMachine.userMeniu();
    }
}


