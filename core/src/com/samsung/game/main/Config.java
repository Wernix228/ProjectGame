package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Config {

    String config;

    public Config(String config){
        this.config = config;
        load();
    }
    public void load(){
        FileHandle file = Gdx.files.internal(config);
        String conf = file.readString();
        System.out.println(conf);
    }
}
