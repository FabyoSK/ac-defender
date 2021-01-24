package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.controls.Controls;
import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.enemy.EnemyType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Game {

    List<Enemy> enemies;
    CollisionDetector collisionDetector;
    Player player;
    Controls controls;
    Text bulletsCount;
    Text life_Number;

    public Game() {

        enemies = new LinkedList<>();
        collisionDetector = new CollisionDetector(enemies);
        controls = new Controls();

    }

    public void init() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Picture background = new Picture(Utils.PADDING, Utils.PADDING * 10, "resources/bckgrnd.png");
        background.draw();
        Picture header = new Picture(10, 10, "resources/ac defender.png");
        header.draw();

        player = new Player(collisionDetector);
        player.draw();

        controls.setPlayer(player);
        controls.init();

        life_Number = new Text(150, 50, "key: " + player.health());
        bulletsCount = new Text(50, 50, player.getShotsMade() + "/" + Player.getMaxShoots());
    }



    public void start() throws InterruptedException {

        int x = 0;
        int enemyDeads = 0;

//        while (player.health() > 0 || !Game.hasNextLevel()) {
        while (player.health() > 0) {

            while (true) {
                bulletsHud();
                lifeHud();

                if(x % 5 == 0 && x < 1000) {

                    //System.out.println("new enemy should appear");
                    enemies.add(new Enemy(EnemyType.values()[(int) (Math.random() * EnemyType.values().length)]));
                }

                for (Enemy enemy : enemies) {

                    enemy.move(enemy);

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

                if (x == 1001) {
                    x = 0;
                    for (Enemy enemy : enemies) {
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
        //if(player.health() == 0)
        //gameEnd();
        gameEnd(player.health());
        //
        //display end of story screen
        //
    }


    private void gameEnd(int nr_of_keys) throws InterruptedException {
        if (!enemies.isEmpty()) {
            enemies.removeAll(enemies);
        }

        Picture background = new Picture(10, 10, "resources/gameOver.png");

        if (nr_of_keys == 0) {
            background = new Picture(10, 10, "resources/theEnd.jpeg");

        }

        background.draw();


    }

    private void bulletsHud() {

        if (bulletsCount != null) {
            bulletsCount.delete();
        }

        bulletsCount.setText(player.getShotsMade() + "/" + Player.getMaxShoots());
        bulletsCount.setColor(Color.WHITE);
        bulletsCount.draw();
    }

    public void lifeHud() {
        if (life_Number != null) {
            life_Number.delete();
        }

        life_Number.setText(player.health() + "");
        life_Number.setColor(Color.WHITE);
        life_Number.draw();
    }
}
