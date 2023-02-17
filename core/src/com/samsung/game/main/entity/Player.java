package com.samsung.game.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.KeyHandler;

public class Player extends Entity {

    private int visibleX = 2048;
    private int visibleY = 1152;

    public Player(KeyHandler keyH, String texture, int scale) {
        this.img = new Texture(texture); // "textures/player/player.png"
        this.batch = new SpriteBatch();
        this.keyH = keyH;
        width = originalWidth * scale;
        height = originalHeight * scale;
    }

    public void render() {
        x = keyH.getX();
        y = keyH.getY();
        if (KeyHandler.activity) {
            draw();
        }
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public void draw() {
        batch.begin();
        batch.draw(img, x, y, width, height);
        batch.end();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getVisibleX() {
        return visibleX;
    }

    public int getVisibleY() {
        return visibleY;
    }

}
