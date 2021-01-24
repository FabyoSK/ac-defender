package org.academiadecodigo.koxtiposix.acdefender;

import org.academiadecodigo.koxtiposix.acdefender.audio.Audio;
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
    private String BGMAudioFile = "resources/audio/bgm.wav";
    Audio BGM = new Audio(BGMAudioFile);

    public Game() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    }


    public void init() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

        Picture background = new Picture(Utils.PADDING, Utils.PADDING, "resources/battlefield-1-jogo-destruicao-guerra-papel-de-parede-2560x1600-16528_7 (1).jpg");
        background.draw();

        Picture header = new Picture(10, 10, "resources/ac defender.png");
        header.draw();


        Line line1 = new Line(Utils.PADDING + 10, Utils.ROAD_LINE1_Y_POS, Utils.GAME_WIDTH, Utils.ROAD_LINE1_Y_POS);
        line1.draw();
        Line line2 = new Line(Utils.PADDING + 10, Utils.ROAD_LINE2_Y_POS, Utils.GAME_WIDTH, Utils.ROAD_LINE2_Y_POS);
        line2.draw();


        controls = new Controls();
        enemies = new LinkedList<>();
        collisionDetector = new CollisionDetector(enemies);


        player = new Player(collisionDetector);
        player.draw();
        controls.setPlayer(player);
        controls.init();
    }

    public void start() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
        BGM.play();
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

    private void gameEnd() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (!enemies.isEmpty()) {
            enemies.removeAll(enemies);
        }

        Picture background = new Picture(10, 10, "resources/gameover.png");
        background.draw();

        String GameOverAudioFile = "resources/audio/gameover.wav";
        new Audio(GameOverAudioFile).play();
    }

    private void bulletsHud() {
        if (bulletsCount != null) {
            bulletsCount.delete();
        }
        bulletsCount = new Text(50, 50, player.getShotsMade() + "/" + Player.getMaxShoots());
        bulletsCount.draw();
    }

    public void lifeHud() {
        if (life_Number != null) {
            life_Number.delete();
        }
        life_Number = new Text(150, 50, "key: " + player.health());
        life_Number.draw();
    }
}
