package aut.isp.lab4.exercise4;

public class Exercise4Test {
    public static void main(String[] args) {
        AquariumController AC = new AquariumController();
        AC.setFeedingTime(1432);
        AC.setCurrentTime(1432);
        AC.setLightTime(1432);
        AC.activateLight();
        System.out.println(AC.toString());
        AC.setFeedingTime(12);
        AC.setCurrentTime(1322);
        AC.setLightTime(145);
        AC.activateLight();
        System.out.println(AC.toString());
    }
}
