/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


/**
 *
 * @author meimarcel
 */
public class Music {
    
    private AudioInputStream audio;
    private Clip clip;
    private FloatControl volume;
    
    public Music (String songName) {
        try {
            audio = AudioSystem.getAudioInputStream(new File(songName).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audio);
            volume= (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); 

        } catch (Exception e) {
            System.out.println("Nao Foi Possivel Abrir a Musica"+e);
                    
        }
    }
    
    public void start() {
        clip.start();
    }
    
    public void stop() {
        clip.stop();
    }
    
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void setVolume(float vol) {
        try{
            volume.setValue(vol);
        } catch (Exception e){
            volume.setValue(6);
        }
    }
    public void setMusic(String name) {
        try {
            audio = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audio);
            volume= (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); 

        } catch (Exception e) {
            System.out.println("Nao Foi Possivel Abrir a Musica"+e);
                    
        }
        
    }
}
