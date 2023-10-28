package aut.isp.lab4.exercise6;

public class Exercise6Test {

    public static void main(String[] args) {
        AquariumController AC = new AquariumController();
        AC.setCurrentTime(213);
        AC.setFeedingTime(321);
        AC.checkTemperature();
        AC.checkWaterLevel();
        AC.changePHLevel();
        AC.checkPHLevel();
        System.out.println(AC.toString());
    }
}
