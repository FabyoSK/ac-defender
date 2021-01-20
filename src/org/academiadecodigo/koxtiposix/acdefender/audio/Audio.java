package org.academiadecodigo.koxtiposix.acdefender.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {

    // to store current position
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;
    AudioInputStream audioInputStream;

    // constructor to initialize streams and clip
    public Audio(String shootAudioFile)
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(shootAudioFile).getAbsoluteFile());

        clip = AudioSystem.getClip();
        // create clip reference

    }

   /* public static void main(String[] args) {
        try {
            filePath = "Your path for the file";
            Audio audioPlayer = new Audio(shootAudioFile);

            audioPlayer.play();

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    */

    // Method to play the audio
    public void play() throws LineUnavailableException, IOException {


        // open audioInputStream to the clip
        clip.open(audioInputStream);

        //start the clip
        clip.start();
        status = "play";
    }

    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

}
