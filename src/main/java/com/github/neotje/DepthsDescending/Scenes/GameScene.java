package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Entities.Door;
import com.github.neotje.DepthsDescending.Entities.Dragon;
import com.github.neotje.DepthsDescending.Entities.Goblin;
import com.github.neotje.DepthsDescending.Entities.Skeleton;

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
        // var for the doors
        var doorLeft = new Door(new Coordinate2D((getWidth()/2)-230, (getHeight()/2)-40), 50, 20);
        var doorRight = new Door(new Coordinate2D((getWidth()/2)+230, (getHeight()/2)-40), 50, 20);
        var bossGate = new Door(new Coordinate2D(getWidth()/2, (getHeight()/2)-160),20, 100);

        //add the player to the scene
        addEntity(depthsDescending.player1);

        //add the roomnr to the scene

        var roomText = new TextEntity(new Coordinate2D(0, 0), "Room: " + depthsDescending.player1.roomNR);

        addEntity(roomText);
        if(depthsDescending.player1.roomNR != 10 && depthsDescending.player1.roomNR != 9){
            addEntity(doorLeft);
            addEntity(doorRight);
            var goblin = new Goblin(new Coordinate2D(getWidth()/2, getHeight()/2) , 10, 10);
            addEntity(goblin);
        }
        if(depthsDescending.player1.roomNR == 9){
            addEntity(bossGate);
            var skeleton1 = new Skeleton(new Coordinate2D(getWidth()/2, getHeight()/2) , 10, 10);
            var skeleton2 = new Skeleton(new Coordinate2D(getWidth()/2, getHeight()/2) , 10, 10);
            addEntity(skeleton1);
            addEntity(skeleton2);
        }
        if(depthsDescending.player1.roomNR == 10) {
            var dragon = new Dragon(new Coordinate2D(getWidth()/2, getHeight()/2) , 100, 100);
            addEntity(dragon);
        }
    }
    /*
    @Override
    public void onMouseMoved(Coordinate2D coordinate2D){
        System.out.println(coordinate2D);
    }
     */
}
