package aut.isp.lab4.exercise6;

public class AquariumController {
    private String manufacturer;

    FishFeeder feeder;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int temperature;
    private int waterLevel;
    private int phLevel;
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
        }else {
            System.out.println("The water level is ok!");
        }
    }
    public boolean checkPHLevel(){
        if(this.phLevel<8 && this.phLevel>5.9){
            System.out.println("The pH level is good!You can change it by 1!");
            return true;
        }else{
            System.out.println("The pH level can't be change!");
            return false;
        }
    }
    public void  changePHLevel(){
        if(checkPHLevel()){
            this.phLevel++;
        }
        else{
            alarm.turnOn();
        }
    }
    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", pH level=" +phLevel+
                ", temperature+" + temperature +
                ", water level=" + waterLevel +
                '}';
    }


}
