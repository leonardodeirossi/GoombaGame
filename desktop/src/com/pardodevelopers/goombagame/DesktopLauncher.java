package com.pardodevelopers.goombagame;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.pardodevelopers.goombagame.GoombaGame;

import play.user.PlayUser;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {
        PlayUser playUser;

        try {
            String playLoginToken = System.getProperty("playLoginToken");
            System.out.println(playLoginToken);

            if (!playLoginToken.equals("")) {
                playUser = new PlayUser(playLoginToken);
            } else {
                playUser = new PlayUser(true);
            }
        } catch (Exception e) {
            playUser = new PlayUser(true);
        }

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);

        config.setTitle("Goomba's Adventure");
        config.setWindowSizeLimits(1200, 624, 9999, 9999);

        new Lwjgl3Application(new GoombaGame(playUser), config);
    }
}
