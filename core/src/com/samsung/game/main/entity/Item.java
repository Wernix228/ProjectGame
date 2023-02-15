package com.samsung.game.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.Stuff;

public class Item extends Entity {

    public Item(int x, int y, String texture, int scale) {
        this.img = new Texture(texture); // "textures/player/player.png"
        this.batch = new SpriteBatch();
        this.x = x;
        this.y = y;
        width=originalWidth*scale;
        height=originalHeight*scale;
        Stuff.items.add(this);
    }

    public void render() {
        batch.begin();
        batch.draw(img, x, y, width, height);
        batch.end();
    }
}
