package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.GamePlay.Combat;
import com.github.neotje.DepthsDescending.GamePlay.CoolDownTimer;
import com.github.neotje.DepthsDescending.Scenes.RoomScene;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Combat, Collider, UpdateExposer, TimerContainer {
    private int attack;
    private int toughness;
    private int baseToughness;
    private double speed;

    private int enemiesSlain;

    public int roomNR;
    private RoomScene currentRoom = null;

    CoolDownTimer coolDownTimer;
    private int attackCoolDown = 1000;
    private boolean isCoolingDown = false;

    DepthsDescending depthsDescending;

    @Override
    public void setupTimers() {
        coolDownTimer = new CoolDownTimer(this);
        addTimer(coolDownTimer);
        coolDownTimer.pause();
    }



    enum Side {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    private final int[] boundary = {
            104, //left
            558, //right
            102, //top
            329 // bottom
    };

    /**
     * @author Neo Hop, Jesse Veldmaat , Brian Vriezen
     * @param attack aanval sterkte
     * @param toughness aantal levens
     * @param speed loop snelheid
     * @param initialLocation start positie
     * @param depthsDescending game object
     */
    public Player(int attack, int toughness, double speed, Coordinate2D initialLocation, DepthsDescending depthsDescending) {
        super("textures/player.png", initialLocation, new Size(30, 60), 1, 2);
        this.depthsDescending = depthsDescending;
        this.attack = attack;
        this.toughness = toughness;
        this.baseToughness = toughness;
        this.speed = speed;
        enemiesSlain = 0;
        roomNR++;
    }

    public void setCurrentRoom(RoomScene currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Speler movement afhandelen
     * @author Neo Hop
     * @param pressedKeys
     */
    public void Movement(Set<KeyCode> pressedKeys) {
        Set<Side> touchingSide = isTouchingBoundary();

        setSpeed(0);

        if (pressedKeys.contains(KeyCode.W) && pressedKeys.contains(KeyCode.D)) {
            setMotion(this.speed, 180d - 45d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.D) && pressedKeys.contains(KeyCode.S)) {
            setMotion(this.speed, 90d - 45d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.S) && pressedKeys.contains(KeyCode.A)) {
            setMotion(this.speed, -45d);
            setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.A) && pressedKeys.contains(KeyCode.W)) {
            setMotion(this.speed, 270d - 45d);
            setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.W) && !touchingSide.contains(Side.TOP)) {
            setMotion(this.speed, 180d);
        } else if (pressedKeys.contains(KeyCode.D) && !touchingSide.contains(Side.RIGHT)) {
            setMotion(this.speed, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.S) && !touchingSide.contains(Side.BOTTOM)) {
            setMotion(this.speed, 0d);
        } else if (pressedKeys.contains(KeyCode.A)) {
            setMotion(this.speed, 270d);
            setCurrentFrameIndex(0);
        }
    }

    /**
     * methode om de mapBoundary van de gamemap aan te wijzen
     * @author Jesse Veldmaat & Neo Hop
     */
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

    /**
     * Geeft retur welke kant van de boundary aangeraakt wordt.
     * @author Neo Hop
     * @return een set aan Side
     */
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

    // TODO: is deze functie wel nodig?
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
        if(collidingObject instanceof Enemy && !isCoolingDown){
            coolDownTimer.resume();
            setCoolingDown(true);
            ((Combat) collidingObject).doeDamage(this.attack);
        } else if(collidingObject instanceof Door){
            setCoolingDown(false);
            if(roomNR != 9){
                roomNR++;
                setAnchorLocation(new Coordinate2D(316, 349));
                ((Door) collidingObject).upgradeStat();
                toughness = baseToughness;
                depthsDescending.setActiveScene(roomNR);
            } else if(depthsDescending.keyShards == 2){
                roomNR++;
                setAnchorLocation(new Coordinate2D(316, 349));
                ((Door) collidingObject).upgradeStat();
                toughness = baseToughness;
                depthsDescending.setActiveScene(roomNR);
            }
        }
    }


    @Override
    public void setCoolingDown(boolean newState) {
        this.isCoolingDown = newState;
    }

    @Override
    public int getAttackCoolDown() {
        return attackCoolDown;
    }

    @Override
    public void doeDamage(int attackStrength) {
        toughness -= attackStrength;

        if(currentRoom != null) {
            currentRoom.updatePlayerStats();
        }
        if(this.toughness <= 0){
            this.remove();
            depthsDescending.setActiveScene(12);
        }
    }

    /**
     * methode om de verslagen enemies te updaten
     * @author Jesse Veldmaat
     */
    public void setEnemiesSlain() {
        enemiesSlain++;
    }

    /**
     * methode om de verslagen enemies terug te geven
     * @author Jesse Veldmaat
     * @return enemiesSlain
     */
    public int getEnemiesSlain(){
        return enemiesSlain;
    }

    /**
     * methode om de attack te updaten
     * @author Jesse Veldmaat
     * @param newAttack
     */
    public void setAttack(int newAttack){
        attack += newAttack;
    }

    /**
     * methode om de attack te geven
     * @author Jesse Veldmaat
     * @return attack
     */
    public int getAttack(){
        return attack;
    }

    public void setBaseToughness(int addToughness) { baseToughness += addToughness; }

    public int getToughness(){
        return toughness;
    }

    public int getBaseToughness(){
        return baseToughness;
    }
}
