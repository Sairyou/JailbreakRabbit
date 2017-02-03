package com.mygdx.game.Characters;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by Clifford Hill on 2/1/2017.
 */

public class B2DSprite {
    protected Body body;
    protected float width;
    protected float height;

    public B2DSprite(Body body){
        this.body = body;
    }
}
