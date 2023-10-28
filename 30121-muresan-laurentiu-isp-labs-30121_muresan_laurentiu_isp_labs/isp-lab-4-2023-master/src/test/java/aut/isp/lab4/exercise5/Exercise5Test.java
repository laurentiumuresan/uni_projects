package aut.isp.lab4.exercise5;

public class Exercise5Test {
    public static void main(String[] args) {
        AquariumController AC = new AquariumController();
        AC.setCurrentTime(213);
        AC.setFeedingTime(321);
        AC.checkTemperature();
        AC.checkWaterLevel();
        System.out.println(AC.toString());
    }
}
