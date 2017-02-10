package com.mygdx.game.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import static com.mygdx.game.MyGdxGame.PPM;

/**
 * Created by Clifford Hill on 2/1/2017.
 */

public class B2DSprite {
    protected Body body;
    protected Texture texture;
    protected float width;
    protected float height;


    public B2DSprite(Body body){
        this.body = body;
    }
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(texture, (body.getPosition().x * PPM - width / 2),
                (int) (body.getPosition().y * PPM - height / 2));
        sb.end();
    }
}
