package com.mygdx.game.GameModels;

import com.mygdx.game.Characters.Hero;

/**
 * Holds all the data for the Dungeon Class
 * Created by Clifford Hill on 1/24/2017.
 */

public class DungeonModel {
    Hero hero;
    public DungeonModel(){
        hero = new Hero();
    }
    public void update(float dt){
        hero.update(dt);
    }
    public Hero getHero(){
        return hero;
    }
}
