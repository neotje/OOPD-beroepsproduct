package com.github.neotje.DepthsDescending.GamePlay;

import com.github.hanyaeger.api.Timer;
import com.github.neotje.DepthsDescending.Entities.Enemy;

public class CoolDownTimer extends Timer {
    private Combat entity;

    /**
     * @author Neo Hop
     * @param entity Entity die cooldown heeft.
     */
    public CoolDownTimer(Combat entity) {
        super(entity.getAttackCoolDown());
        this.entity = entity;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        entity.setCoolingDown(false);
        pause();
    }
}
