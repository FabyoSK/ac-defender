package org.academiadecodigo.koxtiposix.acdefender;

public class StaticParameter {
    public static int BACKGROUND_WIDTH = 1200;
    public static int BACKGROUND_LENGTH = 700;
    public static int HEADER_LENGTH = 100;
    public static int PLAYER_SIZE = 32;
    public static int PLAYER_INI_X = (BACKGROUND_LENGTH + HEADER_LENGTH) / 2 - PLAYER_SIZE / 2;
    public static int PLAYER_JUMP_SIZE = (BACKGROUND_LENGTH - HEADER_LENGTH) / 3;
    public static int PLAYER_TOP_POS = PLAYER_INI_X - PLAYER_JUMP_SIZE;
    public static int PLAYER_BOTTOM_POS = PLAYER_INI_X + PLAYER_JUMP_SIZE;

}
