package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.neotje.DepthsDescending.Sprites.SkeletonSprite;

public class Skeleton extends Enemy{
    public Skeleton(Coordinate2D location, int Attack, int Toughness) {
        super(location, Attack, Toughness, 1000);
    }

    @Override
    public void onAttack(Player player) {
        player.doeDamage(this.attack);
    }

    @Override
    protected void setupEntities() {
        SkeletonSprite skeleton = new SkeletonSprite(new Coordinate2D(0, 0), "textures/skeleton.png");
        skeleton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(skeleton);
    }

    @Override
    public void doeDamage(int attackStrength) {

    }

    @Override
    public void onCollision(Collider collider) {

    }
}
