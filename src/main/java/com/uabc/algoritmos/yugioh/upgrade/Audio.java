/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uabc.algoritmos.yugioh.upgrade;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Audio {

    private Clip clip;

    public Audio() {
        initializeClip();
    }

    private void initializeClip() {
      // File file = new File("C:\\Users\\omar-\\OneDrive\\Documentos\\NetBeansProjects\\Yugioh\\src\\main\\java\\com\\practica4\\yugioh\\ost.wav");
       File file = new File("/home/omarleal/NetBeansProjects/YuGiOh/src/main/java/com/practica4/yugioh/ost.wav");
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playAudio() {
        if (clip != null) {
            clip.start();
        } else {
            initializeClip();
            clip.start();
        }
    }

    public void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void resetAudio() {
        if (clip != null) {
            clip.stop();
            clip.setMicrosecondPosition(0);
        }
    }

    public boolean isAudioPlaying() {
        return clip != null && clip.isRunning();
    }
    
    
}
