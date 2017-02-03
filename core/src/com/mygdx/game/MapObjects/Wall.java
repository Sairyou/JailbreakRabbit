package com.mygdx.game.MapObjects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.mygdx.game.MyGdxGame.PPM;

/**
 * Created by Clifford Hill on 1/25/2017.
 */


public class Wall {

    private Body b2body;
    private int x;
    private int y;

    public Wall(){
        x = 0;
        y = 0;
    }
    public Wall(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void definewall(float width, float height, World world){
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
}
