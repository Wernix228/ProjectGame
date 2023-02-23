package com.samsung.game.main.entity;

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

    private void draw() {
        batch.begin();
        batch.draw(img, x, y, width, height);
        batch.end();
    }
}
