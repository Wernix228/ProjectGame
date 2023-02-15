package com.samsung.game.main;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import java.awt.Dimension;
import java.awt.Toolkit;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

	static float scaleW;
	static float scaleY;

	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		scaleW = 1520f / screenSize.width;
		scaleY = 880f / screenSize.height;

		config.setWindowedMode((int) (screenSize.width * scaleW), (int) (screenSize.height * scaleY));
		config.setForegroundFPS(60);
		config.setTitle("Game");

		new Lwjgl3Application(new Game(), config);
	}
}
