package aut.isp.lab4.exercise5;

public class AquariumController {
    private String manufacturer;

    FishFeeder feeder;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int temperature;
    private int waterLevel;
    Alarm alarm;
    Heater heater;


    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWater() {
        return waterLevel;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            this.feeder.feed();
        }
    }

    public void checkTemperature() {

        if (this.temperature >= 24 && this.temperature <= 27)
            System.out.println("The temperature is ok");
        else if (this.temperature < 24) {
            System.out.println("The temperature is too low " + getTemperature());
            heater.turnOn();
        } else {
            System.out.println("The temperature is too high " + getTemperature());
            heater.turnOff();
        }
    }

    public void checkWaterLevel() {
        int waterPresetLevel = 10;
        if (this.waterLevel < waterPresetLevel) {
            alarm.turnOn();
        } else {
            System.out.println("The water level is ok!");
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", temperature+" + temperature +
                ", water level=" + waterLevel +
                '}';
    }


}
