package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy {

    private int hp;
    private Rectangle enemyChar;
    private boolean dead;
    private int speed;
    private final int SIZE = 22;

    public Enemy(EnemyType enemyType) {
        this.hp = enemyType.getHp();
        this.speed = enemyType.getSpeed();
        this.enemyChar = new Rectangle(534, enemyType.initialY(), SIZE, SIZE);
        this.enemyChar.setColor(enemyType.getColor());
        this.dead = false;
    }

    public void draw() {

        enemyChar.fill();
    }

    public void move() {

        if(enemyChar.getX() <= 110) {
            //Implement what to do when reach mainChar area
            return;
        }
        enemyChar.translate(-speed, 0);
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
