package aut.isp.lab4.exercise4;


public class Exercise4 {
    public static void main(String[] args) {
        AquariumController AC = new AquariumController();
        AC.setFeedingTime(14);
        AC.setCurrentTime(14);
        AC.setLightTime();
        AC.activateLight();
        System.out.println(AC.toString());
    }
}

