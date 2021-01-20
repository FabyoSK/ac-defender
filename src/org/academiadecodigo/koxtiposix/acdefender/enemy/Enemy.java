package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.koxtiposix.acdefender.Utils;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy {


    private int hp;
    private final Rectangle enemyChar;
    private boolean dead;
    private final int speed;
    private boolean line_crossed;


    public Enemy(EnemyType enemyType) {

        this.hp = enemyType.getHp();
        this.speed = enemyType.getSpeed();
        this.enemyChar = new Rectangle(1160, enemyType.chooseRoad(), Utils.SIZE, Utils.SIZE);
        this.enemyChar.setColor(enemyType.getColor());
        enemyChar.fill();
        this.dead = false;
        this.line_crossed = false;

    }

    public void move() {

        if(enemyChar.getX() <= Utils.DEFEND_LINE) {

            line_crossed = true;
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

        }
    }

    public Rectangle getEnemyChar() {
        return enemyChar;
    }

    public boolean isDead() {
        return dead;
    }

    public void setLine_crossed(boolean line_crossed) {
        this.line_crossed = line_crossed;
    }

    public boolean isLine_crossed() {
        return line_crossed;
    }
}
