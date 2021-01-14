package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.controls.Controls;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10, 10, 1200, 600);
        rectangle.setColor(Color.LIGHT_GRAY);
        rectangle.draw();
        rectangle.fill();

        Text text = new Text(270, 200, "Hello World");
        text.draw();


        Player player = new Player();

        Controls controls = new Controls();
        controls.setPlayer(player);
        controls.init();



    }
}
