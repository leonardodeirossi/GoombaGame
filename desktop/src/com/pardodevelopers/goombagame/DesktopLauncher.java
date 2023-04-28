package com.pardodevelopers.goombagame;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.pardodevelopers.goombagame.GoombaGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);

		config.setTitle("Goomba's Adventure");
		config.setWindowSizeLimits(1200, 624, 9999, 9999);

		new Lwjgl3Application(new GoombaGame(), config);
	}
}
