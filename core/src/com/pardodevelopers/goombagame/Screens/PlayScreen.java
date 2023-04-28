package com.pardodevelopers.goombagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pardodevelopers.goombagame.GoombaGame;
import com.pardodevelopers.goombagame.Scenes.Hud;

public class PlayScreen implements Screen {
    private GoombaGame game;

    private OrthographicCamera gameCamera;
    private Viewport gameViewPort;
    private Hud currentGameHud;

    public PlayScreen(GoombaGame game) {
        this.game = game;

        gameCamera = new OrthographicCamera();
        gameViewPort = new FitViewport(GoombaGame.V_WIDTH, GoombaGame.V_HEIGHT, gameCamera);

        currentGameHud = new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(currentGameHud.hudStage.getCamera().combined);
        currentGameHud.hudStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gameViewPort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
