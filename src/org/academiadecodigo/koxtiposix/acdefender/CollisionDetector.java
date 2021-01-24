package org.academiadecodigo.koxtiposix.acdefender;


import org.academiadecodigo.koxtiposix.acdefender.enemy.Enemy;
import org.academiadecodigo.koxtiposix.acdefender.weapons.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollisionDetector {

    private List<Enemy> enemies;
    private LinkedList<Bullet> bullets;

    public CollisionDetector(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setBullets(LinkedList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public Boolean checkCollision(Picture bullet){

        for(int i = 0; i < enemies.size(); i++) {

            if(bullet.getY() > enemies.get(i).getEnemyChar().getY() &&
               bullet.getY() < enemies.get(i).getEnemyChar().getY() + enemies.get(i).getEnemyChar().getHeight() ) {

                if(bullet.getX() + bullet.getWidth()  >= enemies.get(i).getEnemyChar().getX()) {
                    //System.out.println("Shoot");
                    enemies.get(i).suffer();
                    return true;
                }
                //System.out.println("Close");
            }

        }

        Iterator<Enemy> iterator = enemies.iterator();

        while (iterator.hasNext()) {
            if(iterator.next().isDead()) {
                iterator.remove();
            }
        }
        return false;
    }
}

