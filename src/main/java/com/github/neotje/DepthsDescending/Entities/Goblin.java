package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.neotje.DepthsDescending.GamePlay.Combat;
import com.github.neotje.DepthsDescending.Sprites.GoblinSprite;

public class Goblin extends Enemy implements Combat {
    public Goblin(Coordinate2D location, int Attack, int Toughness) {
        super(location, Attack, Toughness, 500);
    }

    @Override
    public void onAttack(Player player) {
        player.doeDamage(this.attack);
    }

    @Override
    protected void setupEntities() {
        GoblinSprite goblin = new GoblinSprite(new Coordinate2D(0, 0), "textures/goblin.png");
        goblin.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(goblin);
    }

    @Override
    public void doeDamage(int attackStrength) {
        this.toughness -= attackStrength;
    }
}
