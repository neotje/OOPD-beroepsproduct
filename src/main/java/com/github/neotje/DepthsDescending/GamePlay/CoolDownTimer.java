package com.github.neotje.DepthsDescending.GamePlay;

import com.github.hanyaeger.api.Timer;
import com.github.neotje.DepthsDescending.Entities.Enemy;

public class CoolDownTimer extends Timer {
    private Enemy enemy;

    public CoolDownTimer(Enemy enemy) {
        super(enemy.getAttackCoolDown());
        this.enemy = enemy;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        enemy.setCoolingDown(false);
        pause();
    }
}
