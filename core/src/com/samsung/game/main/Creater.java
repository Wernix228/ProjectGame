package com.samsung.game.main;

import com.samsung.game.main.entity.NPCs;
import com.samsung.game.main.entity.Player;

public class Creater {

    private NPCs npcs = new NPCs();
    private int entitys = 10;

    public void create(){
        loadConfig();
        for (int i = 0; i < entitys; i++) {
            npcs.createNPC(96,-96,"textures/player/clearCharacter.png",2,50,"top");
        }
    }

    public void render(Player player, KeyHandler keyH){
        npcs.render(keyH, player);
    }

    public void dispose(){
        npcs.dispose();
    }

    public NPCs getNpcs() {
        return npcs;
    }

    private void loadConfig(){
        if (Config.entitys != 0)
        this.entitys = Config.entitys;
    }
}
