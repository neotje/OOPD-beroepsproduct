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
    private float speed;

    protected Player(int attack, int toughness, float speed, String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);

        this.attack = attack;
        this.toughness = toughness;
        this.speed = speed;
    }

    public void Movement(Set<KeyCode> pressedKeys) {

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
