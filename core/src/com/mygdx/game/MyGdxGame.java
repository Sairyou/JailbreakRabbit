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
	Hero hero;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gsm = new GameStateManager();
		gsm.push(new DungeonScreen(gsm));
		hero = new Hero();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);

//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();

		hero.render();

		gsm.render(batch);
		gsm.update(Gdx.graphics.getDeltaTime());
		batch.begin();
		batch.draw(hero.characterForward,(int)hero.x,(int)hero.y);
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
