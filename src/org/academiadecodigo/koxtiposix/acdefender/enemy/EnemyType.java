package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum EnemyType {
    LACKEY(1, 4, Color.BLACK),
    MIDDLE_BOSS(1, 3, Color.BLUE),
    FINAL_BOSS(1, 2, Color.ORANGE),
    PCM(1, 1, Color.DARK_GRAY);

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

        int initialY = (int) Math.floor(Math.random() * 3);
        int y;

        switch(initialY) {
            case 0:
                y = 210 - 16;
                break;
            case 1:
                y = 410 - 16;
                break;
            default:
                y = 610 - 16;
                break;
        }

        return y;
    }

    public Color getColor() {
        return color;
    }
}
