package com.mygdx.game.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by veriwind on 1/24/17.
 */

public class Hero {
    Texture characterSpriteSheet;
    private TextureRegion characterForward;
    private float x = 0;
    private float xmax;
    private float y = 0;
    private float ymax;
    private float speed = 500.0f;


    public Hero() {
        characterSpriteSheet = new Texture(Gdx.files.internal("face_w2_2d.png"));
        characterForward = new TextureRegion(characterSpriteSheet,0,0,32,32);
        xmax = 640-characterForward.getRegionWidth(); //640 is the size of the map this will need to be changed
        ymax = 640-characterForward.getRegionHeight(); //same here

    }

    public void update(float dt) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)&& x>0)
            x -= dt * speed;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&& x<xmax)
            x += dt * speed;

        if(Gdx.input.isKeyPressed(Input.Keys.UP)&&y<ymax)
            y += dt * speed;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)&&y>0)
            y -= dt * speed;
    }
    public TextureRegion getCharacterForward(){
        return characterForward;
    }
    public float getPosX(){
        return x;
    }
    public float getPosY(){
        return y;
    }

}
