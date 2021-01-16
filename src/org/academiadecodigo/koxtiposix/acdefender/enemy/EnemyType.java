package org.academiadecodigo.koxtiposix.acdefender.enemy;

import com.sun.beans.editors.ColorEditor;
import org.academiadecodigo.simplegraphics.graphics.Color;

public enum EnemyType {
    LACKEY(15, 3, Color.BLACK),
    MIDDLE_BOSS(30, 2, Color.BLUE),
    FINAL_BOSS(50, 1, Color.ORANGE);

    private int hp;
    private int speed;
    private Color color;

    EnemyType(int hp, int speed, Color color) {
        this.hp = hp;
        this.speed = speed;
        this.color = color;
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int initialY() {

        int initialX = (int) Math.floor(Math.random() * 3);
        int y;

        switch(initialX) {
            case 0:
                y = 134;
                break;
            case 1:
                y = 234;
                break;
            default:
                y = 334;
                break;
        }

        return y;
    }

    public Color getColor() {
        return color;
    }
}
