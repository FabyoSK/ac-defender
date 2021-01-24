package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.koxtiposix.acdefender.Game;
import org.academiadecodigo.koxtiposix.acdefender.Utils;
import org.academiadecodigo.koxtiposix.acdefender.audio.Audio;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {


    private int hp;
    private String urlImg;
    private final Picture enemyChar;
    private int maxFolderImg;
    private boolean dead;
    private final int speed;
    private boolean line_crossed;
    private String enemyDeadAudioFile = "/resources/audio/enemydead.wav";


    public Enemy(EnemyType enemyType) {

        this.hp = enemyType.getHp();
        this.urlImg = enemyType.getImgUrl();
        this.maxFolderImg = enemyType.getMaxFolderImg();
        this.speed = enemyType.getSpeed();
        this.enemyChar = new Picture(1060, enemyType.chooseRoad(), enemyType.getImgUrl());
        this.enemyChar.draw();
        this.dead = false;
        this.line_crossed = false;

    }

    int frame = 1;//need to be refactor

    public void move(Enemy enemy) {

        if (enemyChar.getX() <= Utils.DEFEND_LINE) {

            line_crossed = true;
            return;

        }

        if (frame >= enemy.maxFolderImg) {
            frame = 1;
        }

        /** Enemy walk animation**/
        //enemyChar.load(enemy.url);
        //System.out.println(enemy.urlImg.substring(0, enemy.urlImg.lastIndexOf("."))+ i+".png");
        //enemyChar.load(enemy.urlImg.substring(0, enemy.urlImg.lastIndexOf("."))+ i+".png");
        enemyChar.load(enemy.urlImg.substring(0, enemy.urlImg.lastIndexOf("1")) + frame + ".png");
        //character.draw();
        enemyChar.translate(-3, 0);
        //Thread.sleep(150);

        frame++;


        // enemyChar.translate(-speed, 0);
    }

    public void suffer() {

        hp--;
        if (hp <= 0) {

            dead = true;
            hp = 0;
            Game.enemyDeads++;
            new Audio(enemyDeadAudioFile).play(true);
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
