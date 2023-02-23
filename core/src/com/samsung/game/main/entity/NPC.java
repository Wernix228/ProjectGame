package com.samsung.game.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.main.Config;
import com.samsung.game.main.KeyHandler;

public class NPC extends Entity {

    private String direction;
    private final String startDirection;
    private String directionBAN = "nothing";
    private final int speed;
    private final int cooldownChangeDirection;
    private int changeDirection = 0;
    private boolean dead = false;
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

    public void render(KeyHandler keyH, Player player, int widthScreen, int heightScreen) {
        if (Config.renderMap) {
            AI();
            draw();
            solidBox.set(x, y, width, height);
        } else {
            if (x > (keyH.getX() + player.getWidth() / 2) - widthScreen && x < (keyH.getX() + player.getWidth() / 2) + widthScreen &&
                    y > (keyH.getY() + player.getHeight() / 2) - heightScreen - 32 && y < (keyH.getY() + player.getHeight() / 2) + heightScreen && !dead) {
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
        if (directionRandom == 1 && !directionBAN.equals("top")) direction = "top";
        else if (directionRandom == 2 && !directionBAN.equals("bottom")) direction = "bottom";
        else if (directionRandom == 3 && !directionBAN.equals("left")) direction = "left";
        else if (directionRandom == 4 && !directionBAN.equals("right")) direction = "right";
        else if (directionBAN.equals("nothing")) direction = startDirection;
    }

    public void setDirectionBAN(String directionBAN) {
        this.directionBAN = directionBAN;
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
        this.dead = dead;
    }

    public boolean getDead() {
        return !dead;
    }
    public void getLocation(){
        System.out.println("NPC:" + num + "  X:" + x + " Y:" + y + "   color:" + color);
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
