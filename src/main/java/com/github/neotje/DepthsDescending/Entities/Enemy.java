package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Enemy extends DynamicCompositeEntity {
    int Attack;
    int Toughness;

     Enemy(Coordinate2D location, int Attack, int Toughness){
        super(location);
        this.Attack = Attack;
        this.Toughness = Toughness;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
