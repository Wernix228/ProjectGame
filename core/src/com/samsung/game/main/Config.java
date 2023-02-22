package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.InputStream;
import java.util.Scanner;

public class Config {

    String config;
    static String screenMode = "window";
    static int volume = 2;

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
            if (msg.contains("//")){

            }else {
                setConfig(msg);
            }
        }
    }
    private static void setConfig(String msg){
        if (msg.contains("window")){
            screenMode = "window";
        }else if (msg.contains("fullScreen")){
            screenMode = "fullScreen";
        }

        if (msg.contains("volume")){
            String[] temp = msg.split(" ");
            volume = Integer.parseInt(temp[1]);
        }

    }


}
