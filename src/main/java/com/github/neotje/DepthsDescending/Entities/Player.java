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
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Newtonian, Combat {
    private int attack;
    private int toughness;
    private double speed;

    public Player(int attack, int toughness, double speed, Coordinate2D initialLocation) {
        super("background/hanny.png", initialLocation, new Size(50, 50));

        this.attack = attack;
        this.toughness = toughness;
        this.speed = speed;

        setFrictionConstant(0.08);
        setGravityConstant(0);
    }

    public void Movement(Set<KeyCode> pressedKeys) {
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

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

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
        ((Combat) collidingObject).doeDamage(this.attack);
    }

    @Override
    public void doeDamage(int attackStrength) {

    }
}
