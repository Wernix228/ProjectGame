package com.samsung.game.main.entity;

import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.entity.stuff.Bullet;

public class NPCs {
    Array<NPC> npcs = new Array<>();

    public void render(Player player, KeyHandler keyH){
        for (NPC npc:npcs) {
            if(!npc.getDead()) {
                npc.render(keyH, player, 32 * 35, 32 * 20);
            }else {
                npc = null;
                npcs.removeValue(npc, false);
            }
        }
    }

    public void createNPC(int x, int y, String texture, int speed, int cooldownChangeDirection,String startDirection) {
        NPC npc = new NPC(x,y,texture,speed,cooldownChangeDirection,startDirection);
        npcs.add(npc);
    }
    public void dispose(){
        for (NPC npc:npcs) {
            npc.dispose();
        }
    }

    public Array<NPC> getNPCs() {
        return npcs;
    }
}
