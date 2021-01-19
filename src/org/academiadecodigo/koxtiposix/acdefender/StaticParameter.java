package org.academiadecodigo.koxtiposix.acdefender;

public class StaticParameter {

    public static int PADDING = 10;

    //Background
    public static int BACKGROUND_LENGTH = 700;
    public static int BACKGROUND_WIDTH = 1200;
    public static int HEADER_LENGTH = 100;
    public static int HEADER_WIDTH = BACKGROUND_WIDTH;

    //Player
    public static int PLAYER_SIZE = 32;
    public static int PLAYER_INIT_X = 200 + PADDING;
    public static int PLAYER_INI_Y = (BACKGROUND_LENGTH + HEADER_LENGTH) / 2 - (PLAYER_SIZE / 2) + PADDING;
    public static int PLAYER_JUMP_SIZE = (BACKGROUND_LENGTH - HEADER_LENGTH) / 3;
    public static int PLAYER_TOP_POS = PLAYER_INI_Y - PLAYER_JUMP_SIZE;
    public static int PLAYER_BOTTOM_POS = PLAYER_INI_Y + PLAYER_JUMP_SIZE;

    //Enemy
    public static int ENEMY_SIZE = PLAYER_SIZE;
    public static int ENEMY_INIT_X = 1160;
    public static int ENEMY_Y_POS_1 = PLAYER_TOP_POS;
    public static int ENEMY_Y_POS_2 = PLAYER_INI_Y;
    public static int ENEMY_Y_POS_3 = PLAYER_BOTTOM_POS;

    //Bullet
    public static int BULLET_SIZE = 8;
    public static int BULLET_INIT_X = 233;
}
