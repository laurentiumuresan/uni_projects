package aut.isp.lab4.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        AquariumController AC = new AquariumController();
        AC.setFeedingTime(14);
        AC.setCurrentTime(14);
        System.out.println(AC.toString());
    }
}
