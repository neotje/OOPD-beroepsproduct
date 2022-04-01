package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.neotje.DepthsDescending.DepthsDescending;
import javafx.scene.paint.Color;

public class Door extends RectangleEntity implements Collider, Collided{
    int whichDoor;
    DepthsDescending depthsDescending;

    public Door(Coordinate2D location, int height, int width, DepthsDescending depthsDescending){
        super(location);
        setHeight(height);
        setWidth(width);
        setFill(Color.RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.depthsDescending = depthsDescending;
    }

    public Door(Coordinate2D location, int height, int width, DepthsDescending depthsDescending, int choice){
        super(location);
        setHeight(height);
        setWidth(width);
        //setFill(Color.RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        whichDoor = choice;
        this.depthsDescending = depthsDescending;
    }

    @Override
    public void onCollision(Collider collider) {
        System.out.println("Door");

    }

    public void upgradeStat(){
        if(whichDoor == 1){
            System.out.println(whichDoor);
            depthsDescending.player1.setAttack(2);
        } else if(whichDoor == 2){
            System.out.println(whichDoor);
            depthsDescending.player1.setBaseToughness(2);
        }
    }
}