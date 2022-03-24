package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Scenes.GameScene;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Newtonian, Combat, Collider {
    private int attack;
    private int toughness;
    private double speed;
    public int roomNR;
    DepthsDescending depthsDescending;
    public Player(int attack, int toughness, double speed, Coordinate2D initialLocation,DepthsDescending depthsDescending) {
        super("background/hanny.png", initialLocation, new Size(50, 50));
        this.depthsDescending = depthsDescending;
        this.attack = attack;
        this.toughness = toughness;
        this.speed = speed;
        roomNR++;
    }

    public void Movement(Set<KeyCode> pressedKeys) {
        mapBoundary();
        if (pressedKeys.contains(KeyCode.W) && pressedKeys.contains(KeyCode.D)) {
            setMotion(this.speed, 180d - 45d);
        } else if (pressedKeys.contains(KeyCode.D) && pressedKeys.contains(KeyCode.S)) {
            setMotion(this.speed, 90d - 45d);
        } else if (pressedKeys.contains(KeyCode.S) && pressedKeys.contains(KeyCode.A)) {
            setMotion(this.speed, -45d);
        } else if (pressedKeys.contains(KeyCode.A) && pressedKeys.contains(KeyCode.W)) {
            setMotion(this.speed, 270d - 45d);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(this.speed, 180d);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(this.speed, 90d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(this.speed, 0d);
        } else if (pressedKeys.contains(KeyCode.A)) {
            setMotion(this.speed, 270d);
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        this.Movement(pressedKeys);
    }


    public void mapBoundary(){
        //System.out.println(getAnchorLocation());
        setSpeed(0);
        if(getAnchorLocation().getX() <= 104){
            setAnchorLocationX(105);
        } else if(getAnchorLocation().getX() >= 528){
            setAnchorLocationX(527);
        } else if(getAnchorLocation().getY() <= 102){
            setAnchorLocationY(101);
        } else if(getAnchorLocation().getY() >= 349){
            setAnchorLocationY(349);
        }

    }
    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);
        //System.out.println();
        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject instanceof Goblin){
            ((Combat) collidingObject).doeDamage(this.attack);
        } else if(collidingObject instanceof Door){
            roomNR++;
            setAnchorLocation(new Coordinate2D(316, 349));
            depthsDescending.setActiveScene(roomNR);
        }
    }

    @Override
    public void doeDamage(int attackStrength) {
        this.toughness -= attackStrength;
    }
}
