package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gsm = new GameStateManager();
		gsm.push(new DungeonScreen(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);

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
