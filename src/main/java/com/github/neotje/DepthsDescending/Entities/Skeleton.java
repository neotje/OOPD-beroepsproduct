package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;

public class Skeleton extends Enemy{
    public Skeleton(Coordinate2D location, int Attack, int Toughness) {
        super(location, Attack, Toughness);
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    protected void setupEntities() {

    }

    @Override
    public void doeDamage(int attackStrength) {

    }
}
