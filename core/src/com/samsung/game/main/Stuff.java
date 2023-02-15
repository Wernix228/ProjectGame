package com.samsung.game.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.main.entity.Entity;
import com.samsung.game.main.entity.Item;

public class Stuff {
    public static Array<Item> items = new Array<Item>();
    public Stuff(){
        Item item = new Item(-200,-200,"textures/tiles/001.png",2);
        items.add(item);
    }

    public void render(Entity entity, OrthographicCamera camera){
        for (Item item : items) {
            item.render();
            item.getBatch().setProjectionMatrix(camera.combined);
//            if(entity.getTriger().intersects(item.getTriger())){
//                System.out.println(1);
//                items.removeValue(item, false);
//                item=null;
//            }
        }
    }
}
