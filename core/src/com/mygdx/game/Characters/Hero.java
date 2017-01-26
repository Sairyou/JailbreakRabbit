package com.mygdx.game.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by veriwind on 1/24/17.
 */

public class Hero {
    Texture characterSpriteSheet;
    public enum State{NORTH, SOUTH, EAST, WEST};
    public State currentState;
    public State previousState;
    private TextureRegion characterSouth;
    private TextureRegion characterNorth;
    private TextureRegion characterWest;
    private TextureRegion characterEast;

    private float x = 0;
    private float xmax;
    private float y = 0;
    private float ymax;
    private float speed = 500.0f;

    private World world;
    private Body b2body;



    public Hero() {

        currentState = previousState = State.SOUTH;

        characterSpriteSheet = new Texture(Gdx.files.internal("face_w2_2d.png"));
        int spritesize = 32;
        characterSouth = new TextureRegion(characterSpriteSheet,0,0,32,32);
        characterEast = new TextureRegion(characterSpriteSheet,0,spritesize*2,32,32);
        characterNorth = new TextureRegion(characterSpriteSheet,0,spritesize*3,32,32);
        characterWest = new TextureRegion(characterSpriteSheet,0,spritesize,32,32);

        xmax = 640- characterSouth.getRegionWidth(); //640 is the size of the map this will need to be changed
        ymax = 640- characterSouth.getRegionHeight(); //same here

    }
    public void defineHero(World world){

    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x > 0) {
            x -= dt * speed;
            previousState = currentState;
            currentState = State.WEST;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x < xmax){
            x += dt * speed;
            previousState = currentState;
            currentState = State.EAST;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)&&y<ymax) {
            y += dt * speed;
            previousState = currentState;
            currentState = State.NORTH;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)&&y>0){
            y -= dt * speed;
            previousState = currentState;
            currentState = State.SOUTH;
        }
        //update facing direction.
        switch(currentState){
            case NORTH:

        }
    }
    public TextureRegion getTexture(){
        switch(currentState){
            case NORTH:
                return characterNorth;
            case SOUTH:
                return characterSouth;
            case EAST:
                return characterEast;
            case WEST:
                return characterWest;
            default:
                return characterSouth;
        }
    }
    public TextureRegion getCharacterSouth(){
        return characterSouth;
    }
    public float getPosX(){
        return x;
    }
    public float getPosY(){
        return y;
    }

}
