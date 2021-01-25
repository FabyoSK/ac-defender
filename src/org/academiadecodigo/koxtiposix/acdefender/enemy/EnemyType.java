package org.academiadecodigo.koxtiposix.acdefender.enemy;

import org.academiadecodigo.koxtiposix.acdefender.Utils;

public enum EnemyType {
    LACKEY(2, 1, "resources/lacey/lacey_walk_0_1.png", 6),
    MIDDLE_BOSS(5, 3, "resources/dc/dc_walk_0_1.png", 15),
    FINAL_BOSS(7, 2, "resources/boss/tile001.png", 14);
    //PCM(10, 1, "resources/soldier2 (1).png");

    private final int ROAD_ONE = 194;
    private final int ROAD_TWO = 394;
    private final int ROAD_THREE = 594;
    private int hp;
    private int speed;
    private String imgUrl;//enemy
    private int maxFolderImg;

    EnemyType(int hp, int speed, String imgUrl, int maxFolderImg) {
        this.hp = hp;
        this.speed = speed;
        this.imgUrl = imgUrl;
        this.maxFolderImg = maxFolderImg;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxFolderImg() {
        return maxFolderImg;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getSpeed() {
        return speed;
    }

    public int chooseRoad() {

        int randomRoadPos = (int) Math.floor(Math.random() * 3);
        int chooseRoad;

        switch (randomRoadPos) {
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


}
