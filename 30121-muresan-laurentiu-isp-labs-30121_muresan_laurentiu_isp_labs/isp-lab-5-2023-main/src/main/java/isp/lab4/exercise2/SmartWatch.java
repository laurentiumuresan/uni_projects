package isp.lab4.exercise2;

public class SmartWatch {
    private int batteryLevel=0;

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void charge(int duration) {
        while (this.batteryLevel <100 && duration!=0) {
            this.batteryLevel += 5 ;
            if(this.batteryLevel>100){
                this.batteryLevel=100;
            }
            duration--;
        }
        System.out.println("The watch's battery is " + batteryLevel + "% after the time given.");
    }
}
