package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.controls.Controls;
import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.enemy.EnemyType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

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

        controls.setPlayer(player);
        controls.init();

    }

    public void start() throws InterruptedException {

        int x = 0;
        while (true) {
            if(x % 10 == 0 && x < 100) {

                System.out.println("new enemy should appear");
                enemies.add(new Enemy(EnemyType.values()[(int) (Math.random() * EnemyType.values().length)]));
            }

            for(Enemy enemy : enemies) {
                enemy.move();
            }

            player.moveBullet();
            Thread.sleep(150);
            x++;
        }

    }
}
