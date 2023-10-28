package isp.lab10.raceapp;

import javax.sound.sampled.*;
import java.io.*;

import static java.lang.Thread.*;

public class PlaySound {

    public static void main(String[] args) {
       Sound sound = new Sound();
       sound.start();
    }
}

    class Sound extends Thread {
    private volatile boolean isRunning=true;
    private Clip clip;
        public void run() {
            while (isRunning) {
                try {
                    clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("manea.wav")));
                    clip.start();
                    sleep(12000);
                    clip.stop();
                    clip.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        public void stopRunning(){
           if(clip!=null)
               clip.stop();
        }
    }

