/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab10.racedemo;

import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author mihai
 */
public class PlaySound {

    private Clip clip;

    void playSound() {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\mihai\\Downloads\\sound.wav")));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void stopSound(){
        if(clip!=null)
            clip.stop();
    }
    
    public static void main(String[] args) throws InterruptedException {
        PlaySound ps = new PlaySound();
        ps.playSound();
        Thread.sleep(8500);
        ps.stopSound();
    }
}
