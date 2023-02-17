package com.samsung.game.main.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

    private final int x;
    private final int y;
    private final int defaultSize = 32;
    private final int scale = 2;
    private final int tileSize = defaultSize * scale;

    private final String sprite;
    private SpriteBatch batch;
    private Texture texture;

    public Tile(int x, int y, String sprite) {
        this.x = x * tileSize;
        this.y = y * tileSize;
        this.sprite = sprite;
        loadSprite();
    }

    public void render() {
        draw();
    }

    public void dispose() {
        texture.dispose();
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void loadSprite(){
        batch = new SpriteBatch();
        if (Integer.parseInt(sprite) < 10)
        texture = new Texture("textures/tiles/00" + sprite + ".png");
        else if (Integer.parseInt(sprite) < 100)
            texture = new Texture("textures/tiles/0" + sprite + ".png");
        else texture = new Texture("textures/tiles/" + sprite + ".png");
    }

    private void draw() {
        batch.begin();
        batch.draw(texture, x, y, tileSize, tileSize);
        batch.end();
    }
}
