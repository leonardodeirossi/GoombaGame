package com.pardodevelopers.goombagame.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pardodevelopers.goombagame.GoombaGame;

public class Hud {
    public Stage hudStage;
    private Viewport hudViewport;

    private Integer currentWorldTimer;
    private float currentTimeCount;

    private Integer currentWorldScore;

    Label countDownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label goombaLabel;

    public Hud(SpriteBatch hudSpriteBatch) {
        currentWorldTimer = 300;
        currentTimeCount = 0;
        currentWorldScore = 0;

        hudViewport = new FitViewport(GoombaGame.V_WIDTH, GoombaGame.V_HEIGHT, new OrthographicCamera());
        hudStage = new Stage(hudViewport, hudSpriteBatch);

        Table gameTable = new Table();
        gameTable.top();

        gameTable.setFillParent(true);

        this.countDownLabel = new Label(String.format("%03d", currentWorldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.scoreLabel = new Label(String.format("%06d", currentWorldScore), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.worldLabel = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.goombaLabel = new Label("GOOMBA", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        gameTable.add(goombaLabel).expandX().padTop(10);
        gameTable.add(worldLabel).expandX().padTop(10);
        gameTable.add(timeLabel).expandX().padTop(10);

        gameTable.row();

        gameTable.add(scoreLabel).expandX();
        gameTable.add(levelLabel).expandX();
        gameTable.add(countDownLabel).expandX();

        hudStage.addActor(gameTable);
    }
}
