package com.samsung.game.world;

public class InfoTile {
    private int x;
    private int y;
    private int texture;

    private final int defaultSize = 32;
    private final int scale = 3;
    private final int tileSize = defaultSize * scale;

    private boolean using = false;

    public InfoTile(int x, int y, int texture) {
        this.x = x * tileSize;
        this.y = y * tileSize;
        this.texture = texture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTexture() {
        return texture;
    }

    public void setUsing(boolean using) {
        using = using;
    }

    public boolean isUsing() {
        return using;
    }

    public void setInfo(int x,int y,int texture){
        this.x = x * tileSize;
        this.y = y * tileSize;
        this.texture = texture;
    }

}
