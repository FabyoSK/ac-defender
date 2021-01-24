package org.academiadecodigo.koxtiposix.acdefender.weapons;

import org.academiadecodigo.koxtiposix.acdefender.CollisionDetector;
import org.academiadecodigo.koxtiposix.acdefender.Player;
import org.academiadecodigo.koxtiposix.acdefender.Utils;
import org.academiadecodigo.koxtiposix.acdefender.audio.Audio;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Bullet {

    private boolean hit;
    private final Picture bullet;
    private final CollisionDetector detector;
    private Player player;



    public Bullet(int BULLET_Y_POS, CollisionDetector detector) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        //bullet = new Ellipse(Utils.BULLET_X_POS, BULLET_Y_POS + 72, Utils.BULLET_WIDTH, Utils.BULLET_HEIGHT);
        bullet = new Picture(Utils.BULLET_X_POS, BULLET_Y_POS+68, "resources/Game object (heart).png");
        bullet.draw();

        this.hit = false;
        this.detector = detector;

    }

    public void move() {

        if (bullet.getX() >= Utils.BULLET_LIMIT) {

            bullet.delete();
            hit = true;
            return;

        }

        for (int i = 0; i < Utils.BULLET_SPEED; i++) {

            bullet.translate(1, 0);

            if (detector.checkCollision(bullet)) {

                hit = true;
                bullet.delete();
                return;

            }
        }}

    public boolean isHit() {
        return hit;
    }

    public void erase() {
        bullet.delete();
    }
}
