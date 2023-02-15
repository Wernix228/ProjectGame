package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;

public class KeyHandler {
    public static boolean activity = false;
    private int x;
    private int y;
    private int defaultSpeed;
    private int playerSpeed;
    private boolean boost;
    private String platform;

    long lastDropTime = System.nanoTime();

    public KeyHandler(int playerX, int playerY, int playerSpeed) {
        this.x = playerX;
        this.y = playerY;
        this.defaultSpeed = playerSpeed;
        this.playerSpeed = playerSpeed;
    }

    public void render() {
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                y += playerSpeed;
                activity = true;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                y -= playerSpeed;
                activity = true;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                x += playerSpeed;
                activity = true;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                x -= playerSpeed;
                activity = true;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                boost = true;
            } else boost = false;
            if (boost) {
                playerSpeed = defaultSpeed * 2;
            } else playerSpeed = defaultSpeed;
        }
        if (Gdx.input.isTouched()) {
            activity = true;
            if (Gdx.input.getX() < 3 * Gdx.graphics.getWidth() / 15.36f && Gdx.input.getX() > 2 * Gdx.graphics.getWidth() / 15.36f && touchLimit()) {
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String setMap(){
        String map = "map01";
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            map = "map01";
        }else if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            map = "map02";
        }
        return map;
    }

    private boolean touchLimit() {
        boolean limitY = false;
        if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.88f && Gdx.input.getX() < Gdx.graphics.getWidth() / 5.12f) {
            limitY = true;
        }
        return limitY;
    }
}
