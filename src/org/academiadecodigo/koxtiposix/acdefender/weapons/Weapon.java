package org.academiadecodigo.koxtiposix.acdefender.weapons;

import org.academiadecodigo.koxtiposix.acdefender.CollisionDetector;

public class Weapon {

    private Bullet[] bullets;
    private int shotsMade;
    private int damage;
    private CollisionDetector detector;

    public Weapon(CollisionDetector detector) {
        bullets = new Bullet[1000];
        detector.setBullets(bullets);
        shotsMade = 0;
        damage = 5;
        this.detector = detector;
    }

    public Bullet shoot(int playerY) {
        if(shotsMade >= 1000) {
            return null;
        }
        bullets[shotsMade] = new Bullet(damage, playerY, detector);
        shotsMade++;
        return bullets[shotsMade-1];
    }

    public void move() {
        for (Bullet bullet : bullets) {
            if(bullet != null) {
                bullet.move();
            }
        }
    }
}
