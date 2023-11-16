package openworld.sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundAdapter {
    Clip clip;
    URL soundURL[] = new URL[30];
    public SoundAdapter(){


        soundURL[0] = getClass().getResource("BlueBoyAdventure.wav");
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){
            System.out.println("Error ocurred "+ e);
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
    public void restart(){
        clip.stop();
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}


