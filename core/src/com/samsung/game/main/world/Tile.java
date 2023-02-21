package com.samsung.game.main.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.entity.Player;

public class Tile {

    private final int x;
    private final int y;
    private final int defaultSize = 32;
    private final int scale = 3;
    private final int tileSize = defaultSize * scale;
    private boolean solid;
    private Rectangle solidBox;
    private final String sprite;
    private SpriteBatch batch;
    private Texture texture;

    public Tile(int x, int y, String sprite) {
        this.x = x * tileSize;
        this.y = y * tileSize;
        this.sprite = sprite;
        solidBox = new Rectangle();
        loadSprite();
    }

    public void draw(int widthScreen, int heightScreen, KeyHandler keyH, Player player) {
        if (x > (keyH.getX() + player.getWidth() / 2) - widthScreen && x < (keyH.getX() + player.getWidth() / 2) + widthScreen &&
                y > (keyH.getY() + player.getHeight() / 2) - heightScreen - 32 && y < (keyH.getY() + player.getHeight() / 2) + heightScreen) {
            batch.begin();
            batch.draw(texture, x, y, tileSize, tileSize);
            solidBox.set(x,y,tileSize,tileSize);
            batch.end();
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
        if (Integer.parseInt(sprite) < 10) {
            texture = new Texture("textures/tiles/00" + sprite + ".png");
        } else if (Integer.parseInt(sprite) < 100) {
            texture = new Texture("textures/tiles/0" + sprite + ".png");
        } else {
            texture = new Texture("textures/tiles/" + sprite + ".png");
        }
    }
    private void setCollision(String sprite){
        this.solid = Integer.parseInt(sprite)>=2 && Integer.parseInt(sprite)<=8;
    }
}
