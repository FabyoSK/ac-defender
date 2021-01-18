package org.academiadecodigo.koxtiposix.acdefender.weapons;

import org.academiadecodigo.koxtiposix.acdefender.CollisionDetector;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Weapon {

    private List<Bullet> bullets;
    private int shotsMade;
    private int damage;
    private CollisionDetector detector;

    public Weapon(CollisionDetector detector) {
        bullets = new LinkedList<>();
        detector.setBullets((LinkedList<Bullet>) bullets);
        shotsMade = 0;
        damage = 5;
        this.detector = detector;
    }

    public void shoot(int playerY) {
        if(shotsMade >= 1000) {
            return;
        }
        bullets.add(new Bullet(damage, playerY, detector));
        shotsMade++;
    }

    public void moveBullet() {
        for (Bullet bullet : bullets) {
            if(bullet != null) {
                bullet.move();
            }
        }


        Iterator<Bullet> iterator = bullets.iterator();

        while (iterator.hasNext()) {
            if(iterator.next().isHit()) {
                iterator.remove();
            }
        }

    }
}
