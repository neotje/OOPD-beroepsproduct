package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided {
    private int attack;
    private int toughness;
    private double speed;

    public Player(int attack, int toughness, double speed, Coordinate2D initialLocation, Size size) {
        super("", initialLocation, size);

        this.attack = attack;
        this.toughness = toughness;
        this.speed = speed;
    }

    public void Movement(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.W)) {
            setMotion(this.speed, 0d);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(this.speed, 90d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(this.speed, 180d);
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

    }

    @Override
    public void onCollision(Collider collidingObject) {

    }
}
