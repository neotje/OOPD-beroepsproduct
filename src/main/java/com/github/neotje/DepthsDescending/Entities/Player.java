package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Scenes.GameScene;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Combat, Collider, UpdateExposer {
    private int attack;
    private int toughness;
    private double speed;
    public int roomNR;
    DepthsDescending depthsDescending;

    enum Side {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    private final int[] boundary = {
            104, //left
            528, //right
            102, //top
            349 // bottom
    };

    public Player(int attack, int toughness, double speed, Coordinate2D initialLocation, DepthsDescending depthsDescending) {
        super("textures/hanny.png", initialLocation, new Size(50, 100), 1, 2);
        this.depthsDescending = depthsDescending;
        this.attack = attack;
        this.toughness = toughness;
        this.speed = speed;
        roomNR++;
    }

    public void Movement(Set<KeyCode> pressedKeys) {
        Set<Side> touchingSide = isTouchingBoundary();

        setSpeed(0);

        if (pressedKeys.contains(KeyCode.W) && pressedKeys.contains(KeyCode.D)) {
            setMotion(this.speed, 180d - 45d);
        } else if (pressedKeys.contains(KeyCode.D) && pressedKeys.contains(KeyCode.S)) {
            setMotion(this.speed, 90d - 45d);
        } else if (pressedKeys.contains(KeyCode.S) && pressedKeys.contains(KeyCode.A)) {
            setMotion(this.speed, -45d);
        } else if (pressedKeys.contains(KeyCode.A) && pressedKeys.contains(KeyCode.W)) {
            setMotion(this.speed, 270d - 45d);
        } else if (pressedKeys.contains(KeyCode.W) && !touchingSide.contains(Side.TOP)) {
            setMotion(this.speed, 180d);
        } else if (pressedKeys.contains(KeyCode.D) && !touchingSide.contains(Side.RIGHT)) {
            setMotion(this.speed, 90d);
        } else if (pressedKeys.contains(KeyCode.S) && !touchingSide.contains(Side.BOTTOM)) {
            setMotion(this.speed, 0d);
        } else if (pressedKeys.contains(KeyCode.A)) {
            setMotion(this.speed, 270d);
        }
    }

    public void mapBoundary(){
        Set<Side> touchingSide = isTouchingBoundary();

        if(touchingSide.contains(Side.LEFT)) {
            setAnchorLocationX(boundary[0]);
        }
        if(touchingSide.contains(Side.RIGHT)) {
            setAnchorLocationX(boundary[1]);
        }
        if(touchingSide.contains(Side.TOP)) {
            setAnchorLocationY(boundary[2]);
        }
        if(touchingSide.contains(Side.BOTTOM)) {
            setAnchorLocationY(boundary[3]);
        }
    }

    private Set<Side> isTouchingBoundary() {
        Set<Side> sides = new HashSet<Side>();

        if(getAnchorLocation().getX() <= boundary[0]){
            sides.add(Side.LEFT);
        }
        if(getAnchorLocation().getX() >= boundary[1]){
            sides.add(Side.RIGHT);
        }
        if(getAnchorLocation().getY() <= boundary[2]){
            sides.add(Side.TOP);
        }
        if(getAnchorLocation().getY() >= boundary[3]) {
            sides.add(Side.BOTTOM);
        }

        return sides;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        this.Movement(pressedKeys);
    }

    @Override
    public void explicitUpdate(long timestamp) {
        mapBoundary();
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
