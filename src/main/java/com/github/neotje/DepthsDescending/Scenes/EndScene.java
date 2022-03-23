package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Sprites.Buttons.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EndScene extends StaticScene {
    public DepthsDescending depthsDescending;
    private int enemies;

    public EndScene(DepthsDescending depthsDescending){
        this.depthsDescending = depthsDescending;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("background/endScene.png");
        enemies = 40;
    }

    @Override
    public void setupEntities() {
        // puts out the final time on
        var timeText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2), "/*getTime()*/");
        timeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        timeText.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 40));
        addEntity(timeText);

        // Items collected

        var itemsCollected = new TextEntity(new Coordinate2D(getWidth()/2, getHeight() + 160), "Total Items: " + enemies);
        itemsCollected.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        itemsCollected.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 20));
        addEntity(itemsCollected);

        // Enemies slain
        var enemiesSlain = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2 + 40),  "Enemies Slain: " + enemies);
        enemiesSlain.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemiesSlain.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 20));
        addEntity(enemiesSlain);

        // Total end HP

        var totalHP = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2 + 80),  "Total HP: " + enemies);
        totalHP.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalHP.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 20));
        addEntity(totalHP);

        // Total Strength

        var totalStrength = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2 + 120),  "Total Strength: " + enemies);
        totalStrength.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalStrength.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 20));
        addEntity(totalStrength);

        // button to get to start screen
        Button endButton = new Button(new Coordinate2D(getWidth()/2, getHeight()/2 + 210), depthsDescending, 0, "Return to home");
        endButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endButton);
    }
}
