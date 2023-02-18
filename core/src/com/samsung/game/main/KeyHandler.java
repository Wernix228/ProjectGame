package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyHandler {
    private int x;
    private int y;
    private final int defaultSpeed;
    private int playerSpeed;
    private boolean boost;
    private boolean collisionUp = false;
    private boolean collisionDown = false;
    private boolean collisionLeft = false;
    private boolean collisionRight = false;

    public KeyHandler(int playerX, int playerY, int playerSpeed,String platform) {
        this.x = playerX;
        this.y = playerY;
        this.defaultSpeed = playerSpeed;
        this.playerSpeed = playerSpeed;
        this.platform = platform;
    }

    public void render() {
        if (platform.equals("Desktop")) {
                if (Gdx.input.isKeyPressed(Input.Keys.W) && !collisionUp) {
                    y += playerSpeed;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.S) && !collisionDown) {
                    y -= playerSpeed;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.D) && !collisionRight) {
                    x += playerSpeed;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.A) && !collisionLeft) {
                    x -= playerSpeed;
                }
                boost = Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT);
        }
        if (platform.equals("Android")) {
            if (Gdx.input.isTouched()) {
                if (Gdx.input.getX() < 3 * Gdx.graphics.getWidth() / 15.36f && Gdx.input.getX() > 2 * Gdx.graphics.getWidth() / 15.36f && touchLimit() && !collisionRight) {
                    x += playerSpeed;
                } else if (Gdx.input.getX() < Gdx.graphics.getWidth() / 15.36f && touchLimit() && !collisionLeft) {
                    x -= playerSpeed;
                }
                if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 3 && touchLimit() && !collisionDown) {
                    y -= playerSpeed;
                } else if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f && Gdx.input.getY() < Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 1.5f && touchLimit() && !collisionUp) {
                    y += playerSpeed;
                }
            }
        }
        if (boost) {
            playerSpeed = defaultSpeed * 2;
        } else playerSpeed = defaultSpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCollisionUp(boolean collisionUp) {
        this.collisionUp = collisionUp;
    }

    public void setCollisionDown(boolean collisionDown) {
        this.collisionDown = collisionDown;
    }

    public void setCollisionLeft(boolean collisionLeft) {
        this.collisionLeft = collisionLeft;
    }

    public void setCollisionRight(boolean collisionRight) {
        this.collisionRight = collisionRight;
    }

    private boolean touchLimit() {
        return Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.88f && Gdx.input.getX() < Gdx.graphics.getWidth() / 5.12f;
    }

    private final String platform;
}
