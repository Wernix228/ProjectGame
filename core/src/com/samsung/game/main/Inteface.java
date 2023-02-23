package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inteface {

    String platform;
    SpriteBatch batch;
    Texture joyStick = new Texture("interface/field_touchOld.png");
    Texture shadow;

    public Inteface(String shadow,String platform){
        this.shadow = new Texture(shadow);
        batch = new SpriteBatch();
        this.platform = platform;
    }
    public void render(){
        draw();
    }

    private void draw(){
        batch.begin();
        batch.draw(shadow,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        if (platform.equals("Android")) {
            batch.draw(joyStick, 0, 0, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.88f, Gdx.graphics.getWidth() / 5.12f);
        }
        batch.end();
    }

}
