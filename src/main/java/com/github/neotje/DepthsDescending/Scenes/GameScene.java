package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.neotje.DepthsDescending.DepthsDescending;

public class GameScene extends DynamicScene {
    protected String location;
    protected DepthsDescending depthsDescending;

    public GameScene(String location, DepthsDescending depthsDescending){
        this.location = location;
        this.depthsDescending = depthsDescending;
    }
    @Override
    public void setupScene() {
        setBackgroundImage(location);

    }

    @Override
    public void setupEntities() {
        addEntity(depthsDescending.player1);
    }
}
