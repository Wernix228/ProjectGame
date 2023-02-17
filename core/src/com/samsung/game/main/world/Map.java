package com.samsung.game.main.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.entity.Entity;

public class Map extends Entity {

    private String map;
    public Array<Tile> tiles = new Array<>();

    public Map(String map) {
        this.map = map;
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

    public void setMap(String map) {
        clearMap();
        this.map = "maps/" + map + ".txt";
        loadMap();
    }
    public Array<Tile> getTile(){
        return tiles;
    }

    private void loadMap() {
        FileHandle file = Gdx.files.internal(map);
        String tiles = file.readString().replaceAll(" ", "");

        int worldWidth = (int) Math.sqrt(tiles.length());
        int worldHeight = (int) Math.sqrt(tiles.length());

        System.out.println("worldWidth " + worldWidth + " ;  worldHeight " + worldHeight);
        String[] tilesX = tiles.split("\n");

        for (int x = 0; x < worldWidth; x++) {
            for (int y = 0; y < worldHeight; y++) {
                String til = String.valueOf(tilesX[y].charAt(x));
                Tile tile = new Tile(x, -y, til);
                this.tiles.add(tile);
            }
        }
    }

    private void clearMap() {
        tiles.clear();
    }

    public void renderVisible(){
        for (Tile tile:tiles) {
            if (tile.getX() >= Gdx.input.getX() + 64 / 2f){
                tile.render();
            }

        }
    }
}
