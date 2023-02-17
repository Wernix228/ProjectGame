package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;

public class KeyHandler {
    public static boolean activity = false;
    private int x;
    private int y;
    private final int defaultSpeed;
    private int playerSpeed;
    private boolean collLeft = false;

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    private final String platform;

    long time = System.nanoTime();

    public KeyHandler(int playerX, int playerY, int playerSpeed,String platform) {
        this.x = playerX;
        this.y = playerY;
        this.defaultSpeed = playerSpeed;
        this.playerSpeed = playerSpeed;
        this.platform = platform;
    }

    public void setCollLeft(boolean collLeft) {
        this.collLeft = collLeft;
    }

    public void render() {
        if (platform.equals("Desktop")) {
            if (TimeUtils.nanoTime() - time > 1000000000) {
                if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                    y += playerSpeed;
                    activity = true;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                    y -= playerSpeed;
                    activity = true;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.D) && !collLeft) {
                    x += playerSpeed;
                    activity = true;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                    x -= playerSpeed;
                    activity = true;
                }

                boolean boost;
                boost = Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT);
                if (boost) {
                    playerSpeed = defaultSpeed * 2;
                } else playerSpeed = defaultSpeed;
            }
        }
        if (platform.equals("Android")) {
            if (Gdx.input.isTouched()) {
                activity = Gdx.input.isTouched();
                if (Gdx.input.getX() < 3 * Gdx.graphics.getWidth() / 15.36f && Gdx.input.getX() > 2 * Gdx.graphics.getWidth() / 15.36f && touchLimit() && !collLeft) {
                    x += playerSpeed;
                } else if (Gdx.input.getX() < Gdx.graphics.getWidth() / 15.36f && touchLimit()) {
                    x -= playerSpeed;
                }
                if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 3 && touchLimit()) {
                    y -= playerSpeed;
                } else if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f && Gdx.input.getY() < Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 1.5f && touchLimit()) {
                    y += playerSpeed;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean touchLimit() {
        return Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.88f && Gdx.input.getX() < Gdx.graphics.getWidth() / 5.12f;
    }
}
