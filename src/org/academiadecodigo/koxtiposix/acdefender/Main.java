package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.controls.Controls;
import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.enemy.EnemyType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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
        Player player = new Player();
        Enemy[] enemies = new Enemy[10];

        Controls controls = new Controls();
        controls.setPlayer(player);
        controls.init();

        int x = 0;
        while (true) {
            if(x % 10 == 0 && x < 100) {
                for (int i = 0; i < enemies.length; i++) {
                    if (enemies[i] == null) {
                        System.out.println("Enemies made " + (i + 1));
                        enemies[i] = new Enemy(EnemyType.values()[(int) (Math.random() * EnemyType.values().length)]);
                        enemies[i].draw();
                        break;
                    }
                }
            }
            for (int i = 0; i < enemies.length; i++) {
                if(enemies[i] == null) {
                    break;
                }
                enemies[i].move();
            }
            player.moveBullet();
            Thread.sleep(250);
            x++;
        }


    }
}
