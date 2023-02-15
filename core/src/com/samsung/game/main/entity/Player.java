package com.samsung.game.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.Stuff;

public class Player extends Entity {

    private int playerX;
    private int playerY;

    public Player(KeyHandler keyH, String texture, int scale) {
        this.img = new Texture(texture); // "textures/player/player.png"
        this.batch = new SpriteBatch();
        this.keyH = keyH;
        width=originalWidth*scale;
        height=originalHeight*scale;
    }

    public void render() {
        playerX = keyH.getX();
        playerY = keyH.getY();
        if(KeyHandler.activity){
            draw();
        }
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public void draw() {
        batch.begin();
        batch.draw(img, playerX, playerY, width, height);
        batch.end();
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }
}
