package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Config {

    private int[][] arr;
    String config;

    public Config(String config) {
        this.config = config;
        load();
    }

    public void load() {
        FileHandle file = Gdx.files.internal(config);
        InputStream inputStream = file.read();
        Scanner scn = new Scanner(inputStream);
        ArrayList<String[]> nums = new ArrayList<>();

        while (scn.hasNext()) {
            nums.add(scn.nextLine().split(" "));
        }
        int columns = nums.get(0).length;
        arr = new int[nums.size()][columns];
        Iterator<String[]> iter = nums.iterator();
        for (int i = 0; i < arr.length; i++) {
            String[] s = iter.next();
            for (int j = 0; j < columns; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

    }
    public int[][] getArr() {
        return arr;
    }


}
