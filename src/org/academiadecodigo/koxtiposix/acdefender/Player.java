package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {

    private final Rectangle playerChar;
    private final Weapon weapon;

    private final int x = 0;


    public Player(CollisionDetector detector) {

        playerChar = new Rectangle(Utils.PLAYER_X_POS, Utils.PLAYER_Y_POS, Utils.SIZE, Utils.SIZE);
        playerChar.draw();
        playerChar.fill();
        weapon = new Weapon(detector);
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
        weapon.moveBullet();

    }
}
