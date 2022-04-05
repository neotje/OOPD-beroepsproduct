package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.GamePlay.OnGameStart;
import com.github.neotje.DepthsDescending.Sprites.Buttons.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    private DepthsDescending depthsDescending;

    public TitleScene(DepthsDescending depthsDescending){
        this.depthsDescending = depthsDescending;

    }
    @Override
    public void setupScene() {
        setBackgroundImage("background/Startscene.png");
        depthsDescending.setMusic("sound/start_screen.mp3");
    }

    @Override
    public void setupEntities() {
        var titleText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2), "Depths Descending");

        titleText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        titleText.setFont(depthsDescending.ringbearerTitle);
        Button startButton = new Button(new Coordinate2D(getWidth()/2, getHeight()/2 + 60), depthsDescending, 1, "Start game", new OnGameStart());
        startButton.setFill(Color.BLACK);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(titleText);
        addEntity(startButton);
    }
}
