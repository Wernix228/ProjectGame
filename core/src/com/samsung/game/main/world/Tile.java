package com.samsung.game.main.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.KeyHandler;

import java.awt.Rectangle;

public class Tile {

    private int x;
    private int y;
    private int worldX;
    private int worldY;
    private final int defaultSize = 32;
    private final int scale = 2;
    private final int tileSize = defaultSize * scale;

    private String sprite;
    private SpriteBatch batch;
    private Texture texture;
    private boolean collision = false;

    public Tile(int x, int y, String sprite) {
        this.worldX = x * tileSize;
        this.worldY = y * tileSize;
        this.sprite = sprite;
        loadSprite();
    }

    public void render() {
        move();
        draw();
    }

    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
    private void loadSprite(){
        batch = new SpriteBatch();
        if (Integer.parseInt(sprite) < 10)
        texture = new Texture("textures/tiles/00" + sprite + ".png");
        else if (Integer.parseInt(sprite) < 100)
            texture = new Texture("textures/tiles/0" + sprite + ".png");
        else texture = new Texture("textures/tiles/" + sprite + ".png");
    }

    private void move() {
        x = worldX;
        y = worldY;
    }

    private void draw() {
        batch.begin();
        batch.draw(texture, x, y, tileSize, tileSize);
        batch.end();
    }

    public SpriteBatch getBatch(){return batch;}

    public int getX(){return worldX;}
    public int getY(){return worldY;}
    public int getWidth(){return tileSize;}
    public int getHeight(){return tileSize;}
    public int getDefaultSize(){return defaultSize;}

    public boolean getCollision() {return collision;}
}
