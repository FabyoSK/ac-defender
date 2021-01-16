package org.academiadecodigo.koxtiposix.acdefender;


import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.weapons.Bullet;

import java.util.List;

public class CollisionDetector {

    private List<Enemy> enemies;
    private Bullet[] bullets;

    public CollisionDetector(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setBullets(Bullet[] bullets) {
        this.bullets = bullets;
    }
}

