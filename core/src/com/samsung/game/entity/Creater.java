package com.samsung.game.entity;

import com.badlogic.gdx.math.MathUtils;
import com.samsung.game.data.Config;
import com.samsung.game.entity.NPC.NPCs;
import com.samsung.game.main.KeyHandler;

public class Creater {

    private NPCs npcs = new NPCs();
    private int entitys = 10;

    public void create(){
        loadConfig();
        for (int i = 0; i < entitys; i++) {
            npcs.createNPC(96,-96,MathUtils.random(0,3),2,50,"top");
        }
    }

    public void render(Player player){
        npcs.render(player);
    }

    public void dispose(){
        npcs.dispose();
    }

    public NPCs getNpcs() {
        return npcs;
    }

    public void getInfo(){
        npcs.getInfo();
    }

    private void loadConfig(){
        if (Config.entitys != 0) {
            this.entitys = Config.entitys;
        }
    }
}
