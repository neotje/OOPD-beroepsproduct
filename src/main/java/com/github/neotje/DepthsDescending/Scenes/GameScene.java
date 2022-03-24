package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
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
        depthsDescending.player1.mapBoundary();
        addEntity(depthsDescending.player1);
    }

    /*
    @Override
    public void onMouseMoved(Coordinate2D coordinate2D){
        System.out.println(coordinate2D);
    }
     */
}
