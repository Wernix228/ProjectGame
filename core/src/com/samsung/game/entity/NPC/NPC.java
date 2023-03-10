package com.samsung.game.entity.NPC;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.entity.Entity;
import com.samsung.game.entity.Player;
import com.samsung.game.data.Config;
import com.samsung.game.main.KeyHandler;

import org.w3c.dom.ls.LSOutput;

public class NPC extends Entity {

    private String direction;
    private final String startDirection;
    private String blockedDirection = "nothing";
    private final int speed;
    private final int cooldownChangeDirection;
    private int changeDirection = 0;
    private boolean isDead = false;
    private final int num;
    private String color;

    public NPC(int x, int y, int textureNum, int speed, int cooldownChangeDirection, String startDirection,int num) {
        this.img = new Texture(texture(textureNum));
        this.batch = new SpriteBatch();
        this.speed = speed;
        this.cooldownChangeDirection = cooldownChangeDirection;
        this.x = x;
        this.y = y;
        direction = startDirection;
        this.startDirection = startDirection;
        solidBox = new Rectangle();
        this.num = num;
    }

    public void render(Player player) {
        if (Config.renderMap) {
            AI();
            draw();
            solidBox.set(x, y, width, height);
        } else {
            if (player.isVisible(x,y)) {
                AI();
                draw();
                solidBox.set(x, y, width, height);
            }
        }

    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    private void draw() {
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
        batch.begin();
        batch.draw(img, x, y, width, height);
        batch.end();
    }

    private void AI() {
        changeDirection++;
        if (changeDirection == cooldownChangeDirection) {
            changeDirection = 0;
            changeDirection();
        }
    }

    public void changeDirection() {
        int directionRandom = (int) MathUtils.random(1, 16);
        if (directionRandom == 1 && !blockedDirection.equals("top")) direction = "top";
        else if (directionRandom == 2 && !blockedDirection.equals("bottom")) direction = "bottom";
        else if (directionRandom == 3 && !blockedDirection.equals("left")) direction = "left";
        else if (directionRandom == 4 && !blockedDirection.equals("right")) direction = "right";
        else if (blockedDirection.equals("nothing")) direction = startDirection;
    }

    public void setDirectionBlocked(String directionBAN) {
        this.blockedDirection = directionBAN;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }
    public void getLocation(){
        System.out.println("NPC:" + num + "  X:" + x + " Y:" + y + "   color:" + color);
    }

    public String getDirection() {
        return direction;
    }

    private String texture(int texture){
        if (texture==0){
            color = "null";
            return "textures/player/clearCharacter.png";
        }else if (texture==1){
            color = "Blue";
            return "textures/player/clearCharacterBlue.png";
        }else if (texture==2){
            color = "Green";
            return "textures/player/clearCharacterGreen.png";
        }else {
            color = "Red";
            return "textures/player/clearCharacterRed.png";
        }
    }
}
