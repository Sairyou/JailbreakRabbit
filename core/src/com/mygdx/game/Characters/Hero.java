package com.mygdx.game.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.mygdx.game.MyGdxGame.PPM;

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
    private float speed = 2400;
    private float width = 32;
    private float height = 32;

    private World world;
    private Body b2body;



    public Hero(World world) {



        currentState = previousState = State.SOUTH;

        characterSpriteSheet = new Texture(Gdx.files.internal("face_w2_2d.png"));

        characterSouth = new TextureRegion(characterSpriteSheet,0,0,32,32);
        characterEast = new TextureRegion(characterSpriteSheet,0,32*2,32,32);
        characterNorth = new TextureRegion(characterSpriteSheet,0,32*3,32,32);
        characterWest = new TextureRegion(characterSpriteSheet,0,32,32,32);

        xmax = 640- characterSouth.getRegionWidth(); //640 is the size of the map this will need to be changed
        ymax = 640- characterSouth.getRegionHeight(); //same here

        this.world = world;
        defineHero(characterSouth.getRegionWidth(), characterSouth.getRegionHeight(), world);

    }

    public void defineHero(float width, float height, World world){
        BodyDef bdef = new BodyDef();
        bdef.position.set(x+width/2/PPM,y+height/2/PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        FixtureDef fdef =  new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2/PPM, height/2/PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);
        //shape.dispose();
    }
    public void update(float dt) {
        float xvel = 0;
        float yvel = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ){//&& x > 0+getTexture().getRegionWidth()/2) {
            xvel = -speed;
            previousState = currentState;
            currentState = State.WEST;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){//&& x < xmax+getTexture().getRegionWidth()/2){
            xvel = speed;
            previousState = currentState;
            currentState = State.EAST;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) ){//&&y<ymax+getTexture().getRegionHeight()/2) {
            yvel = speed;
            previousState = currentState;
            currentState = State.NORTH;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) ){//&&y>0+getTexture().getRegionHeight()/2){
            yvel = -speed;
            previousState = currentState;
            currentState = State.SOUTH;
        }
        b2body.setLinearVelocity(xvel,yvel);

        //very sloppy but... it stops the player
        if(   !(Gdx.input.isKeyPressed(Input.Keys.DOWN)||
                Gdx.input.isKeyPressed(Input.Keys.UP)||
                Gdx.input.isKeyPressed(Input.Keys.LEFT)||
                Gdx.input.isKeyPressed(Input.Keys.RIGHT)) ){
            b2body.setLinearVelocity(0,0);
        }

        x = b2body.getPosition().x;
        y = b2body.getPosition().y;

    }
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(getTexture(),b2body.getPosition().x,b2body.getPosition().y);
//        batch.draw(getTexture(),x-width/2,y-height/2); //ppm?
        batch.end();
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
