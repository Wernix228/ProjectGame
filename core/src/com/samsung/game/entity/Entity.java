package com.samsung.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.data.Config;
import com.samsung.game.main.KeyHandler;

public class Entity {
    protected KeyHandler keyH;
    protected SpriteBatch batch;
    protected Texture img;
    protected Rectangle solidBox;

    protected int originalWidth = Config.defaultSize;
    protected int originalHeight = Config.defaultSize;

    protected int scale = Config.scale;

    protected int width = originalWidth * scale;
    protected int height = originalHeight * scale;

    protected int x;
    protected int y;

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
