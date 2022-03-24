package com.github.neotje.DepthsDescending.Rooms;

import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Scenes.GameScene;

public class Room extends GameScene {
    private DepthsDescending depthsDescending;


    public Room(String location, DepthsDescending depthsDescending){
        super(location, depthsDescending);
        this.depthsDescending = depthsDescending;

    }
}
