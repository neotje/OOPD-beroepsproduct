package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Sprites.SkeletonSprite;

public class Skeleton extends Enemy{
    /**
     * @author Brian Vriezen
     * @param location begin locatie
     * @param Attack aanval sterkte
     * @param Toughness aantal levens
     * @param depthsDescending game object
     */
    public Skeleton(Coordinate2D location, int Attack, int Toughness, DepthsDescending depthsDescending) {
        super(location, Attack, Toughness, 1000, depthsDescending);
    }

    @Override
    public void onAttack(Player player) {
        player.doeDamage(this.attack);
    }

    @Override
    protected void setupEntities() {
        SkeletonSprite skeleton = new SkeletonSprite(new Coordinate2D(0, 0), "textures/skeleton.png");
        skeleton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        healthBar = new HealthBar(new Coordinate2D(0,-35), this.toughness, this.attack, depthsDescending);
        addEntity(healthBar);

        addEntity(skeleton);
    }

    @Override
    public void doeDamage(int attackStrength) {
        this.toughness -= attackStrength;

        healthBar.updateStats(this.toughness, this.attack);

        if (this.toughness <= 0) {
            depthsDescending.keyShards++;
            System.out.println("You found a keyshard!");
            if(depthsDescending.keyShards == 2){
                System.out.println("You made a key!");
            }
            depthsDescending.player1.setEnemiesSlain();
            depthsDescending.player1.setAttack(2);
            depthsDescending.player1.setBaseToughness(2);
            depthsDescending.player1.doeDamage(this.attack/2);
            this.remove();
        }
    }
}
