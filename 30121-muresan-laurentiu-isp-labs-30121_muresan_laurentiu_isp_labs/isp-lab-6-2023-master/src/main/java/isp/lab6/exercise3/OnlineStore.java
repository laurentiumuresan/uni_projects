package isp.lab6.exercise3;

import java.util.*;

public class OnlineStore {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Map<String, ActiveSession> sessions = new HashMap<>();

    public OnlineStore() {
    }

    public void addProducts() {
        products.add(new Product("smart watch",1200));
        products.add(new Product("Samsung TV",5000));
        products.add(new Product("phone",4990));
        products.add(new Product("laptop",3120));
        products.add(new Product("PC",8920));
        products.add(new Product("fridge",3280));
        products.add(new Product("tablet",1500));
        products.add(new Product("mouse",300));
        products.add(new Product("keyboard",430));
        products.add(new Product("air pods",110));
    }

    public OnlineStore(List<Product> product) {
        this.products = product;
    }

    public OnlineStore(List<Product> product, Map<String, ActiveSession> sessions) {
        this.products = product;
        this.sessions = sessions;
    }

    public void setProduct(List<Product> product) {
        this.products = product;
    }

    public Map<String, ActiveSession> getSessions() {
        return sessions;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void getProductsList(){
        for(Product product:products){
            System.out.println(product.toString());
        }
    }

    public List<Product> getProductsSorted() {
        products.sort(Comparator.comparing(Product::getName));
        products.sort(Comparator.comparing(Product::getPrice));
        return products;
    }

    protected void addSession(String username) {
        ActiveSession activeSession = new ActiveSession(username);
        sessions.put(username, activeSession);
    }

    protected void removeSession(String username) {
        sessions.remove(username);
    }

    public void addToCart(String username, Product product, int quantity) {
        ActiveSession activeSession = new ActiveSession(username);
        activeSession.addToChart(product, quantity);
    }

    public String checkOut(String username) {
        return "You will be directed to the check out page!";
    }
}