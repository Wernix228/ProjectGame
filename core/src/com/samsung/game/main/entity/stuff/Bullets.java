package com.samsung.game.main.entity.stuff;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Bullets {

    Array<Bullet> bullets = new Array<>();

    public Bullets() {

    }
    public void render(){
        for (Bullet bullet:bullets) {
            bullet.render();
        }
    }

    public void createBuleet(String texture, int x0, int y0, int x, int y,int speed) {
        Bullet bullet = new Bullet(texture,x0,y0,x,y,speed);
        bullets.add(bullet);
    }
    public void dispose(){
        for (Bullet bullet:bullets) {
            bullet.dispose();
        }
    }

}
