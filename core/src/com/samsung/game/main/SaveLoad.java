package com.samsung.game.main;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad {

    String platform;
    KeyHandler keyH;

    public SaveLoad(String platform,KeyHandler keyH) {
        this.platform = platform;
        this.keyH = keyH;
    }

    public void save() {
        if (platform.equals("Desktop")) {
            try {
                File file = new File("save.dat");
                if (!file.exists()){
                    file.createNewFile();
                    System.out.println("save created");
                }

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file);

                DataStorage ds = new DataStorage();

                ds.x = keyH.getX();
                ds.y = keyH.getY();
                System.out.println("saving");

                objectOutputStream.writeObject(ds);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (platform.equals("Android")){

        }
    }

    public void load() {
        if (platform.equals("Desktop")) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file);

                DataStorage ds = (DataStorage) objectInputStream.readObject();

                keyH.setX(ds.x);
                keyH.setY(ds.y);

            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }else if (platform.equals("Android")){

        }
    }

}
