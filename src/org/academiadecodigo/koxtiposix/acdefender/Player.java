package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
    private int key = 3;
    private int defaultPos;
    private Rectangle playerChar;
    private static final int PIXEL_JUMP = 200;
    private static int size = 32;
    private int playerX = 200;
    private static int playerY = 410 - size / 2;
    private int x = 0;
    private Weapon weapon;

    public Player(CollisionDetector detector) {
        playerChar = new Rectangle(playerX, playerY, 32, 32);
        playerChar.draw();
        playerChar.fill();
        weapon = new Weapon(detector);
    }


    public void moveUp() {
        if (x != 1) {
            playerChar.translate(0, -PIXEL_JUMP);
            x++;
        }
        System.out.println(x);
    }

    public void moveDown() {
        if (x != -1) {
            playerChar.translate(0, PIXEL_JUMP);
            x--;
        }
        System.out.println(x);

    }


    public void shoot() {

        weapon.shoot(playerChar.getY());
    }

    public void setX() {
        this.x = 0;
    }

    public void moveBullet() {
        weapon.moveBullet();

    }
}
