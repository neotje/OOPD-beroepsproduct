package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.neotje.DepthsDescending.DepthsDescending;
import javafx.scene.paint.Color;

public class Door extends RectangleEntity implements Collider, Collided{
    private int upgradeDoor;
    private DepthsDescending depthsDescending;

    /**
     * @author Brian Vriezen
     * @param location locaties van de deur
     * @param height deur hoogte
     * @param width deur breedte
     * @param depthsDescending game object
     */
    public Door(Coordinate2D location, int height, int width, DepthsDescending depthsDescending){
        super(location);
        setHeight(height);
        setWidth(width);
        setFill(new Color(0,0,0,0));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.depthsDescending = depthsDescending;
    }

    /**
     * @author Brian Vriezen
     * @param location locaties van de deur
     * @param height deur hoogte
     * @param width deur breedte
     * @param depthsDescending game object
     * @param choice keuze van de deur of de attack of toughness omhoog gaat
     */
    public Door(Coordinate2D location, int height, int width, DepthsDescending depthsDescending, int choice){
        super(location);
        setHeight(height);
        setWidth(width);
        setFill(new Color(0,0,0,0));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        upgradeDoor = choice;
        this.depthsDescending = depthsDescending;
    }

    /**
     * @author
     * @param collider
     */
    @Override
    public void onCollision(Collider collider) {
        System.out.println("Door");

    }

    /**
     * methode om de statistieken te upgraden van de speler
     * @author Jesse Veldmaat
     */
    public void upgradeStat(){
        if(upgradeDoor == 1){
            System.out.println(upgradeDoor);
            depthsDescending.player1.setAttack(2);
        } else if(upgradeDoor == 2){
            System.out.println(upgradeDoor);
            depthsDescending.player1.setBaseToughness(2);
        }
    }
}