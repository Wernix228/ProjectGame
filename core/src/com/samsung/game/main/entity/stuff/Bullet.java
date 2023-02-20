package com.samsung.game.main.entity.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.main.entity.Entity;

public class Bullet extends Entity {

    private int x0;
    private int y0;
    private int speed = 1;


    public Bullet(String texture,int x0, int y0, int x, int y,int speed) {
        this.img = new Texture(texture);
        this.batch = new SpriteBatch();
        this.x0 = x0;
        this.y0 = y0;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render() {
        draw();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void draw() {

        if (x0 < x){
            x0+=speed;
        }
        if (y0 < y){
            y0+=speed;
        }

        batch.begin();
        batch.draw(img, x0, y0, width, height);
        batch.end();
    }

}
