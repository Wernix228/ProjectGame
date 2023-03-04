package com.samsung.game.entity.NPC;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.data.Config;
import com.samsung.game.entity.Player;
import com.samsung.game.main.KeyHandler;

public class NPCs {
    Array<NPC> npcs = new Array<>();
    int num = 0;

    public void render(Player player){
        for (NPC npc:npcs) {
            if(!npc.isDead()) {
                npc.render(player);
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
