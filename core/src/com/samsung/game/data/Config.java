package com.samsung.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.InputStream;
import java.util.Scanner;

public class Config {

    String config;

    public static String screenMode = "window";
    public static int volume = 2;
    public static boolean renderMap;
    public static int entitys;
    public static boolean autoSave;
    public static int scale;
    public static boolean collisionWithNPC;
    public static int defaultSize;
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
            if (!msg.contains("//")){
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
        if (msg.contains("entities")){
            String[] temp = msg.split(" ");
            entitys = Integer.parseInt(temp[1]);
        }
        if (msg.contains("renderMap")){
            String[] temp = msg.split(" ");
            renderMap = Boolean.parseBoolean(temp[1]);
        }
        if (msg.contains("autoSave")){
            String[] temp = msg.split(" ");
            autoSave = Boolean.parseBoolean(temp[1]);
        }
        if (msg.contains("scale")){
            String[] temp = msg.split(" ");
            scale = Integer.parseInt(temp[1]);
        }
        if (msg.contains("collisionWithNPC")){
            String[] temp = msg.split(" ");
            collisionWithNPC = Boolean.parseBoolean(temp[1]);
        }
        if (msg.contains("defaultSize")){
            String[] temp = msg.split(" ");
            defaultSize = Integer.parseInt(temp[1]);
        }
    }


}
