package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EndScene extends StaticScene {
    private int enemies;
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
        timeText.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 80));
        addEntity(timeText);

        // Enemies slain
        var enemiesSlain = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/2 + 60),  "Enemies Slain: " + enemies);
        enemiesSlain.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        enemiesSlain.setFont(Font.font("fonts/RINGM___.tiff", FontWeight.SEMI_BOLD, 80));
        addEntity(enemiesSlain);

        //
    }
}
