package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndScene extends StaticScene {
    @Override
    public void setupScene() {
        setBackgroundImage("background/endScene.png");
    }

    @Override
    public void setupEntities() {
        var titleText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2), "Endscreen");

        titleText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        titleText.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 80));

        addEntity(titleText);
    }
}
