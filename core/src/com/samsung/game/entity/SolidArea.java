package com.samsung.game.entity;

import static com.samsung.game.main.DirectionCollisionTopBottom.*;
import static com.samsung.game.main.DirectionCollisionLeftRight.*;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.data.Config;
import com.samsung.game.entity.NPC.NPC;
import com.samsung.game.entity.NPC.NPCs;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.entity.stuff.Bullet;
import com.samsung.game.entity.stuff.Bullets;
import com.samsung.game.world.Map;
import com.samsung.game.world.Tile;

public class SolidArea{
    private final KeyHandler keyH;
    private final Player player;
    private final Bullets bullets;
    private final NPCs npcs;
    private final Map map;
    private int tilesInCollisionArea;
    private final boolean isPlayerCollsionNPC = Config.collisionWithNPC;

    public SolidArea(Map map, KeyHandler keyH, Player player, Bullets bullets, NPCs npcs) {
        this.map = map;
        this.keyH = keyH;
        this.player = player;
        this.bullets = bullets;
        this.npcs = npcs;
    }

    public void render() {
        for (Rectangle solidBox : map.getTileManeger().getSolidBoxes()) {
            if (player.isVisible((int) solidBox.x, (int) solidBox.y)) {
                tilesInCollisionArea++;
                playerVisible(solidBox);
                for (Bullet bullet : bullets.getBullets()) {
                    bulletCollision(bullet, solidBox);
                }
            }
            for (NPC npc : npcs.getNPCs()) {
                NPCVisible(npc, solidBox);
            }
        }
        if (tilesInCollisionArea == 0) {
            keyH.setDirectionCollisionTopBottom(NOTHINGTB);
            keyH.setDirectionCollisionLeftRight(NOTHINGLR);
        }
        tilesInCollisionArea = 0;
    }

    private void playerVisible(Rectangle solidBox) {
        if (player.getSolidBox().overlaps(solidBox)) {
            if (collisionChecker(player.getSolidBox(), solidBox).equals("left"))
                keyH.setDirectionCollisionLeftRight(LEFT);
            else if (collisionChecker(player.getSolidBox(), solidBox).equals("right"))
                keyH.setDirectionCollisionLeftRight(RIGHT);
            else if (collisionChecker(player.getSolidBox(), solidBox).equals("top"))
                keyH.setDirectionCollisionTopBottom(TOP);
            else if (collisionChecker(player.getSolidBox(), solidBox).equals("bottom"))
                keyH.setDirectionCollisionTopBottom(BOTTOM);
        } else {
            tilesInCollisionArea--;
        }
    }

    private void bulletCollision(Bullet bullet, Rectangle solidBox) {
        if (bullet.getSolidBox().overlaps(solidBox)) {
            bullet.setFinish(true);
        }
    }

    private void NPCVisible(NPC npc, Rectangle solidBox) {
        if (npc.getSolidBox().overlaps(solidBox)) {
            npc.setDirectionBlocked(collisionChecker(npc.getSolidBox(), solidBox));
            npc.changeDirection();
        }
        if (isPlayerCollsionNPC) {
            if (npc.getSolidBox().overlaps(player.getSolidBox())) {
                npc.setDirectionBlocked(collisionChecker(npc.getSolidBox(), solidBox));
                npc.changeDirection();
            }
        }
        for (Bullet bullet : bullets.getBullets()) {
            if (npc.getSolidBox().overlaps(bullet.getSolidBox())) {
                npc.setDead(true);
                bullet.setFinish(true);
            }
        }
    }

    private String collisionChecker(Rectangle solidBox1, Rectangle solidBox2) {
        String direction = "nothing";
        if (solidBox1.getY() <= solidBox2.y + solidBox2.height - 10 && solidBox1.getY() + solidBox1.getHeight() > solidBox2.y + 10) {
            if (solidBox1.getX() <= solidBox2.x + solidBox2.width && solidBox1.getX() > solidBox2.x) {
                direction = "left";
            }
            if (solidBox1.getX() + solidBox1.getWidth() >= solidBox2.x && solidBox1.getX() + solidBox1.getWidth() < solidBox2.x + solidBox2.width) {
                direction = "right";
            }
        }

        if (solidBox1.getX() <= solidBox2.x + solidBox2.width - 10 && solidBox1.getX() + solidBox1.getWidth() > solidBox2.x + 10) {
            if (solidBox1.getY() <= solidBox2.y + solidBox2.height && solidBox1.getY() > solidBox2.y) {
                direction = "bottom";
            }
            if (solidBox1.getY() + solidBox1.getHeight() >= solidBox2.y && solidBox1.getY() + solidBox1.getHeight() < solidBox2.y + solidBox2.height) {
                direction = "top";
            }
        }
        return direction;
    }
}
