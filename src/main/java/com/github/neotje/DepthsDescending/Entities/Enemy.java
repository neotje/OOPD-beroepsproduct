package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.neotje.DepthsDescending.GamePlay.Combat;
import com.github.neotje.DepthsDescending.GamePlay.CoolDownTimer;

public abstract class Enemy extends DynamicCompositeEntity implements Combat, Collider, Collided, TimerContainer {
    protected int attack;
    protected int toughness;

    private CoolDownTimer coolDownTimer;
    private int attackCoolDown;
    private boolean isCoolingDown = false;

    Enemy(Coordinate2D location, int attack, int toughness, int attackCoolDown){
        super(location);
        this.attack = attack;
        this.toughness = toughness;
        this.attackCoolDown = attackCoolDown;
    }

    public int getAttackCoolDown() {
        return attackCoolDown;
    }

    public void setCoolingDown(boolean newState) {
        isCoolingDown = newState;
    }

    public abstract void onAttack(Player player);

    @Override
    public void setupTimers() {
        coolDownTimer = new CoolDownTimer(this);
        addTimer(coolDownTimer);
        coolDownTimer.pause();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        //((Combat) collidingObject).doeDamage(this.attack);

        if(collidingObject instanceof Player && !isCoolingDown) {
            onAttack((Player) collidingObject);
            System.out.println("Enemy has attacked!");
            coolDownTimer.resume();
            setCoolingDown(true);
        }
    }
}
