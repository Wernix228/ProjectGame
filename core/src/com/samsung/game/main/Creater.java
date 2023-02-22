package com.samsung.game.main;

import com.samsung.game.main.entity.NPCs;
import com.samsung.game.main.entity.Player;

public class Creater {

    private NPCs npcs = new NPCs();

    public void create(){
        npcs.createNPC(400,-400,"textures/player/clearCharacter.png",2,50,"top");
        npcs.createNPC(400,-400,"textures/player/clearCharacterRed.png",2,50,"bottom");
        npcs.createNPC(400,-400,"textures/player/clearCharacterBlue.png",2,50,"left");
        npcs.createNPC(400,-400,"textures/player/clearCharacterGreen.png",2,50,"right");
    }

    public void render(Player player, KeyHandler keyH){
        npcs.render(player, keyH);
    }

    public void dispose(){
        npcs.dispose();
    }

    public NPCs getNpcs() {
        return npcs;
    }
}
