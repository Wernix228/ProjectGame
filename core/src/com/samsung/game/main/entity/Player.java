package com.samsung.game.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.KeyHandler;

public class Player extends Entity {

    public Player(KeyHandler keyH, String texture) {
        this.keyH = keyH;
        this.img = new Texture(texture); // "textures/player/player.png"
        this.batch = new SpriteBatch();
    }

    public void render() {
        x = keyH.getX();
        y = keyH.getY();
        if (KeyHandler.activity) draw();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void draw() {
        int scale = 2;
        batch.begin();
        batch.draw(img, x, y, width * scale, height * scale);
        batch.end();
    }

}
