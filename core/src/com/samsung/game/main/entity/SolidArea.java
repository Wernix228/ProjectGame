package com.samsung.game.main.entity;

import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.world.Tile;
import com.badlogic.gdx.utils.Array;

public class SolidArea {

    private Player player;
    private Tile tile;
    private Array<Tile> tiles;
    private KeyHandler keyH;

    public SolidArea(Array<Tile> tiles, Player player, KeyHandler keyHandler) {
        this.tiles = tiles;
        this.player = player;
        this.keyH = keyHandler;
    }
    public void render(){
        for (Tile tile:tiles) {
            this.tile = tile;
            if (collX(tile) && collY(tile)){
                System.out.println("XY");
            }
        }
    }
    private boolean collX(Tile tile){
        if (player.getX() == tile.getX()){ //+16
            keyH.setCollLeft(true);
            return true;
        }
        else {
            keyH.setCollLeft(false);
            return false;
        }
    }
    private boolean collY(Tile tile){
        if (player.getY() == tile.getY()){
            return true;
        }
        else return false;
    }


}
