package aut.isp.lab4.exercise5;

public class FishFeeder {
    private String model, manufacturer;
    private int meals;

    public int getMeals() {
        return meals;
    }

    public void setMeals(int meals) {
        this.meals = meals;
    }

    public void feed() {
        this.meals--;
        System.out.println("The fish have been feed!");
        System.out.println("Fish feeder has " + getMeals() + " meals left.");
    }
    public int fillUp() {
        setMeals(14);
        System.out.println("Feeder has been refilled");
        return this.meals;
    }
    public String toString() {
        return "Fish Feeder{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", meals=" + meals+
                '}';
    }
}
