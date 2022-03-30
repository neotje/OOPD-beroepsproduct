package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.GamePlay.OnEndButton;
import com.github.neotje.DepthsDescending.Sprites.Buttons.Button;
import javafx.scene.paint.Color;
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
        depthsDescending.setEndTime();
    }

    @Override
    public void setupEntities() {
        // score in title

        var titleText = new TextEntity(new Coordinate2D(0,0), "Score");
        titleText.setFill(Color.WHITE);
        titleText.setFont(depthsDescending.ringbearerTitle);
        addEntity(titleText);
        // puts out the final time on
        var timeText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2), "Time played " + depthsDescending.getTimePlayedFormatted());
        timeText.setFill(Color.WHITE);
        timeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        timeText.setFont(depthsDescending.ringbearerStats);
        addEntity(timeText);

        // Items collected
        /*
        var itemsCollected = new TextEntity(new Coordinate2D(getWidth()/2, getHeight() + 160), "Total Items " + enemies);
        itemsCollected.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        itemsCollected.setFill(Color.WHITE);
        itemsCollected.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 20));
        addEntity(itemsCollected);
        */

        // Enemies slain
        var enemiesSlain = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2 + 40),  "Enemies Slain " + depthsDescending.player1.getEnemiesSlain());
        enemiesSlain.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemiesSlain.setFill(Color.WHITE);
        enemiesSlain.setFont(depthsDescending.ringbearerStats);
        addEntity(enemiesSlain);

        // Total end HP

        var totalToughness = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2 + 80),  "Total Toughness " + depthsDescending.player1.getBaseToughness());
        totalToughness.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalToughness.setFill(Color.WHITE);
        totalToughness.setFont(depthsDescending.ringbearerStats);
        addEntity(totalToughness);

        // Total Strength

        var totalStrength = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2 + 120),  "Total Attack " + depthsDescending.player1.getAttack());
        totalStrength.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalStrength.setFill(Color.WHITE);
        totalStrength.setFont(depthsDescending.ringbearerStats);
        addEntity(totalStrength);

        // button to get to start screen
        Button endButton = new Button(new Coordinate2D(getWidth()/2, getHeight()/2 + 210), depthsDescending, 0, "Return to home", new OnEndButton());
        endButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endButton);
    }
}
