package com.samsung.game.main.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.main.KeyHandler;

public class Entity {
    protected KeyHandler keyH;
    protected SpriteBatch batch;
    protected Texture img;

    protected Rectangle solidBox;

    protected int originalWidth = 32;
    protected int originalHeight = 32;

    protected int scale = 2;

    protected int width = originalWidth * scale;
    protected int height = originalHeight * scale;

    protected int x = Gdx.input.getX();
    protected int y = Gdx.input.getY();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public Rectangle getSolidBox() {
        return solidBox;
    }
}
