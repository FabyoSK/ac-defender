package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
    private int key = 3;
    private int defaultPos;
    private Rectangle playerChar;
    private static final int PIXEL_JUMP = 200;
    private static int size = StaticParameter.PLAYER_SIZE;
    private int playerX = StaticParameter.PLAYER_INIT_X;
    private static int playerY = StaticParameter.PLAYER_INI_Y;
    private int x = 0;
    private Weapon weapon;

    public Player(CollisionDetector detector) {
        playerChar = new Rectangle(playerX, playerY, size, size);
        weapon = new Weapon(detector);
    }

    public void draw() {
        playerChar.draw();
        playerChar.fill();
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
