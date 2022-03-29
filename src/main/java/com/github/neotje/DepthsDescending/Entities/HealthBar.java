package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Sprites.Icons.Icons;
import javafx.scene.paint.Color;

public class HealthBar extends DynamicCompositeEntity {
    private int toughness;
    private int attack;

    private TextEntity toughnessText;
    private TextEntity attackText;

    private DepthsDescending depthsDescending;

    public HealthBar(Coordinate2D initialLocation, int toughness, int attack, DepthsDescending depthsDescending) {
        super(initialLocation);

        this.toughness = toughness;
        this.attack = attack;
        this.depthsDescending = depthsDescending;

        setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    }

    @Override
    protected void setupEntities() {
        var toughnessIcon = new Icons("textures/shield.png", new Coordinate2D(0, 0));
        addEntity(toughnessIcon);
        toughnessText = new TextEntity(new Coordinate2D(20, 0));

        var attackIcon = new Icons("textures/sword.png", new Coordinate2D(40, 0));
        addEntity(attackIcon);
        attackText = new TextEntity(new Coordinate2D(60, 0));

        toughnessText.setFill(Color.WHITE);
        attackText.setFill(Color.WHITE);

        toughnessText.setFont(depthsDescending.ringbearerStats);

        updateStats(this.toughness, this.attack);

        addEntity(toughnessText);
        addEntity(attackText);
    }

    public void updateStats(int toughness, int attack) {
        this.toughness = toughness;
        this.attack = attack;

        toughnessText.setText("" + toughness);
        attackText.setText("" + attack);
    }
}
