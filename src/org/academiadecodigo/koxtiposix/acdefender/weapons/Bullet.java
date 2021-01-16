package org.academiadecodigo.koxtiposix.acdefender.weapons;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private int damage;
    private Ellipse bullet;
    private int size = 8;

    public Bullet(int damage, int positionY) {
        bullet = new Ellipse(233, positionY + 12, 8, 8);
        bullet.fill();
        move();
        this.damage = damage;
    }

    public void move() {

        if(bullet.getX() >= 1150) {
            bullet.delete();
        }
        bullet.translate(50, 0);
    }
}
