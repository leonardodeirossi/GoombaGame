package com.pardodevelopers.goombagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

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

    private TmxMapLoader gameMapLoader;
    private TiledMap gameTiledMap;
    private OrthoCachedTiledMapRenderer gameMapRender;

    public PlayScreen(GoombaGame game) {
        this.game = game;

        gameCamera = new OrthographicCamera();
        gameViewPort = new FitViewport(GoombaGame.V_WIDTH, GoombaGame.V_HEIGHT, gameCamera);

        currentGameHud = new Hud(game.batch);

        gameMapLoader = new TmxMapLoader();
        gameTiledMap = gameMapLoader.load("level1.tmx");
        gameMapRender = new OrthoCachedTiledMapRenderer(gameTiledMap);

        gameCamera.position.set(gameViewPort.getWorldWidth() / 2, gameViewPort.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    public void handleInput(float deltaTime) {
        if (Gdx.input.isTouched())
            gameCamera.position.x += 100 * deltaTime;
    }

    public void update(float deltaTime) {
        handleInput(deltaTime);
        gameCamera.update();
        gameMapRender.setView(gameCamera);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameMapRender.render();

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
