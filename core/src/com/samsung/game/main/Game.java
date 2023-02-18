package com.samsung.game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.samsung.game.main.entity.Player;
import com.samsung.game.main.entity.SolidArea;
import com.samsung.game.main.world.Map;
import com.samsung.game.main.world.Tile;

public class Game extends ApplicationAdapter {
    OrthographicCamera camera;
    KeyHandler keyH;
    Player player;
    Map map;
    SolidArea solidArea;
    String platform;

    public Game(String platform) {
        this.platform = platform;
    }

    @Override
    public void create() {
        keyH = new KeyHandler(0, -200, 8, platform);
        player = new Player(keyH, "textures/player/playerHeat.png");
        map = new Map("map01");
        camera = new OrthographicCamera(1024 * 2, 576 * 2); //16*2 9*2 tiles
        solidArea = new SolidArea(map,keyH);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.01f, .01f, .01f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        setUpCamera();
        keyH.render();

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
            map.setMap("map01");
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
            map.setMap("map02");
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
            map.setMap("map04");
        }

        map.render(keyH, player);
        solidArea.render();
        player.render();
        showFPS();

    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        player.dispose();
        map.dispose();
    }

    double FPS = 60f;
    double drawInterval = 1000000000 / FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawCount = 0;

    private void showFPS() {
        currentTime = System.nanoTime();

        delta += (currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;

        if (delta >= 1) {

            delta--;
            drawCount++;
        }
        if (timer >= 1000000000) {
            System.out.println("FPS:" + drawCount);
            drawCount = 0;
            timer = 0;
        }
    }

    private void setUpCamera() {
        camera.update();
        player.getBatch().setProjectionMatrix(camera.combined);
        for (Tile tile : map.getTiles()) {
            tile.getBatch().setProjectionMatrix(camera.combined);
        }
        camera.position.set(new Vector3(keyH.getX() + player.getWidth() / 2f, keyH.getY() + player.getHeight() / 2f, 0));
    }
}
