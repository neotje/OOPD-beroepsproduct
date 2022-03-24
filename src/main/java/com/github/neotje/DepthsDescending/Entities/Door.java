package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Door extends RectangleEntity implements Collider, Collided{

    public Door(Coordinate2D location, int height, int width){
        super(location);
        setHeight(height);
        setWidth(width);
        setFill(Color.RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onCollision(Collider collider) {
        System.out.println("Door");
    }
}
