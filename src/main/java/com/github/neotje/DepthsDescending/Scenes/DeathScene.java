package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.GamePlay.OnEndButton;
import com.github.neotje.DepthsDescending.Sprites.Buttons.Button;
import javafx.scene.paint.Color;

public class DeathScene extends StaticScene {

    private DepthsDescending depthsDescending;

    public DeathScene(DepthsDescending depthsDescending){
        this.depthsDescending = depthsDescending;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("background/deathScene.png");
        depthsDescending.setMusic("sound/death_screen.mp3");
    }

    @Override
    public void setupEntities() {
        // score in title

        var titleText = new TextEntity(new Coordinate2D(10,0), "You Died");
        titleText.setFill(Color.WHITE);
        titleText.setFont(depthsDescending.ringbearerTitle);
        addEntity(titleText);


        // button to get to start screen
        Button endButton = new Button(new Coordinate2D(getWidth()/2, getHeight()/2 + 210), depthsDescending, 0, "Return to home", new OnEndButton());
        endButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endButton);
    }
}
