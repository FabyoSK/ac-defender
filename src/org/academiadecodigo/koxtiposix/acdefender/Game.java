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
    Canvas gameArea;
    int n = 0;

    public Game(){
        enemies = new LinkedList<>();
        collisionDetector = new CollisionDetector(enemies);
        controls = new Controls();
    }


    public void init() {
        Rectangle background = new Rectangle(10, 10, 1200, 700);
        background.setColor(Color.LIGHT_GRAY);
        background.draw();
        background.fill();

        Rectangle header = new Rectangle(10, 10, 1200, 100);
        header.setColor(Color.RED);
        header.draw();
        header.fill();

        Line line1 = new Line(10, 310, 1200, 310);
        line1.draw();
        Line line2 = new Line(10, 510, 1200, 510);
        line2.draw();

        player = new Player(collisionDetector);
        player.draw();
        controls.setPlayer(player);
        controls.init();

    }

    public void start() throws InterruptedException {

        int x = 0;
        while (true) {

            if(x % 5 == 0 && x < 1000) {

                //System.out.println("new enemy should appear");
                enemies.add(new Enemy(EnemyType.values()[(int) (Math.random() * EnemyType.values().length)]));
            }

            for(Enemy enemy : enemies) {
                enemy.move();
            }

            player.moveBullet();
            Thread.sleep(50);
            x++;

            for (Enemy enemy: enemies) {

                if(enemy.isLine_crossed()){
                    enemy.setLine_crossed(true);
                    player.setX();
                    x = 1001;
                    gameEnd();
                }
            }
        }

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
