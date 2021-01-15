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

        Enemy one = new Enemy(EnemyType.LACKEY);
        one.draw();

        while (true) {
            Thread.sleep(250);
            one.move();
        }
        //Text text = new Text(270, 200, "Hello World");
        //text.draw();
    }
}
