package com.samsung.game.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inteface {


    SpriteBatch batch;
    Sprite shadow;

    public Inteface(String shadow){
        this.shadow = new Sprite(new Texture(shadow));
        batch = new SpriteBatch();
    }
    public void render(){
        draw();
    }
    private void draw(){
        batch.begin();
        shadow.draw(batch);
        batch.end();
    }

}
