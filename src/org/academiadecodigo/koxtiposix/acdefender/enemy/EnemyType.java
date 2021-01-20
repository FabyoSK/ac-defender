package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.koxtiposix.acdefender.Utils;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum EnemyType {
    LACKEY(2, 4, "resources/Screen_Shot_2021-01-20_at_16.43.20-removebg-preview (2).png"),
    MIDDLE_BOSS(5, 3, "resources/Screen_Shot_2021-01-20_at_16.43.20-removebg-preview (2).png"),
    FINAL_BOSS(7, 2, "resources/soldier2 (1).png"),
    PCM(10, 1, "resources/soldier2 (1).png");

    private final int ROAD_ONE = 194;
    private final int ROAD_TWO = 394;
    private final int ROAD_THREE = 594;
    private int hp;
    private int speed;
    private String src;

    EnemyType(int hp, int speed, String src) {
        this.hp = hp;
        this.speed = speed;
        this.src = src;
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
                chooseRoad = Utils.ROAD_ONE;
                break;
            case 1:
                chooseRoad = Utils.ROAD_TWO;
                break;
            default:
                chooseRoad = Utils.ROAD_THREE;
                break;
        }

        return chooseRoad;
    }

    public String getSrc() {
        return src;
    }
}
