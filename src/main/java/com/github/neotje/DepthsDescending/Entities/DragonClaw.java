package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Sprites.DragonClawSprite;

public class DragonClaw extends Enemy{
    private String resource;
    private Dragon dragon;

    /**
     * @author Brian Vriezen
     * @param location begin locatie
     * @param attack aanval sterkte
     * @param toughness aantal levens
     * @param resource locatie van het plaatje
     * @param depthsDescending game object
     * @param dragon dragon object
     */
    public DragonClaw(Coordinate2D location, int attack, int toughness, String resource, DepthsDescending depthsDescending, Dragon dragon){
        super(location, attack, toughness, 2000, depthsDescending);
        this.resource = resource;
        this.dragon = dragon;
    }

    @Override
    protected void setupEntities() {
        var dragonClaw = new DragonClawSprite(new Coordinate2D(0, 0) , resource);
        dragonClaw.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(dragonClaw);
    }

    @Override
    public void onAttack(Player player) {
        player.doeDamage(this.attack);
    }

    @Override
    public void doeDamage(int attackStrength) {
        this.toughness -= attackStrength;

        if (this.toughness <= 0) {
            dragon.toughness = dragon.toughness/2;
            dragon.attack = dragon.attack/2;
            System.out.println("dragon - attack: " + dragon.getAttack() + " toughness: " + dragon.getToughness());
            this.remove();
        }
    }
}
