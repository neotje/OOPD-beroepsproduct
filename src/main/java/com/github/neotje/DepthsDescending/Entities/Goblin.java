package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.GamePlay.Combat;
import com.github.neotje.DepthsDescending.Sprites.GoblinSprite;
import com.github.neotje.DepthsDescending.Sprites.Icons.Icons;
import javafx.scene.paint.Color;

public class Goblin extends Enemy implements Combat {
    private HealthBar healthBar;

    public Goblin(Coordinate2D location, int Attack, int Toughness, DepthsDescending depthsDescending) {
        super(location, Attack, Toughness, 500, depthsDescending);
    }

    @Override
    public void onAttack(Player player) {
        player.doeDamage(this.attack);
    }

    @Override
    protected void setupEntities() {
        GoblinSprite goblin = new GoblinSprite(new Coordinate2D(0, 0), "textures/goblin.png");
        goblin.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var toughnessIcon = new Icons("textures/shield.png", new Coordinate2D(0, -40));
        toughnessIcon.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        //addEntity(toughnessIcon);

        healthBar = new HealthBar(new Coordinate2D(0,-20), this.toughness, this.attack, depthsDescending);
        addEntity(healthBar);
        addEntity(goblin);
    }

    @Override
    public void doeDamage(int attackStrength) {
        this.toughness -= attackStrength;

        healthBar.updateStats(this.toughness, this.attack);

        if (this.toughness <= 0) {
            depthsDescending.player1.setEnemiesSlain();
            depthsDescending.player1.setAttack(1);
            depthsDescending.player1.setBaseToughness(1);
            this.remove();
        }
    }
}
