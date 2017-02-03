package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Characters.Hero;
import com.mygdx.game.GameScreens.DungeonScreen;
import com.mygdx.game.Tools.GameStateManager;

public class MyGdxGame extends ApplicationAdapter {
	public SpriteBatch batch;
	Texture img; //???
	private GameStateManager gsm;
	private OrthographicCamera cam;
	public static final int V_WIDTH = 1900;
	public static final int V_HEIGHT = 1200;
	public static final float PPM = 100; //pixles per meter

	@Override
	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false,V_WIDTH,V_HEIGHT);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gsm = new GameStateManager(this);
		gsm.push(new DungeonScreen(gsm));
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.render(batch);
		gsm.update(Gdx.graphics.getDeltaTime());
		batch.begin();
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
