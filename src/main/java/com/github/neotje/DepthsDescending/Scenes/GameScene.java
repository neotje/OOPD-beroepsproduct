package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Entities.Door;
import com.github.neotje.DepthsDescending.Entities.Dragon;

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
        var doorLeft = new Door(new Coordinate2D((getWidth()/2)-230, (getHeight()/2)-40), 50, 20);
        var doorRight = new Door(new Coordinate2D((getWidth()/2)+230, (getHeight()/2)-40), 50, 20);
        addEntity(doorLeft);
        addEntity(doorRight);
        //var dragon = new Dragon(new Coordinate2D(getWidth()/2, getHeight()/2) , 100, 100);
        //addEntity(dragon);
    }

    /*
    @Override
    public void onMouseMoved(Coordinate2D coordinate2D){
        System.out.println(coordinate2D);
    }
     */
}
