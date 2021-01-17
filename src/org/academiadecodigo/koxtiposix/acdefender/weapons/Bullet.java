package org.academiadecodigo.koxtiposix.acdefender.weapons;

import org.academiadecodigo.koxtiposix.acdefender.CollisionDetector;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Bullet {

    private final int BULLET_LIMIT = 1150;
    private final int BULLET_SPEED = 150;
    private final int X_POSITION = 233;
    private final int WIDTH = 8;
    private final int HEIGHT = 8;
    private boolean hit;
    private Ellipse bullet;
    private CollisionDetector detector;

    public Bullet(int Y_POSITION, CollisionDetector detector) {

        bullet = new Ellipse(X_POSITION, Y_POSITION + 12, WIDTH, HEIGHT);
        bullet.fill();
        this.hit = false;
        this.detector = detector;

    }

    public void move() {

        if(bullet.getX() >= BULLET_LIMIT) {

            System.out.println("Out of bounds");
            bullet.delete();
            hit = true;
            return;

        }

        for(int i = 0; i < BULLET_SPEED; i++) {

            bullet.translate(1, 0);

            if(detector.checkCollision(bullet)) {
                hit = true;
                bullet.delete();
                return;
            }
        }
    }

    public boolean isHit() {
        return hit;
    }
}
