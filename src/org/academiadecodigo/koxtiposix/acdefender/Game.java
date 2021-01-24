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
        Picture header = new Picture(10, 10,"resources/Game header.png");
        header.draw();

        Picture background = new Picture(Utils.PADDING, 110, "resources/Game background.png");
        background.draw();


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

            lifeHud();


            if (x % 5 == 0 && x < 40) {

                //System.out.println("new enemy should appear");
                enemies.add(new Enemy(EnemyType.values()[(int) (Math.random() * EnemyType.values().length)]));
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

            if (enemySpawned == enemyDeads) {
                break;
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

        Picture background = new Picture(10, 10, "resources/Game over screen.png");

        if (nr_of_keys != 0) {
            background = new Picture(10, 10, "resources/theEnd.jpeg");
        }

        background.draw();


        String GameOverAudioFile = "/resources/audio/gameover.wav";
        new Audio(GameOverAudioFile).play(true);

    }

    public void lifeHud() {
        if (life_Number != null) {
            life_Number.delete();
        }
        life_Number = new Text(90, 50, "Keys: " + player.health());
        life_Number.grow(30, 10);
        ;
        life_Number.setColor(Color.WHITE);
        life_Number.draw();
    }
}
