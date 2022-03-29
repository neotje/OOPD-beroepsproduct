package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.neotje.DepthsDescending.DepthsDescending;

public class DragonClaw extends Enemy{
    private String resource;

    public DragonClaw(Coordinate2D location, int attack, int toughness, String resource, DepthsDescending depthsDescending){
        super(location, attack, toughness, 2000, depthsDescending);
        this.resource = resource;
    }

    @Override
    protected void setupEntities() {
        var dragonClaw = new com.github.neotje.DepthsDescending.Sprites.DragonClaw(new Coordinate2D(0, 0) , resource);
        dragonClaw.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(dragonClaw);
    }

    @Override
    public void onAttack(Player player) {
        player.doeDamage(this.attack);
    }

    @Override
    public void doeDamage(int attackStrength) {

    }
}
