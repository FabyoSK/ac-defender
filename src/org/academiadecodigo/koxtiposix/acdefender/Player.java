package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
    private int key = 1;
    private int defaultPos;
    private Rectangle playerChar;
    private static final int PIXEL_JUMP = 200;
    private int size = 32;
    private int playerX = 200;
    private int playerY = 410 - size/2;
    private int x = 0;

    public Player() {
        playerChar = new Rectangle(playerX, playerY, 32, 32);
        playerChar.draw();
        playerChar.fill();
    }


    public void moveUp() {
        if (x != 1) {
            playerChar.translate(0, -PIXEL_JUMP);
            x++;
        }

    }

    public void moveDown() {
        if (x != -1) {
            playerChar.translate(0, PIXEL_JUMP);
            x--;
        }

    }
}
