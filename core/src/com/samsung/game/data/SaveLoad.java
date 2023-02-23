package com.samsung.game.data;


import com.samsung.game.main.KeyHandler;

import java.io.*;

public class SaveLoad {

    String platform;
    KeyHandler keyH;

    File file = new File("save.dat");

    public SaveLoad(String platform, KeyHandler keyH) {
        this.platform = platform;
        this.keyH = keyH;
    }

    public void save() {
        if (platform.equals("Desktop")) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                    System.out.println("save created");
                }

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

                DataStorage ds = new DataStorage();

                ds.x = keyH.getX();
                ds.y = keyH.getY();
                System.out.println("saving");

                objectOutputStream.writeObject(ds);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (platform.equals("Android")) {

        }
    }

    public void load() {
        if (platform.equals("Desktop")) {
            if (file.exists()) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

                    DataStorage ds = (DataStorage) objectInputStream.readObject();

                    keyH.setX(ds.x);
                    keyH.setY(ds.y);

                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            } else if (platform.equals("Android")) {

            }
        }
    }

}
