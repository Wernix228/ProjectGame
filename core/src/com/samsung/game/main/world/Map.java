package com.samsung.game.main.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.entity.Entity;
import com.samsung.game.main.entity.Player;

public class Map extends Entity {

    private final Array<Tile> tiles = new Array<>();

    public Array<Tile> getTiles() {
        return tiles;
    }

    public Map(String maps) {
        setMap(maps);
    }

    public void setMap(String maps) {
        tiles.clear();
        loadLevel(maps);
    }

    public void render(KeyHandler keyH, Player player) {
        for (Tile tile : tiles) {
            tile.draw(32 * 34, 32 * 20, keyH, player);
        }
    }

    public void dispose() {
        for (Tile tile : tiles) {
            tile.dispose();
        }
    }

    private void loadLevel(String maps) {
        String map = "maps/" + maps + ".txt";
        if (maps.equals("map01")) {
            loadMap(map, 10, 10);
        }else if (maps.equals("map100")){
            loadMap(map,100,100);
        }else if (maps.equals("map250")){
            loadMap(map,250,250);
        }else if (maps.equals("map50")){
            loadMap(map,50,50);
        }

    }

    private void loadMap(String map, int worldWidth, int worldHeight) {

        System.out.println("worldWidth " + worldWidth + " ;  worldHeight " + worldHeight);
        FileHandle file = Gdx.files.internal(map);
        String tiles = file.readString().replaceAll(" ", "");
        String[] tilesX = tiles.split("\n");

        for (int x = 0; x < worldWidth; x++) {
            for (int y = 0; y < worldHeight; y++) {
                String til = String.valueOf(tilesX[y].charAt(x));
                Tile tile = new Tile(x, -y, til);
                this.tiles.add(tile);
            }
        }
    }
}
