package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Race {
    public static void main(String[] args) throws IOException, InterruptedException {
        Race race = new Race();
        JFrame frame = new JFrame("Car race");
        Timer timer = new Timer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SemaphorePanel semaphorePanel = new SemaphorePanel("Start signal");
        RankingPanel rankingPanel = new RankingPanel("Rankings");
        StatsPanel statsPanel = new StatsPanel("Statistics");
        CarPanel carPanel = new CarPanel("Car race");

        frame.setSize(120, 100);
        frame.getContentPane().setLayout(new GridLayout(2, 2));
        frame.getContentPane().add(semaphorePanel);
        frame.getContentPane().add(carPanel);
        frame.getContentPane().add(rankingPanel);
        frame.getContentPane().add(statsPanel);
        frame.pack();
        frame.setVisible(true);
        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        race.race(semaphoreThread, carPanel, statsPanel, rankingPanel, timer);


    }

    public void race(SemaphoreThread semaphoreThread, CarPanel carPanel, StatsPanel statsPanel, RankingPanel rankingPanel, Timer timer) throws IOException, InterruptedException {

        List<Car> cars = new ArrayList<>();
        semaphoreThread.start();
        try {
            semaphoreThread.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        timer.start();
        Sound sound = new Sound();
        sound.start();
        Car car1 = new Car("Red car", carPanel);
        cars.add(car1);
        car1.start();
        Car car2 = new Car("Blue car", carPanel);
        cars.add(car2);
        car2.start();
        Car car3 = new Car("Green car", carPanel);
        cars.add(car3);
        car3.start();
        Car car4 = new Car("Yellow car", carPanel);
        cars.add(car4);
        car4.start();
        for (Car car : cars) {
            try {
                car.join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        statsPanel.getGraphics().drawString(car1.getName() + " race time: " + car1.getRaceTime(), 70, 50);
        statsPanel.getGraphics().drawString(car2.getName() + " race time: " + car2.getRaceTime(), 70, 150);
        statsPanel.getGraphics().drawString(car3.getName() + " race time: " + car3.getRaceTime(), 70, 250);
        statsPanel.getGraphics().drawString(car4.getName() + " race time: " + car4.getRaceTime(), 70, 350);
        timer.stopTimer();
        sound.stopRunning();
        //statsPanel.getGraphics().drawString("Race time: " + cars.stream().mapToLong(Car::getRaceTime).max().orElse(0), 300, 200);
        statsPanel.getGraphics().drawString("Race time: " +timer.getDuration(), 300, 200);
        rankingPanel.getGraphics().drawString(readAllFileLines("Ranking.txt").get(2), 150, 290);
        rankingPanel.getGraphics().drawString(readAllFileLines("Ranking.txt").get(0), 350, 190);
        rankingPanel.getGraphics().drawString(readAllFileLines("Ranking.txt").get(1), 550, 250);
        File file = new File("Ranking.txt");
        file.delete();
    }

    public static List<String> readAllFileLines(String file) throws IOException {
        Path path = Paths.get(file);
        byte[] bytes = Files.readAllBytes(path);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}



