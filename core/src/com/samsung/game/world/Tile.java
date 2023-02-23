package com.samsung.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.data.Config;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.entity.Player;

public class Tile {

    private final int x;
    private final int y;
    private final int defaultSize = 32;
    private final int scale = 3;
    private final int tileSize = defaultSize * scale;
    private boolean solid;
    private Rectangle solidBox;
    private final Integer sprite;
    private SpriteBatch batch;
    private Texture texture;

    public Tile(int x, int y, int sprite) {
        this.x = x * tileSize;
        this.y = y * tileSize;
        this.sprite = sprite;
        solidBox = new Rectangle();
        loadSprite();
    }

    public void draw(Player player) {
        if (Config.renderMap) {
            batch.begin();
            batch.draw(texture, x, y, tileSize, tileSize);
            solidBox.set(x, y, tileSize, tileSize);
            batch.end();
        } else {
            if (player.isVisible()) {
                batch.begin();
                batch.draw(texture, x, y, tileSize, tileSize);
                solidBox.set(x, y, tileSize, tileSize);
                batch.end();
            }
        }

    }

    public void dispose() {
        texture.dispose();
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public boolean collision() {
        return solid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTileSize() {
        return tileSize;
    }

    public Rectangle getSolidBox() {
        return solidBox;
    }

    private void loadSprite() {
        setCollision(sprite);
        batch = new SpriteBatch();
        if (sprite < 10) {
            texture = new Texture("textures/tiles/00" + sprite + ".png");
        } else if (sprite < 100) {
            texture = new Texture("textures/tiles/0" + sprite + ".png");
        } else {
            texture = new Texture("textures/tiles/" + sprite + ".png");
        }
    }

    private void setCollision(Integer sprite) {
        this.solid = sprite >= 2 && sprite <= 8;
    }
}
