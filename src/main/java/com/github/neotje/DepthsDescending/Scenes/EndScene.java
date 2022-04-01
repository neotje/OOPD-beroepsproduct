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
        var timeText = new TextEntity(new Coordinate2D(130, 150), "Time played ");
        timeText.setFill(Color.WHITE);
        timeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        timeText.setFont(depthsDescending.ringbearerHeader);

        var timeTimeText = new TextEntity(new Coordinate2D(280, 147), depthsDescending.getTimePlayedFormatted());
        timeTimeText.setFill(Color.WHITE);
        timeTimeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        timeTimeText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 35));
        addEntity(timeTimeText);
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
        var enemiesSlain = new TextEntity(new Coordinate2D(120, 210),  "Enemies Slain");
        enemiesSlain.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemiesSlain.setFill(Color.WHITE);
        enemiesSlain.setFont(depthsDescending.ringbearerStats);

        var enemiesSlainText = new TextEntity(new Coordinate2D(115, 235),  "" + depthsDescending.player1.getEnemiesSlain());
        enemiesSlainText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemiesSlainText.setFill(Color.WHITE);
        enemiesSlainText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 15));

        addEntity(enemiesSlainText);
        addEntity(enemiesSlain);

        // Total end HP

        var totalToughness = new TextEntity(new Coordinate2D(115, 340),  "Total Toughness ");
        totalToughness.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalToughness.setFill(Color.WHITE);
        totalToughness.setFont(depthsDescending.ringbearerStats);

        var totalToughnessText = new TextEntity(new Coordinate2D(115, 360),  "" + depthsDescending.player1.getBaseToughness());
        totalToughnessText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalToughnessText.setFill(Color.WHITE);
        enemiesSlainText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 15));

        addEntity(totalToughnessText);
        addEntity(totalToughness);

        // Total Strength

        var totalStrength = new TextEntity(new Coordinate2D(280, 265),  "Total Attack");
        totalStrength.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalStrength.setFill(Color.WHITE);
        totalStrength.setFont(depthsDescending.ringbearerStats);

        var totalStrengthText = new TextEntity(new Coordinate2D(280, 295),  "" + depthsDescending.player1.getAttack());
        totalStrengthText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        totalStrengthText.setFill(Color.WHITE);
        totalStrengthText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 15));

        addEntity(totalStrengthText);
        addEntity(totalStrength);

        // button to get to start screen
        Button endButton = new Button(new Coordinate2D(getWidth()/2, getHeight()/2 + 210), depthsDescending, 0, "Return to home", new OnEndButton());
        endButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endButton);
    }
}
