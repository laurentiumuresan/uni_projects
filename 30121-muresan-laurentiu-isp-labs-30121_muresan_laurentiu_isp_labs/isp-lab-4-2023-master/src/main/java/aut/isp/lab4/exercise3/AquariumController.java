package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumController {

    private FishFeeder feeder;
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private float lightTime;

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            this.feeder.feed();
        }
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }


    public String toString() {
        return "Fish Feeder=" + feeder +
                "Manufacturer=" + manufacturer +
                "Model=" + model +
                "Current Time=" + currentTime +
                "Feeding Time=" + feeder + '\n';
    }
}
