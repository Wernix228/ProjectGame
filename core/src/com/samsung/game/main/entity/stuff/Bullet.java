package com.samsung.game.main.entity.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.main.entity.Entity;

public class Bullet extends Entity {

    private int speed = 1;
    private boolean finish=false;
    private int lifeEnd=30;
    private int life=0;
    private String direction;

    public Bullet(String texture,int x, int y, String direction, int speed) {
        this.img = new Texture(texture);
        this.batch = new SpriteBatch();
        this.x = x+width/3;
        this.y = y+height/3;
        this.width=16*scale;
        this.height=16*scale;
        this.speed = speed;
        this.direction=direction;
        this.solidBox=new Rectangle();
    }

    public void render() {
        if(!finish) {
            draw();
            solidBox.set(x, y, width, height);
        }
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

        if(life>=lifeEnd) {
            finish=true;
        }else{
            if (direction.equals("top")) {
                y += speed;
            }else if (direction.equals("bottom")) {
                y -= speed;
            }else if (direction.equals("left")) {
                x -= speed;
            }else if (direction.equals("right")) {
                x += speed;
            }
        }
        batch.begin();
        batch.draw(img, x, y, width, height);
        batch.end();
        life++;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public boolean getFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getX(){return x;}
    public int getY(){return y;}
}
