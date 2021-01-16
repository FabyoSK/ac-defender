package org.academiadecodigo.koxtiposix.acdefender.weapons;

import org.academiadecodigo.koxtiposix.acdefender.CollisionDetector;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private int damage;
    private Ellipse bullet;
    private int size = 8;
    private boolean hit;
    private CollisionDetector detector;

    public Bullet(int damage, int positionY, CollisionDetector detector) {
        bullet = new Ellipse(233, positionY + 12, 8, 8);
        bullet.fill();
        move();
        this.damage = damage;
        this.hit = false;
        this.detector = detector;
    }

    public void move() {

        if(bullet.getX() >= 1150) {
            bullet.delete();
        }
        for(int i = 0; i < 50; i++) {
            bullet.translate(1, 0);

        }
    }
}
