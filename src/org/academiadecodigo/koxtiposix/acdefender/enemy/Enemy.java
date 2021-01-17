package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy {

    private final int DEFEND_LINE = 110;
    private final int SIZE = 32;
    private int hp;
    private int speed;
    private boolean dead;
    private Rectangle enemyChar;

    public Enemy(EnemyType enemyType) {
        this.hp = enemyType.getHp();
        this.speed = enemyType.getSpeed();
        this.enemyChar = new Rectangle(1160, enemyType.chooseRoad(), SIZE, SIZE);
        this.enemyChar.setColor(enemyType.getColor());
        enemyChar.fill();
        this.dead = false;
    }

    public void move() {

        if(enemyChar.getX() <= DEFEND_LINE) {
            //Implement what to do when reach mainChar area
            return;
        }
        enemyChar.translate(-speed, 0);
    }

    public void suffer() {

        hp--;
        if(hp <= 0) {
            dead = true;
            hp = 0;
            enemyChar.delete();
            System.out.println("Dead");
            return;
        }
    }

    public Rectangle getEnemyChar() {
        return enemyChar;
    }

    public boolean isDead() {
        return dead;
    }
}
