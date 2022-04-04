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
    private DepthsDescending depthsDescending;

    public EndScene(DepthsDescending depthsDescending){
        this.depthsDescending = depthsDescending;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("background/endScene.png");
        depthsDescending.setMusic("sound/win_screen.mp3");
        depthsDescending.setEndTime();
    }

    @Override
    public void setupEntities() {

        // title text
        var titleText = new TextEntity(new Coordinate2D(0,0), "Score");
        titleText.setFill(Color.WHITE);
        titleText.setFont(depthsDescending.ringbearerTitle);
        addEntity(titleText);

        // puts out the final time on
        var timeText = new TextEntity(new Coordinate2D(130, 150), "Time played ");
        timeText.setFill(Color.WHITE);
        timeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        timeText.setFont(depthsDescending.ringbearerHeader);

        var realTimeText = new TextEntity(new Coordinate2D(280, 147), depthsDescending.getTimePlayedFormatted());
        realTimeText.setFill(Color.WHITE);
        realTimeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        realTimeText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 35));
        addEntity(realTimeText);
        addEntity(timeText);

        // Enemies slain
        var enemiesSlain = new TextEntity(new Coordinate2D(120, 210),  "Enemies Slain");
        enemiesSlain.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemiesSlain.setFill(Color.WHITE);
        enemiesSlain.setFont(depthsDescending.ringbearerStats);

        var enemiesSlainTotal = new TextEntity(new Coordinate2D(115, 235),  "" + depthsDescending.player1.getEnemiesSlain());
        enemiesSlainTotal.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemiesSlainTotal.setFill(Color.WHITE);
        enemiesSlainTotal.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 15));

        addEntity(enemiesSlainTotal);
        addEntity(enemiesSlain);

        // Total end HP

        var toughnessText = new TextEntity(new Coordinate2D(115, 340),  "Total Toughness ");
        toughnessText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        toughnessText.setFill(Color.WHITE);
        toughnessText.setFont(depthsDescending.ringbearerStats);

        var toughnessTotal = new TextEntity(new Coordinate2D(115, 360),  "" + depthsDescending.player1.getBaseToughness());
        toughnessTotal.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        toughnessTotal.setFill(Color.WHITE);
        toughnessTotal.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 15));

        addEntity(toughnessText);
        addEntity(toughnessTotal);

        // Total Strength

        var strengthText = new TextEntity(new Coordinate2D(280, 265),  "Total Attack");
        strengthText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        strengthText.setFill(Color.WHITE);
        strengthText.setFont(depthsDescending.ringbearerStats);

        var strengthTotal = new TextEntity(new Coordinate2D(280, 295),  "" + depthsDescending.player1.getAttack());
        strengthTotal.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        strengthTotal.setFill(Color.WHITE);
        strengthTotal.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 15));

        addEntity(strengthTotal);
        addEntity(strengthText);

        // button to get to start screen
        Button endButton = new Button(new Coordinate2D(getWidth()/2, getHeight()/2 + 210), depthsDescending, 0, "Return to home", new OnEndButton());
        endButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endButton);
    }
}
