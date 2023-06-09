package com.pardodevelopers.goombagame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.pardodevelopers.goombagame.Screens.PlayScreen;

import play.user.PlayUser;

public class GoombaGame extends Game {
    public SpriteBatch batch;

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;

    public static PlayUser globalPlayUser;

    public GoombaGame(PlayUser playUser) {
        super();

        globalPlayUser = playUser;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
