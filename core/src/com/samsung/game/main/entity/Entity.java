package com.samsung.game.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.KeyHandler;

import java.awt.Rectangle;

public class Entity {
    KeyHandler keyH;
    SpriteBatch batch;
    Texture img;

    int originalWidth = 32;
    int originalHeight = 32;

    int scale = 2;

    int width;
    int height;

    int x;
    int y;

    public int getX(){return keyH.getX();}
    public int getY(){return keyH.getY();}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public SpriteBatch getBatch() {
        return batch;
    }
}
