package com.samsung.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.data.Config;
import com.samsung.game.entity.Player;

public class TileManeger {
    private final Map map;
    private final SpriteBatch batch = new SpriteBatch();
    private final Sprite[] sprite = new Sprite[10];
    private final Array<Rectangle> solidBoxes = new Array<>();

    public TileManeger(Map map) {
        this.map = map;
        setTextures();
    }

    private void setTextures() {
        for (int i = 0; i < sprite.length; i++) {
            sprite[i] = new Sprite(new Texture(getTileImage(i)));
        }
    }

    public void render(Player player) {
        batch.begin();
        Rectangle solidBox;
        for (int i = 0; i < map.getTiles().size; i++) {
            if (player.isVisible(map.getTiles().get(i).x, map.getTiles().get(i).y) && !Config.renderMap) {
                batch.draw(sprite[map.getTiles().get(i).texture], map.getTiles().get(i).x, map.getTiles().get(i).y, map.getTiles().get(i).tileSize, map.getTiles().get(i).tileSize);
                if(map.getTiles().get(i).isSolid) {
                    solidBox = new Rectangle();
                    solidBox.set(map.getTiles().get(i).x, map.getTiles().get(i).y, map.getTiles().get(i).tileSize, map.getTiles().get(i).tileSize);
                    solidBoxes.add(solidBox);
                }
            }else if(Config.renderMap){
                batch.draw(sprite[map.getTiles().get(i).texture], map.getTiles().get(i).x, map.getTiles().get(i).y, map.getTiles().get(i).tileSize, map.getTiles().get(i).tileSize);
                if(map.getTiles().get(i).isSolid) {
                    solidBox = new Rectangle();
                    solidBox.set(map.getTiles().get(i).x, map.getTiles().get(i).y, map.getTiles().get(i).tileSize, map.getTiles().get(i).tileSize);
                    solidBoxes.add(solidBox);
                }
            }
        }
        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }

    private String getTileImage(int texture) {
        if (texture < 10) {
            return "textures/tiles/00" + texture + ".png";
        } else if (texture < 100) {
            return "textures/tiles/0" + texture + ".png";
        } else {
            return "textures/tiles/" + texture + ".png";
        }
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public Array<Rectangle> getSolidBoxes() {
        return solidBoxes;
    }
}
