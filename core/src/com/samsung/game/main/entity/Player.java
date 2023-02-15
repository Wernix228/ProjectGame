package com.samsung.game.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.Stuff;

public class Player extends Entity {

    public Player(KeyHandler keyH, String texture, int scale) {
        this.img = new Texture(texture); // "textures/player/player.png"
        this.batch = new SpriteBatch();
        this.keyH = keyH;
        width=originalWidth*scale;
        height=originalHeight*scale;
    }

    public void render() {
        draw();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    private void draw() {
        batch.begin();
        batch.draw(img, keyH.getX(), keyH.getY(), width, height);
        batch.end();
    }
}
