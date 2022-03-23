package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Enemy extends DynamicCompositeEntity implements Combat, Collider, Collided {
    int attack;
    int toughness;

     Enemy(Coordinate2D location, int attack, int toughness){
        super(location);
        this.attack = attack;
        this.toughness = toughness;
    }
}
