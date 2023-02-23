package com.samsung.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.entity.Entity;
import com.samsung.game.entity.Player;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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

    public void render(Player player) {
        for (Tile tile : tiles) {
            tile.draw(player);
//            tile.draw(100, 100, keyH, player);
        }
    }

    public void dispose() {
        for (Tile tile : tiles) {
            tile.dispose();
        }
    }

    private void loadLevel(String maps) {
        String map = "maps/" + maps + ".txt";
        loadMap(map);

    }

    private void loadMap(String map) {
        Integer[][] arr;
        FileHandle file = Gdx.files.internal(map);
        InputStream inputStream = file.read();
        Scanner scn = new Scanner(inputStream);
        ArrayList<String[]> nums = new ArrayList<>();

        while (scn.hasNext()) {
            nums.add(scn.nextLine().split(" "));
        }
        int columns = nums.get(0).length;
        arr = new Integer[nums.size()][columns];
        Iterator<String[]> iter = nums.iterator();


        for (int i = 0; i < arr.length; i++) {
            String[] s = iter.next();
            for (int j = 0; j < columns; j++) {
                arr[i][j] = Integer.parseInt(s[j]);


                Tile tile = new Tile(j, -i, arr[i][j]);
                tiles.add(tile);

            }
        }
    }
}