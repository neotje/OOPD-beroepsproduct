package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
//import com.github.neotje.DepthsDescending.Sprites.GoblinSprite;

public class Goblin extends Enemy implements Combat{
    public Goblin(Coordinate2D location, int Attack, int Toughness) {
        super(location, Attack, Toughness);
    }

    @Override
    protected void setupEntities() {
        //addEntity(new GoblinSprite(new Coordinate2D(0, 0), new Size(20, 20)));
    }

    @Override
    public void doeDamage(int attackStrength) {
        this.toughness -= attackStrength;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        ((Combat) collidingObject).doeDamage(this.attack);
    }
}