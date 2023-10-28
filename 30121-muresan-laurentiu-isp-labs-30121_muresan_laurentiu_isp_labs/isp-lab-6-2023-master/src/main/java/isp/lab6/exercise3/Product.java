package isp.lab6.exercise3;

public class Product {

    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean equal(Product product){
        if(this.name==product.name && this.price==product.price){
            return true;
        }else {
            return false;
        }
    }

    public double getPriceByName(String name) {
        switch (name) {
            case "smart watch":
                return 1200;
            case "Samsung TV":
                return 5000;
            case "phone":
                return 4990;
            case "laptop":
                return 3120;
            case "PC":
                return 8920;
            case "fridge":
                return 3280;
            case "tablet":
                return 1500;
            case "mouse":
                return 300;
            case "keyboard":
                return 430;
            case "air pods":
                return 110;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
