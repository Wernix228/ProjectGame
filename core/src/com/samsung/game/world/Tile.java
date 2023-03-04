package com.samsung.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.data.Config;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.entity.Player;

public class Tile {
    public int x;
    public int y;
    public int texture;
    public boolean isSolid;
    public int tileSize=Config.defaultSize*Config.scale;
}
