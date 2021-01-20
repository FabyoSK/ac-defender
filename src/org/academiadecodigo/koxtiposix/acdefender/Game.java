package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.controls.Controls;
import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.enemy.EnemyType;
import org.academiadecodigo.simplegraphics.graphics.*;

import java.util.LinkedList;
import java.util.List;

public class Game {

    List<Enemy> enemies;
    CollisionDetector collisionDetector;
    Player player;
    Controls controls;

    public Game(){

        enemies = new LinkedList<>();
        collisionDetector = new CollisionDetector(enemies);
        controls = new Controls();

    }

    public void init(){

        Rectangle background = new Rectangle(Utils.PADDING, Utils.PADDING, Utils.GAME_WIDTH, Utils.GAME_HEIGHT);
        background.setColor(Color.LIGHT_GRAY);
        background.draw();
        background.fill();

        Rectangle header = new Rectangle(10, 10, Utils.GAME_WIDTH, Utils.HEADER_LENGTH);
        header.setColor(Color.RED);
        header.draw();
        header.fill();

        Line line1 = new Line(Utils.PADDING, Utils.ROAD_LINE1_Y_POS, Utils.GAME_WIDTH, Utils.ROAD_LINE1_Y_POS);
        line1.draw();
        Line line2 = new Line(Utils.PADDING, Utils.ROAD_LINE2_Y_POS, Utils.GAME_WIDTH, Utils.ROAD_LINE2_Y_POS);
        line2.draw();

        player = new Player(collisionDetector);
        player.draw();
        controls.setPlayer(player);
        controls.init();

    }

    public void start() throws InterruptedException {

        int x = 0;

        while(player.health() > 0) {

            while (true) {

                if (x % 5 == 0 && x < 1000) {

                    enemies.add(new Enemy(EnemyType.values()[(int) (Math.random() * EnemyType.values().length)]));

                }

                for (Enemy enemy : enemies) {

                    enemy.move();

                }

                player.moveBullet();
                Thread.sleep(50);
                x++;

                for (Enemy enemy : enemies) {

                    if (enemy.isLine_crossed()) {

                        enemy.setLine_crossed(true);
                        player.takeKey();
                        x = 1001;
                        break;
                        //gameEnd();
                    }
                }

                if(x == 1001) {
                    x = 0;
                    for(Enemy enemy : enemies) {
                        enemy.erase();
                    }
                    enemies.removeAll(enemies);
                    player.eraseBullets();
                    Thread.sleep(700);
                    System.out.println("Player HP: " + player.health());
                    break;
                }
            }
        }
        gameEnd();

    }
    private void gameEnd(){
        if (!enemies.isEmpty()) {
            enemies.removeAll(enemies);
        }

        Rectangle background = new Rectangle(10, 10, 1200, 700);
        background.setColor(Color.BLACK);
        background.draw();
        background.fill();

        Text text = new Text(600, 300, "Game Over MotherFucker");
        text.setColor(Color.WHITE);
        text.draw();
    }
}
