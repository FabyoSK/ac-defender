package org.academiadecodigo.koxtiposix.acdefender.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Audio {

    private Clip clip;
    private URL soundURL;

    public Audio(String path) {
        initClip(path);
    }

    /**
     * Plays the clip from the point it was stopped or from start if passed with the fromStart argument false or true
     *
     * @param fromStart should be true if want to replay the sound from the start or false otherwise
     */
    public void play(boolean fromStart) {

        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {

        clip.stop();
    }

    public void close() {

        clip.close();
    }

    public void setLoop(int times) {
        clip.loop(times);
    }

    public void reOpen() {

        AudioInputStream inputStream = null;

        try {

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(inputStream);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initClip(String path) {

        soundURL = Audio.class.getResource(path); //if loading from jar
        AudioInputStream inputStream = null;

        try {

            if (soundURL == null) {
                path = path.substring(1);
                File file = new File(path);
                soundURL = file.toURI().toURL(); //if executing on intellij
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}