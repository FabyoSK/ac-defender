package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.koxtiposix.acdefender.Utils;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {


    private int hp;
    private final Picture enemyChar;
    private boolean dead;
    private final int speed;
    private boolean line_crossed;


    public Enemy(EnemyType enemyType) {

        this.hp = enemyType.getHp();
        this.speed = enemyType.getSpeed();
        this.enemyChar = new Picture(1100, enemyType.chooseRoad(),enemyType.getSrc() );
        this.enemyChar.draw();
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

    public Picture getEnemyChar() {
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


    public void erase() {
        enemyChar.delete();
    }
}
