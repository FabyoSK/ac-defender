package org.academiadecodigo.koxtiposix.acdefender;

public class Utils {

    /* CLASS GAME */

    public static int GAME_WIDTH = 1200;
    public static int GAME_HEIGHT = 700;
    public static int HEADER_LENGTH = 100;
    public static int SIZE = 32;
    public static int PADDING = 10;
    public static int ROAD_LINE1_Y_POS = (GAME_HEIGHT - HEADER_LENGTH) / 3 + HEADER_LENGTH + PADDING; //310
    public static int ROAD_LINE2_Y_POS = (GAME_HEIGHT - HEADER_LENGTH) / 2 + HEADER_LENGTH * 2 + PADDING; //510

    /*------------*/

    /* CLASS PLAYER */

    public static int JUMP_SIZE = (GAME_HEIGHT - HEADER_LENGTH) / 3; //200
    public static int PLAYER_X_POS = 200;
    public static int PLAYER_Y_POS = 410 - SIZE / 2;
    public static int X_POS = 0;

    /*------------*/

    /* CLASS ENEMY */

    public static int DEFEND_LINE = 310;

    /*------------*/

    /* CLASS ENEMYTYPE */

    public static int ROAD_ONE = 194 + 16 - 77;  // +16 equivalente a metade do tamanho do inimigo anterior
    public static int ROAD_TWO = 394 + 16 - 77; // -64 equivalente a metade do tamanho do inimigo atual
    public static int ROAD_THREE = 594 + 16 - 77;

    /*------------*/

    /* CLASS BULLET */

    public static int BULLET_LIMIT = 1150;
    public static int BULLET_SPEED = 50;
    public static int BULLET_X_POS = 350;


    /*------------*/

}
