package com.mygdx.game.GameModels;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Characters.Hero;
import com.mygdx.game.MapObjects.Wall;

import java.util.ArrayList;

/**
 * Holds all the data for the Dungeon Class
 * Created by Clifford Hill on 1/24/2017.
 */

public class DungeonModel {
    private Hero hero;
    private ArrayList<Wall> walls;

    public DungeonModel(World world){
        hero = new Hero(world);
        walls = new ArrayList<Wall>();
        //
    }
    public void update(float dt){
        hero.update(dt);
    }
    public Hero getHero(){
        return hero;
    }
}
