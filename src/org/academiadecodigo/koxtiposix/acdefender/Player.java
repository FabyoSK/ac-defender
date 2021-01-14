package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
    private int key = 1;
    private int defaultPos;
    private Rectangle r;
    private int pixelJump = 100;

    public Player() {
        r = new Rectangle(1000, 400, 32, 32);
        r.draw();
        r.fill();
    }


    public void moveUp() {

        r.translate(0, -pixelJump);

    }

    public void moveDown() {

        r.translate(0, pixelJump);

    }
}
