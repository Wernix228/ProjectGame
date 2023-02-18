package com.samsung.game.main.entity;

import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.world.Map;
import com.samsung.game.main.world.Tile;

public class SolidArea {

    private Array<Tile> tiles;
    private KeyHandler keyH;

    public SolidArea(Map map, KeyHandler keyH){
        tiles = map.getTiles();
        this.keyH = keyH;
    }
    public void render(){
        for (Tile tile:tiles) {
            if (tile.getX() + 64 == keyH.getX() && tile.getY() == keyH.getY()){
                if (tile.collision()) {
                    System.out.println("Left");
                    keyH.setCollisionLeft(true);
                }else keyH.setCollisionLeft(false);
            }
            if (tile.getX() - 64 == keyH.getX() && tile.getY() == keyH.getY()){
                if (tile.collision()) {
                    System.out.println("Right");
                    keyH.setCollisionRight(true);
                }else keyH.setCollisionRight(false);
            }
            if (tile.getX() == keyH.getX() && tile.getY() - 64 == keyH.getY()){
                if (tile.collision()) {
                    System.out.println("Up");
                    keyH.setCollisionUp(true);
                }else keyH.setCollisionUp(false);
            }
            if (tile.getX() == keyH.getX() && tile.getY() + 64 == keyH.getY()){
                if (tile.collision()) {
                    System.out.println("Down");
                    keyH.setCollisionDown(true);
                }else keyH.setCollisionDown(false);
            }
        }
    }

}
