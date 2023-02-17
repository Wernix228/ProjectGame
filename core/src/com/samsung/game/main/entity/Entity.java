package com.samsung.game.main.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.KeyHandler;

public class Entity {
    KeyHandler keyH;
    SpriteBatch batch;
    Texture img;

    int originalWidth = 32;
    int originalHeight = 32;

    int scale = 2;

    int width = originalWidth * scale;
    int height = originalHeight * scale;

    int x = Gdx.input.getX();
    int y = Gdx.input.getY();

    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public SpriteBatch getBatch() {
        return batch;
    }
}
