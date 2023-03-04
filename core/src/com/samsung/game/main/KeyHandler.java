package com.samsung.game.main;

import static com.samsung.game.main.DirectionCollisionLeftRight.*;
import static com.samsung.game.main.DirectionCollisionTopBottom.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.samsung.game.entity.stuff.Bullets;

public class KeyHandler {
    private int x;
    private int y;
    private final int playerSpeed;
    private DirectionCollisionTopBottom directionCollisionTopBottom;
    private DirectionCollisionLeftRight directionCollisionLeftRight;
    private String direction = "top";
    private final Bullets bullets;
    private final long cooldownAttack = 20;
    private long cooldown = 0;

    public KeyHandler(int playerX, int playerY, int playerSpeed, String platform, Bullets bullets) {
        this.x = playerX;
        this.y = playerY;
        this.playerSpeed = playerSpeed;
        this.platform = platform;
        this.bullets = bullets;
    }

    public void render() {
        if (platform.equals("Desktop")) {
            setUpPC();
        } else if (platform.equals("Android")) {
            setUpAndroid();
        }
        setUpOther();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirectionCollisionTopBottom(DirectionCollisionTopBottom directionCollision) {
        this.directionCollisionTopBottom = directionCollision;
    }
    public void setDirectionCollisionLeftRight(DirectionCollisionLeftRight directionCollision) {
        this.directionCollisionLeftRight = directionCollision;
    }

    public DirectionCollisionTopBottom getDirectionCollisionTopBottom() {
        return directionCollisionTopBottom;
    }
    public DirectionCollisionLeftRight getDirectionCollisionLeftRight() {
        return directionCollisionLeftRight;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private void setUpAndroid() {
        if (Gdx.input.isTouched(0) && touchLimit() || Gdx.input.isTouched(1)) {
            if (Gdx.input.getX() < 3 * Gdx.graphics.getWidth() / 15.36f && Gdx.input.getX() > 2 * Gdx.graphics.getWidth() / 15.36f
                    && touchLimit() && getDirectionCollisionLeftRight()!=RIGHT) {
                x += playerSpeed;
                direction = "right";
                setDirectionCollisionLeftRight(NOTHINGLR);
            } else if (Gdx.input.getX() < Gdx.graphics.getWidth() / 15.36f && touchLimit()
                    && getDirectionCollisionLeftRight()!=LEFT) {
                x -= playerSpeed;
                direction = "left";
                setDirectionCollisionLeftRight(NOTHINGLR);
            }
            if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 3 && touchLimit()
                    && getDirectionCollisionTopBottom()!=BOTTOM) {
                y -= playerSpeed;
                direction = "bottom";
                setDirectionCollisionTopBottom(NOTHINGTB);
            } else if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f
                    && Gdx.input.getY() < Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 1.5f && touchLimit() && getDirectionCollisionTopBottom()!=TOP) {
                y += playerSpeed;
                direction = "top";
                setDirectionCollisionTopBottom(NOTHINGTB);
            }
        }
        if (Gdx.input.isTouched(1) || Gdx.input.isTouched(0) && !touchLimit()) {
            cooldown++;
            if (cooldown >= cooldownAttack) {
                attack();
                cooldown = 0;
            }
        }
    }

    private void setUpPC() {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && getDirectionCollisionTopBottom()!=TOP) {
            y += playerSpeed;
            direction = "top";
            setDirectionCollisionTopBottom(NOTHINGTB);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && getDirectionCollisionTopBottom()!=BOTTOM) {
            y -= playerSpeed;
            direction = "bottom";
            setDirectionCollisionTopBottom(NOTHINGTB);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && getDirectionCollisionLeftRight()!=RIGHT) {
            x += playerSpeed;
            direction = "right";
            setDirectionCollisionLeftRight(NOTHINGLR);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && getDirectionCollisionLeftRight()!=LEFT) {
            x -= playerSpeed;
            direction = "left";
            setDirectionCollisionLeftRight(NOTHINGLR);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            cooldown++;
        }

        if (cooldown >= cooldownAttack) {
            attack();
            cooldown = 0;
        }
    }

    private void setUpOther() {

    }

    private boolean touchLimit() {
        return Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.88f && Gdx.input.getX() < Gdx.graphics.getWidth() / 5.12f;
    }

    private void attack() {
        bullets.createBullet("textures/player/stuff/bullet.png", x, y, direction, 15);
    }

    private final String platform;
}
