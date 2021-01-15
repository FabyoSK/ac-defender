package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.koxtiposix.acdefender.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy {

    private int hp;
    private Rectangle enemy;
    private boolean dead;
    private int speed;
    private final int SIZE = 32;

    public Enemy(EnemyType enemyType) {
        this.hp = enemyType.getHp();
        this.speed = enemyType.getSpeed();
        this.enemy = new Rectangle(534, enemyType.initialY(), SIZE, SIZE);
        this.dead = false;
    }

    public void draw() {

        enemy.fill();
    }

    public void move() {

        enemy.translate(-speed, 0);
    }

    public void suffer(int damage) {

        if(hp <= damage) {
            dead = true;
            hp = 0;
            return;
        }

        hp -= damage;
    }
}
