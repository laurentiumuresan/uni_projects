package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
    private String username;

    private User user=new User();
    private Map<String, Integer> shoppingChart = new HashMap<>();

    private double totalCost = 0;

    public void setUsername(){
        user.setUsername("");
        this.username=user.getUsername();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ActiveSession() {
    }

    public ActiveSession(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setShoppingChart(Map<String, Integer> shoppingChart) {
        this.shoppingChart = shoppingChart;
    }

    public Map<String, Integer> getShoppingChart() {
        return shoppingChart;
    }

    public String getUsername() {
        return username;
    }

    public Map<String, Integer> getProducts() {
        return shoppingChart;
    }

    public void addToChart(Product product, int quality) {
        shoppingChart.put(product.getName(), quality);
        totalCost += product.getPrice() * quality;
    }

    @Override
    public String toString() {
        return "ActiveSession{" +
                "username='" + username + '\'' +
                ", shoppingChart=" + shoppingChart +
                ", totalCost=" + totalCost +
                '}';
    }
}
