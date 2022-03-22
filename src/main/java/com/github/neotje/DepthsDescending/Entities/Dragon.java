package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.neotje.DepthsDescending.Sprites.DragonHead;

public class Dragon extends Enemy{
    Dragon(Coordinate2D location, int Attack, int Toughness) {
        super(location, Attack, Toughness);
    }

    @Override
    protected void setupEntities(){
        var dragonHead = new DragonHead(new Coordinate2D(20, 20), "");
    }
}
