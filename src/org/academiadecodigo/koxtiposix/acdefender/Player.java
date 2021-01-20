package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ConcurrentModificationException;

public class Player {

    private Rectangle playerChar;
    private final Weapon weapon;
    private int health;
    private final int x = 0;


    public Player(CollisionDetector detector) {

        weapon = new Weapon(detector);
        health = 3;
    }

    public void draw(){
        playerChar = new Rectangle(Utils.PLAYER_X_POS, Utils.PLAYER_Y_POS, Utils.SIZE, Utils.SIZE);
        playerChar.draw();
        playerChar.setColor(Color.WHITE);
        playerChar.fill();
    }

    public void moveUp() {

        if (Utils.X_POS != 1) {
            playerChar.translate(0, - Utils.JUMP_SIZE);
            Utils.X_POS++;
        }
        System.out.println(Utils.X_POS);
    }

    public void moveDown() {

        if (Utils.X_POS != -1) {
            playerChar.translate(0, Utils.JUMP_SIZE);
            Utils.X_POS--;
        }
        System.out.println(Utils.X_POS);

    }

    public void shoot() {

        weapon.shoot(playerChar.getY());
    }

    public void moveBullet() {
        try {
            weapon.moveBullet();
        }catch (ConcurrentModificationException e){
            e.getMessage();
        }

    }

    public void takeKey() {
        health--;
    }

    public int health() {
        return health;
    }

    public void eraseBullets() {
        weapon.eraseBullets();
    }
    public int getShotsMade(){
        return weapon.getShotsMade();
    }
    public static int getMaxShoots(){
        return Weapon.getMaxShoots();
    }
}
