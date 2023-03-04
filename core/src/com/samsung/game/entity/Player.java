package com.samsung.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.main.KeyHandler;

public class Player extends Entity {

    public Player(KeyHandler keyH, String texture) {
        this.keyH = keyH;
        this.img = new Texture(texture); // "textures/player/player.png"
        this.batch = new SpriteBatch();
        solidBox = new Rectangle();
    }

    public void render() {
        x = keyH.getX();
        y = keyH.getY();
        draw();
        solidBox.set(x, y, width, height);
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
    public boolean isVisible(int x, int y){
        return x > (keyH.getX() + getWidth() / 2) - Gdx.graphics.getWidth()/1.2f
                && x < (keyH.getX() + getWidth() / 2) + Gdx.graphics.getWidth()/1.2f
                && y > (keyH.getY() + getHeight() / 2) - Gdx.graphics.getHeight()/1.2f - height
                && y < (keyH.getY() + getHeight() / 2) + Gdx.graphics.getHeight()/1.2f;
    }

    private void draw() {
        batch.begin();
        batch.draw(img, x, y, width, height);
        batch.end();
    }
}
