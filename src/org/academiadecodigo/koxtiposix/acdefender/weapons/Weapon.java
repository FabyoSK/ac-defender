package org.academiadecodigo.koxtiposix.acdefender.weapons;

public class Weapon {

    private Bullet[] bullets;
    private int shotsMade;
    private int damage;

    public Weapon() {
        bullets = new Bullet[10];
        shotsMade = 0;
        damage = 5;
    }

    public Bullet shoot(int playerY) {
        if(shotsMade >= 10) {
            return null;
        }
        bullets[shotsMade] = new Bullet(damage, playerY);
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
