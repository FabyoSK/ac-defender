package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.enemy.EnemyType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Rectangle rectangle = new Rectangle(10, 10, 600, 400);
        rectangle.setColor(Color.LIGHT_GRAY);
        rectangle.draw();
        rectangle.fill();

        Enemy[] enemies = new Enemy[10];

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
            Thread.sleep(250);
            x++;
        }
        //Text text = new Text(270, 200, "Hello World");
        //text.draw();
    }
}
