package com.samsung.game.main.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class Map implements Runnable {

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

    @Override
    public void run() {
        render();
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

}
