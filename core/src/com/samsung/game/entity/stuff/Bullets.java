package com.samsung.game.entity.stuff;

import com.badlogic.gdx.utils.Array;
import com.samsung.game.data.Config;

public class Bullets {

    Array<Bullet> bullets = new Array<>();

    public void render(){
        for (Bullet bullet:bullets) {
            if(!bullet.getFinish()) {
                bullet.render();
            }else {
                bullets.removeValue(bullet,false);
            }
        }
    }

    public void createBullet(String texture, int x, int y, String direction, int speed) {
        Bullet bullet = new Bullet(texture,x,y,direction,speed);
        bullets.add(bullet);
    }
    public void dispose(){
        for (Bullet bullet:bullets) {
            bullet.dispose();
        }
    }

    public Array<Bullet> getBullets() {
        return bullets;
    }
}
