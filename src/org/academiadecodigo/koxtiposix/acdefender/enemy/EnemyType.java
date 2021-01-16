package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum EnemyType {
    LACKEY(15, 4, Color.BLACK),
    MIDDLE_BOSS(30, 3, Color.BLUE),
    FINAL_BOSS(50, 2, Color.ORANGE),
    PCM(70, 1, Color.DARK_GRAY);

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
                y = 210;
                break;
            case 1:
                y = 410;
                break;
            default:
                y = 610;
                break;
        }

        return y;
    }

    public Color getColor() {
        return color;
    }
}
