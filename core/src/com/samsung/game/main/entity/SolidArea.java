package com.samsung.game.main.entity;

import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.entity.stuff.Bullet;
import com.samsung.game.main.entity.stuff.Bullets;
import com.samsung.game.main.world.Map;
import com.samsung.game.main.world.Tile;

public class SolidArea {

    private Array<Tile> tiles;
    private KeyHandler keyH;
    private Player player;
    private Bullets bullets;
    private boolean collisionOn = false;
    private int tilesInVisibleArea;

    public SolidArea(Map map, KeyHandler keyH, Player player, Bullets bullets) {
        tiles = map.getTiles();
        this.keyH = keyH;
        this.player = player;
        this.bullets=bullets;
    }

    public void render() {
        for (Tile tile : tiles) {
            if (tile.collision()) {
                tilesInVisibleArea++;
                playerVisible(tile);
                for (Bullet bullet : bullets.getBullets()) {
                    bulletVisible(bullet,tile);
                }
            }
        }
        if (tilesInVisibleArea == 0) {
            collisionOn = false;
            keyH.setCollisionLeft(false);
            keyH.setCollisionRight(false);
            keyH.setCollisionDown(false);
            keyH.setCollisionUp(false);
        }
        //System.out.println(tilesInVisibleArea);
        tilesInVisibleArea = 0;
    }
    private void playerVisible(Tile tile) {
        if (player.getSolidBox().overlaps(tile.getSolidBox())) {
            //System.out.println("XY");
            collisionPlayer(tile);
        }else{
            tilesInVisibleArea--;
        }
    }

    private void collisionPlayer(Tile tile) {

        if (keyH.getY() <= tile.getY() + tile.getTileSize()-10 && keyH.getY() + player.getHeight() > tile.getY()+10) {
            if (keyH.getX() <= tile.getX() + tile.getTileSize() && keyH.getX() > tile.getX()) {
                System.out.println("Left");
                keyH.setCollisionLeft(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionLeft(false);
            if (keyH.getX() + player.getWidth() >= tile.getX() && keyH.getX() + player.getWidth() < tile.getX() + tile.getTileSize()) {
                System.out.println("Right");
                keyH.setCollisionRight(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionRight(false);
        } else if(!collisionOn) {
            keyH.setCollisionLeft(false);
            keyH.setCollisionRight(false);
        }


        if (keyH.getX() <= tile.getX() + tile.getTileSize()-10 && keyH.getX() + player.getWidth() > tile.getX()+10) {
            if (keyH.getY() <= tile.getY() + tile.getTileSize() && keyH.getY() > tile.getY()) {
                System.out.println("Down");
                keyH.setCollisionDown(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionDown(false);
            if (keyH.getY() + player.getHeight() >= tile.getY() && keyH.getY() + player.getHeight() < tile.getY() + tile.getTileSize()) {
                System.out.println("Up");
                keyH.setCollisionUp(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionUp(false);
        } else if(!collisionOn) {
            keyH.setCollisionDown(false);
            keyH.setCollisionUp(false);
        }
    }

    private void bulletVisible(Bullet bullet, Tile tile) {
        if (bullet.getSolidBox().overlaps(tile.getSolidBox())) {
            //System.out.println("XY");
            bullet.setFinish(true);
        }
    }
}
