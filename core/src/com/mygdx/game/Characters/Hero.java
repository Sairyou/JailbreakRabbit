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
    public TextureRegion characterForward;
    public float x = 0;
    public float y = 0;
    public float speed = 500.0f;


    public Hero() {
        characterSpriteSheet = new Texture(Gdx.files.internal("face_w2_2d.png"));
        characterForward = new TextureRegion(characterSpriteSheet,0,0,32,32);
    }

    public void update(float dt) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            x -= dt * speed;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            x += dt * speed;

        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            y += dt * speed;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            y -= dt * speed;
    }
    public float getPosX(){
        return x;
    }
    public float getPosY(){
        return y;
    }

}
