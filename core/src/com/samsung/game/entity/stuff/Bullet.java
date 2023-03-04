package com.samsung.game.entity.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.entity.Entity;

public class Bullet extends Entity {

    private final int speed;
    private boolean finish = false;
    private int life = 0;
    private final String direction;

    public Bullet(String texture, int x, int y, String direction, int speed) {
        this.img = new Texture(texture);
        this.batch = new SpriteBatch();
        this.x = x + width / 3;
        this.y = y + height / 3;
        this.width = 16 * scale;
        this.height = 16 * scale;
        this.speed = speed;
        this.direction = direction;
        this.solidBox = new Rectangle();
    }

    public void render() {
        draw();
        solidBox.set(x, y, width, height);
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    private void draw() {

        int lifeEnd = 30;
        if (life >= lifeEnd) {
            finish = true;
        } else {
            switch (direction) {
                case "top":
                    y += speed;
                    break;
                case "bottom":
                    y -= speed;
                    break;
                case "left":
                    x -= speed;
                    break;
                case "right":
                    x += speed;
                    break;
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

}
