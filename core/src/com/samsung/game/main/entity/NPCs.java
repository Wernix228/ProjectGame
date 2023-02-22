package com.samsung.game.main.entity;

import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.entity.stuff.Bullet;

import java.util.ArrayList;

public class NPCs {
    Array<NPC> npcs = new Array<>();
    int num = 0;

    public void render(KeyHandler keyH, Player player){
        for (NPC npc:npcs) {
            if(!npc.getDead()) {
                npc.render(keyH, player, 32 * 34, 32 * 19);
            }else {
                npcs.removeValue(npc,false);
            }
        }
    }

    public void createNPC(int x, int y, int texture, int speed, int cooldownChangeDirection,String startDirection) {
        num++;
        NPC npc = new NPC(x,y,texture,speed,cooldownChangeDirection,startDirection,num);
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
    public void getInfo(){
        for (NPC npc:npcs) {
            npc.getLocation();
        }
    }
}
