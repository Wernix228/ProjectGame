package com.samsung.game.main.entity;

import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.world.Map;
import com.samsung.game.main.world.Tile;

public class SolidArea {

    private Array<Tile> tiles;
    private KeyHandler keyH;

    public SolidArea(Map map, KeyHandler keyH) {
        tiles = map.getTiles();
        this.keyH = keyH;
    }

    public void render() {
        for (Tile tile : tiles) {
            collision(tile);
        }
    }

    private void collision(Tile tile) {
        if (tile.collision()) {
            for (int i = -64; i < 64; i++) {
                if (tile.getY() + i == keyH.getY()) {
                    if (tile.getX() + 64 == keyH.getX()) {
                        System.out.println("Left");
                        keyH.setCollisionLeft(true);
                    } else keyH.setCollisionLeft(false);
                    if (tile.getX() - 64 == keyH.getX()) {
                        System.out.println("Right");
                        keyH.setCollisionRight(true);
                    } else keyH.setCollisionRight(false);
                }
            }

            for (int i = -64; i < 64; i++) {
                if (tile.getX() + i == keyH.getX()) {
                    if (tile.getY() + 64 == keyH.getY()) {
                        System.out.println("Down");
                        keyH.setCollisionDown(true);
                    } else keyH.setCollisionDown(false);
                    if (tile.getY() - 64 == keyH.getY()) {
                        System.out.println("Up");
                        keyH.setCollisionUp(true);
                    } else keyH.setCollisionUp(false);
                }
            }

        }
    }
}

