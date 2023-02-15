package com.samsung.game.main.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.entity.Entity;
import com.samsung.game.main.entity.Player;

public class Map extends Entity{

    private int worldWidth;
    private int worldHeight;
    private String map;
    public Array<Tile> tiles = new Array<Tile>();

    public Map(int x, int y, String map) {
        this.worldWidth = x;
        this.worldHeight = y;
        this.map=map;
        loadMap();
    }

    public void render() {

            for (Tile tile : tiles) {
                tile.render();
            }
    }

    public void dispose() {
        for (Tile tile : tiles) {
            tile.dispose();
        }
    }

    public void setMap(String map){
        clearMap();
        this.map = "maps/" + map + ".txt";
        loadMap();
    }

    private void loadMap() {
        FileHandle file = Gdx.files.internal(map);
        String tils = file.readString().replaceAll(" ", "");
        String tiles[] = tils.split("\n");

        for (int i = 0; i < worldWidth; i++) {
            for (int j = 0; j < worldHeight; j++) {
                String til = String.valueOf(tiles[j].charAt(i));
                Tile tile = new Tile(i,-j,til);
                this.tiles.add(tile);
            }
        }
    }
    private void clearMap(){
        tiles.clear();
    }
    private boolean canSee(Tile tile){
//        if (tile.getWorldX())
        return false;
    }
}
