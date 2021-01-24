package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.controls.Controls;
import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.enemy.EnemyType;
import org.academiadecodigo.simplegraphics.graphics.*;
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
        Picture header = new Picture(10, 10,"resources/Game header.png");
        header.draw();

        Picture background = new Picture(Utils.PADDING, Utils.PADDING * 10, "resources/Game background.png");
        background.draw();

        //Picture Tree = new Picture(400, 350, "resources/arvore-removebg-preview.png");
        //Tree.draw();


        player = new Player(collisionDetector);
        player.draw();
        controls.setPlayer(player);
        controls.init();

    }

    public void start() throws InterruptedException {

        int x = 0;

        while (player.health() > 0) {

            while (true) {
                bulletsHud();
                lifeHud();
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
        gameEnd();
    }


    private void gameEnd() {
        if (!enemies.isEmpty()) {
            enemies.removeAll(enemies);
        }

        Picture background = new Picture(10, 10,"resources/Game over screen.png");
        background.draw();
    }

    private void bulletsHud() {
        if (bulletsCount != null) {
            bulletsCount.delete();
        }
        bulletsCount = new Text(100, 50, player.getShotsMade() + "/" + Player.getMaxShoots());
        bulletsCount.grow(20, 10);
        bulletsCount.setColor(Color.WHITE);
        bulletsCount.draw();
    }

   public void lifeHud() {
        if (life_Number != null) {
            life_Number.delete();
        }
        life_Number = new Text(200, 50, "KEY: " + player.health());
        life_Number.grow(20, 10);;
        life_Number.setColor(Color.WHITE);
        life_Number.draw();
    }

   }

