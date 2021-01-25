package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.audio.Audio;
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
    Picture lifeKey;
    Picture lifeKey1;
    Picture lifeKey2;

    Text life_Number;
    private String BGMAudioFile = "/resources/audio/bgm.wav";
    private String enemySpawnAudioFile = "/resources/audio/enemydead.wav";
    Audio BGM = new Audio(BGMAudioFile);
    public static int enemyDeads = 0;
    int enemySpawned = 0;
    boolean gameReset = false;


    public Game() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        boot();
    }

    public void boot() {
        Picture bootScreen = new Picture(Utils.PADDING, Utils.PADDING, "resources/loading screen.png");
        bootScreen.draw();

    }

    public void init() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Picture header = new Picture(10, 10, "resources/Game header.png");
        header.draw();

        Picture background = new Picture(Utils.PADDING, 110, "resources/Game background.png");
        background.draw();

        lifeKey = new Picture(50, 30, "resources/Main key.png");
        lifeKey.draw();

        lifeKey1 = new Picture(80, 30, "resources/Main key.png");
        lifeKey1.draw();

        lifeKey2 = new Picture(110, 30, "resources/Main key.png");
        lifeKey2.draw();


        controls = new Controls();
        enemies = new LinkedList<>();
        collisionDetector = new CollisionDetector(enemies);


        player = new Player(collisionDetector);
        player.draw();

        controls.setPlayer(player);
        controls.init();

        life_Number = new Text(150, 50, "key: " + player.health());
    }


    public void start() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {

        new Audio(enemySpawnAudioFile).play(true);
        BGM.play(true);
        int x = 0;


//        while (player.health() > 0 || !Game.hasNextLevel()) {
        while (player.health() > 0) {
            while (true) {
                lifeHud();


                if (x % 15 == 0 && x < 500) {

                    //System.out.println("new enemy should appear");
                    enemies.add(new Enemy(EnemyType.values()[(int) (Math.random() * EnemyType.values().length)]));
                    enemySpawned++;
                }

                for (Enemy enemy : enemies) {

                    enemy.move(enemy);

                }

                player.moveBullet();
                Thread.sleep(50);

                for (Enemy enemy : enemies) {

                    if (enemy.isLine_crossed()) {

                        enemy.setLine_crossed(true);
                        player.takeKey();
                        gameReset = true;
                        break;
                        //gameEnd();
                    }
                }

                if (gameReset) {
                    enemyDeads = 0;
                    enemySpawned = 0;
                    gameReset = false;
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

                System.out.println(enemySpawned + "---" + enemyDeads);
                x++;

                if (enemySpawned == enemyDeads && enemySpawned != 0 && enemyDeads != 0) {
                    gameEnd(player.health());
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

        Picture background = new Picture(10, 10, "resources/Screen Shot 2021-01-24 at 21.16.33 (1).png");

        if (nr_of_keys != 0) {
            enemies.removeAll(enemies);
            player.eraseBullets();
            background = new Picture(10, 10, "resources/Player wins screen.png");
        } else {
            String GameOverAudioFile = "/resources/audio/gameover.wav";

                new Audio(GameOverAudioFile).play(true);


        }

        background.draw();


    }

    public void lifeHud() {
        if (life_Number != null) {
            life_Number.delete();
        }

        if (player.health() == 2) {
            lifeKey2.delete();
        } else if (player.health() == 1) {
            lifeKey1.delete();
        } else if (player.health() == 0) {
            lifeKey.delete();
        }

    }
}
