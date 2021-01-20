package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum EnemyType {
    LACKEY(1, 4, Color.BLACK),
    MIDDLE_BOSS(1, 3, Color.BLUE),
    FINAL_BOSS(1, 2, Color.ORANGE),
    PCM(1, 1, Color.DARK_GRAY);

    private final int ROAD_ONE = 194;
    private final int ROAD_TWO = 394;
    private final int ROAD_THREE = 594;
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

    public int chooseRoad() {

        int randomRoadPos = (int) Math.floor(Math.random() * 3);
        int chooseRoad;

        switch(randomRoadPos) {
            case 0:
                chooseRoad = ROAD_ONE;
                break;
            case 1:
                chooseRoad = ROAD_TWO;
                break;
            default:
                chooseRoad = ROAD_THREE;
                break;
        }

        return chooseRoad;
    }

    public Color getColor() {
        return color;
    }
}
