package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameScene extends DynamicScene {
    protected String location;

    public GameScene(String location){
        this.location = location;
    }
    @Override
    public void setupScene() {
        setBackgroundImage(location);

    }

    @Override
    public void setupEntities() {
        addEntity(getPlayer1());
    }
}
