package com.samsung.game.main.entity;

import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.KeyHandler;
import com.samsung.game.main.entity.stuff.Bullet;
import com.samsung.game.main.entity.stuff.Bullets;
import com.samsung.game.main.world.Map;
import com.samsung.game.main.world.Tile;

public class SolidArea {

    private Array<Tile> tiles;
    private KeyHandler keyH;
    private Player player;
    private Bullets bullets;
    private NPCs npcs;
    private boolean collisionOn = false;
    private int tilesInCollisionArea;

    public SolidArea(Map map, KeyHandler keyH, Player player, Bullets bullets, NPCs npcs) {
        tiles = map.getTiles();
        this.keyH = keyH;
        this.player = player;
        this.bullets=bullets;
        this.npcs=npcs;
    }

    public void render() {
        for (Tile tile : tiles) {
            if (tile.collision()) {
                tilesInCollisionArea++;
                playerVisible(tile);
                for (Bullet bullet : bullets.getBullets()) {
                    bulletCollision(bullet,tile);
                }
                for (NPC npc : npcs.getNPCs()) {
                    NPCVisible(npc, tile);
                }
            }
        }
        if (tilesInCollisionArea == 0) {
            collisionOn = false;
            keyH.setCollisionLeft(false);
            keyH.setCollisionRight(false);
            keyH.setCollisionDown(false);
            keyH.setCollisionUp(false);
        }
        tilesInCollisionArea = 0;
    }
    private void playerVisible(Tile tile) {
        if (player.getSolidBox().overlaps(tile.getSolidBox())) {
            collisionPlayer(tile);
        }else{
            tilesInCollisionArea--;
        }
    }

    private void collisionPlayer(Tile tile) {

        if (keyH.getY() <= tile.getY() + tile.getTileSize()-10 && keyH.getY() + player.getHeight() > tile.getY()+10) {
            if (keyH.getX() <= tile.getX() + tile.getTileSize() && keyH.getX() > tile.getX()) {
                System.out.println("Left");
                keyH.setCollisionLeft(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionLeft(false);
            if (keyH.getX() + player.getWidth() >= tile.getX() && keyH.getX() + player.getWidth() < tile.getX() + tile.getTileSize()) {
                System.out.println("Right");
                keyH.setCollisionRight(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionRight(false);
        } else if(!collisionOn) {
            keyH.setCollisionLeft(false);
            keyH.setCollisionRight(false);
        }


        if (keyH.getX() <= tile.getX() + tile.getTileSize()-10 && keyH.getX() + player.getWidth() > tile.getX()+10) {
            if (keyH.getY() <= tile.getY() + tile.getTileSize() && keyH.getY() > tile.getY()) {
                System.out.println("Down");
                keyH.setCollisionDown(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionDown(false);
            if (keyH.getY() + player.getHeight() >= tile.getY() && keyH.getY() + player.getHeight() < tile.getY() + tile.getTileSize()) {
                System.out.println("Up");
                keyH.setCollisionUp(true);
                collisionOn=true;
            } else if(!collisionOn) keyH.setCollisionUp(false);
        } else if(!collisionOn) {
            keyH.setCollisionDown(false);
            keyH.setCollisionUp(false);
        }
    }

    private void bulletCollision(Bullet bullet, Tile tile) {
        if (bullet.getSolidBox().overlaps(tile.getSolidBox())) {
            bullet.setFinish(true);
        }
    }

    private void NPCVisible(NPC npc, Tile tile) {
        if (npc.getSolidBox().overlaps(tile.getSolidBox())) {
            collisionNPCwithTile(npc, tile);
            npc.changeDirection();
        }
        if(npc.getSolidBox().overlaps(player.getSolidBox())){
            collisionNPCwithPlayer(npc);
            npc.changeDirection();
        }
        for (Bullet bullet : bullets.getBullets()) {
            if(npc.getSolidBox().overlaps(bullet.getSolidBox()) && !bullet.getFinish() && !npc.getDead()){
                npc.setDead(true);
                bullet.setFinish(true);
            }
        }
    }

    private void collisionNPCwithTile(NPC npc,Tile tile) {

        if (npc.getY() <= tile.getY() + tile.getTileSize()-10 && npc.getY() + npc.getHeight() > tile.getY()+10) {
            if (npc.getX() <= tile.getX() + tile.getTileSize() && npc.getX() > tile.getX()) {
                npc.setDirectionBAN("left");
                npc.setX(npc.getX()+2);
            }
            if (npc.getX() + npc.getWidth() >= tile.getX() && npc.getX() + npc.getWidth() < tile.getX() + tile.getTileSize()) {
                npc.setDirectionBAN("right");
                npc.setX(npc.getX()-2);
            }
        }

        if (npc.getX() <= tile.getX() + tile.getTileSize()-10 && npc.getX() + npc.getWidth() > tile.getX()+10) {
            if (npc.getY() <= tile.getY() + tile.getTileSize() && npc.getY() > tile.getY()) {
                npc.setDirectionBAN("bottom");
                npc.setY(npc.getY()+2);
            }
            if (npc.getY() + npc.getHeight() >= tile.getY() && npc.getY() + npc.getHeight() < tile.getY() + tile.getTileSize()) {
                npc.setDirectionBAN("top");
                npc.setY(npc.getY()-2);
            }
        }
    }
    private void collisionNPCwithPlayer(NPC npc) {

        if (npc.getY() <= keyH.getY() + player.getHeight()-10 && npc.getY() + npc.getHeight() > keyH.getY()+10) {
            if (npc.getX() <= keyH.getX() + player.getWidth() && npc.getX() > keyH.getX()) {
                npc.setDirectionBAN("left");
            }
            if (npc.getX() + npc.getWidth() >= keyH.getX() && npc.getX() + npc.getWidth() < keyH.getX() + player.getWidth()) {
                npc.setDirectionBAN("right");
            }
        }

        if (npc.getX() <= keyH.getX() + player.getWidth()-10 && npc.getX() + npc.getWidth() > keyH.getX()+10) {
            if (npc.getY() <= keyH.getY() + player.getHeight() && npc.getY() > keyH.getY()) {
                npc.setDirectionBAN("bottom");
            }
            if (npc.getY() + npc.getHeight() >= keyH.getY() && npc.getY() + npc.getHeight() < keyH.getY() + player.getHeight()) {
                npc.setDirectionBAN("top");
            }
        }
    }
}
