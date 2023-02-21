package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.InputStream;
import java.util.Scanner;

public class Config {

    String config;
    static String screenMode = "window";

    public Config(String config) {
        this.config = config;
        load();
    }

    public void load() {
        FileHandle file = Gdx.files.internal(config);
        InputStream inputStream = file.read();
        Scanner scn = new Scanner(inputStream);
        while (scn.hasNext()){

            String msg = scn.nextLine();

            setConfig(msg);
        }
    }
    private static void setConfig(String msg){
        System.out.println(msg);
        screenMode = msg;
    }

}
