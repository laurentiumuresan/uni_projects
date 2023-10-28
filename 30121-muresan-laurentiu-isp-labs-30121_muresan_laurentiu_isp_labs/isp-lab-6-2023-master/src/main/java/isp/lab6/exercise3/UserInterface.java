package isp.lab6.exercise3;

import java.util.Scanner;

public class UserInterface {
    private LoginSystem loginSystem = new LoginSystem();
    private OnlineStore store = new OnlineStore();
    private ActiveSession session = new ActiveSession();

    private CheckOutPage checkOutPage= new CheckOutPage();

    public UserInterface(LoginSystem loginSystem, OnlineStore store) {
        this.loginSystem = loginSystem;
        this.store = store;
    }

    public UserInterface() {
    }

    public OnlineStore getStore() {
        return store;
    }

    public LoginSystem getLoginSystem() {
        return loginSystem;
    }

    public void loadInterface(){
        registrationProcess();
        shoppingExperience();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        User user = new User(username, password);
        loginSystem.logIn(user.getUsername(), user.getPassword());
        if (loginSystem.logIn(user.getUsername(), user.getPassword()) == false) {
            System.out.println("You need to register firs!");
            register();
        }
    }

    private void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select username");
        String username1 = scanner.nextLine();
        System.out.println("Select password:");
        String password1 = scanner.nextLine();
        User user1 = new User(username1, password1);
        loginSystem.register(user1.getUsername(), user1.getPassword());
    }

    public void registrationProcess() {
        store.addProducts();
        System.out.println("Welcome to our Online Shop!");
        System.out.println("Please login or register to continue.");
        System.out.println("Type 'login' to login or 'register' to register.");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        switch (option) {
            case "login":
                login();
                break;
            case "register":
                register();
                break;
            default:
                System.out.println("Please select a valid option!");
                break;
        }
    }

    public void shoppingExperience(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a value in order to do something: \n" +
                "1 for displaying the products \n" +
                "2 for adding product to chart \n" +
                "3 for check out \n" +
                "4 for logout");
        String nextOption = scanner.nextLine();
        switch (nextOption) {
            case "1":
                store.getProductsList();
                shoppingExperience();
                break;
            case "2":
                System.out.println("Enter product name:");
                String productName = scanner.nextLine();
                System.out.println("Enter quantity: ");
                int quantity= scanner.nextInt();
                Product product = new Product(productName);
                product.setPrice(product.getPriceByName(productName));
                session.addToChart(product,quantity);
                shoppingExperience();
                break;
            case "3":
                checkOutPage.orderReview();
                checkOutPage.shippingInformation();
                System.out.println("Enter your budget: ");
                double budget=scanner.nextDouble();
                checkOutPage.payProducts(budget);
                checkOutPage.placeOrder();
                shoppingExperience();
                break;
            case"4":
                System.out.println("Enter your username");
                String username= scanner.nextLine();;
                loginSystem.logout(username);
                registrationProcess();
                break;
            default:
                System.out.println("Please select a valid value!");
                shoppingExperience();
                break;

        }

    }


}
