package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Sprites.Buttons.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    public DepthsDescending depthsDescending;

    public TitleScene(DepthsDescending depthsDescending){
        this.depthsDescending = depthsDescending;

    }
    @Override
    public void setupScene() {
        setBackgroundImage("background/titleScene.png");
    }

    @Override
    public void setupEntities() {
        var titleText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2), "Depths Descending");

        titleText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        titleText.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 80));
        Button startButton = new Button(new Coordinate2D(getWidth()/2, getHeight()/2 + 60), depthsDescending, 1, "Start game");
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(titleText);
        addEntity(startButton);
    }
}
