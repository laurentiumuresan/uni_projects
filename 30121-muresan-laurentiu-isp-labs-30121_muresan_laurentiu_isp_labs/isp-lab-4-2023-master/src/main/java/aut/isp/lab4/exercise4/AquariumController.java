package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumController {

    private FishFeeder feeder;
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private float lightTime;

    public void setLightTime(float lightTime) {
        this.lightTime = lightTime;
    }

    public float getLightTime() {
        return lightTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            this.feeder.feed();
        }
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public void setLightTime() {
        this.lightTime = lightTime;
    }

    public void activateLight() {
        if (this.lightTime > 6 && lightTime < 8) {
            System.out.println("The light time is ok!");
        } else {
            System.out.println("Please turn off the lights!");
        }
    }


    public String toString() {
        return "Fish Feeder=" + feeder +
                ", Manufacturer=" + manufacturer +
                ", Model=" + model +
                ", Current Time=" + currentTime +
                ", Feeding Time=" + feeder +
                ", Light Time=" + lightTime + '\n';
    }
}
