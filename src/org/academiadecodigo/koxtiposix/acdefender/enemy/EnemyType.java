package org.academiadecodigo.koxtiposix.acdefender.enemy;

public enum EnemyType {
    LACKEY(15, 3),
    MIDDLE_BOSS(30, 2),
    FINAL_BOSS(50, 1);

    private int hp;
    private int speed;

    EnemyType(int hp, int speed) {
        this.hp = hp;
        this.speed = speed;
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
}
