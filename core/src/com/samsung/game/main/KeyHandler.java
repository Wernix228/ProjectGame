package com.samsung.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.samsung.game.entity.stuff.Bullets;

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
    private String direction = "top";
    private Bullets bullets;
    private boolean attack = false;
    private long cooldownAttack = 20;
    private long cooldown = 0;

    public KeyHandler(int playerX, int playerY, int playerSpeed, String platform, Bullets bullets) {
        this.x = playerX;
        this.y = playerY;
        this.defaultSpeed = playerSpeed;
        this.playerSpeed = playerSpeed;
        this.platform = platform;
        this.bullets = bullets;
    }

    public void render() {
        if (platform.equals("Desktop")) {
            setUpPC();
        }
        if (platform.equals("Android")) {
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

    public void setCollisionUp(boolean collisionUp) {
        this.collisionUp = collisionUp;
    }

    public void setCollisionDown(boolean collisionDown) {
        this.collisionDown = collisionDown;
    }

    public void setCollisionLeft(boolean collisionLeft) {
        this.collisionLeft = collisionLeft;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setCollisionRight(boolean collisionRight) {
        this.collisionRight = collisionRight;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private void setUpAndroid() {
        if (Gdx.input.isTouched(0) && touchLimit() || Gdx.input.isTouched(1)) {
            if (Gdx.input.getX() < 3 * Gdx.graphics.getWidth() / 15.36f && Gdx.input.getX() > 2 * Gdx.graphics.getWidth() / 15.36f && touchLimit() && !collisionRight) {
                x += playerSpeed;
                direction = "right";
                setCollisionLeft(false);
            } else if (Gdx.input.getX() < Gdx.graphics.getWidth() / 15.36f && touchLimit() && !collisionLeft) {
                x -= playerSpeed;
                direction = "left";
                setCollisionRight(false);
            }
            if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 3 && touchLimit() && !collisionDown) {
                y -= playerSpeed;
                direction = "bottom";
                setCollisionUp(false);
            } else if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f && Gdx.input.getY() < Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 1.5f && touchLimit() && !collisionUp) {
                y += playerSpeed;
                direction = "top";
                setCollisionDown(false);
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
        if (Gdx.input.isKeyPressed(Input.Keys.W) && !collisionUp) {
            y += playerSpeed;
            direction = "top";
            setCollisionDown(false);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && !collisionDown) {
            y -= playerSpeed;
            direction = "bottom";
            setCollisionUp(false);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && !collisionRight) {
            x += playerSpeed;
            direction = "right";
            setCollisionLeft(false);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && !collisionLeft) {
            x -= playerSpeed;
            direction = "left";
            setCollisionRight(false);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            cooldown++;
        }

        if (cooldown >= cooldownAttack) {
            attack();
            cooldown = 0;
        }
        //boost = Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT);
    }

    private void setUpOther() {
        if (boost) {
            playerSpeed = defaultSpeed * 2;
        } else playerSpeed = defaultSpeed;
    }

    private boolean touchLimit() {
        return Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.88f && Gdx.input.getX() < Gdx.graphics.getWidth() / 5.12f;
    }

    private void attack() {
        bullets.createBullet("textures/player/stuff/bullet.png", x, y, direction, 15);
    }

    private final String platform;
}
