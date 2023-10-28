package aut.isp.lab4.exercise3;

public class Exercise3Test {
    public static void main(String[] args) {
        AquariumController AC = new AquariumController();
        AC.setFeedingTime(1434);
        AC.setCurrentTime(1434);
        System.out.println(AC.toString());
        AC.setFeedingTime(142);
        AC.setCurrentTime(1412);
        System.out.println(AC.toString());
    }
}