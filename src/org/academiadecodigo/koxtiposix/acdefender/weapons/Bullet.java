package org.academiadecodigo.koxtiposix.acdefender.weapons;

import org.academiadecodigo.koxtiposix.acdefender.CollisionDetector;
import org.academiadecodigo.koxtiposix.acdefender.Utils;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Bullet {

    private boolean hit;
    private final Ellipse bullet;
    private final CollisionDetector detector;

    public Bullet(int BULLET_Y_POS, CollisionDetector detector) {

        bullet = new Ellipse(Utils.BULLET_X_POS, BULLET_Y_POS + 12, Utils.BULLET_WIDTH, Utils.BULLET_HEIGHT);
        bullet.fill();
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
