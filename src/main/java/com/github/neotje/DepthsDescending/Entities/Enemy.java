package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.GamePlay.Combat;
import com.github.neotje.DepthsDescending.GamePlay.CoolDownTimer;

public abstract class Enemy extends DynamicCompositeEntity implements Combat, Collider, Collided, TimerContainer {
    protected int attack;
    protected int toughness;
    protected DepthsDescending depthsDescending;

    private CoolDownTimer coolDownTimer;
    private int attackCoolDown;
    private boolean isCoolingDown;

    public Enemy(Coordinate2D location, int attack, int toughness, int attackCoolDown, DepthsDescending depthsDescending){
        super(location);
        this.attack = attack;
        this.toughness = toughness;
        this.attackCoolDown = attackCoolDown;
        this.depthsDescending = depthsDescending;
        isCoolingDown = false;
    }

        public int getAttackCoolDown() {
        return attackCoolDown;
    }

    public abstract void onAttack(Player player);

    @Override
    public void setCoolingDown(boolean newState) {
        isCoolingDown = newState;
    }

    @Override
    public void setupTimers() {
        coolDownTimer = new CoolDownTimer(this);
        addTimer(coolDownTimer);
        coolDownTimer.pause();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject instanceof Player && !isCoolingDown) {
            onAttack((Player) collidingObject);
            //System.out.println("Enemy has attacked!");
            coolDownTimer.resume();
            setCoolingDown(true);
        }
    }

    @Override
    public void doeDamage(int attackStrength){
        
    }

    public int getAttack(){
        return attack;
    }

    public int getToughness() {
        return toughness;
    }
}