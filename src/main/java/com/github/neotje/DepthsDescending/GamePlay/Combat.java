package com.github.neotje.DepthsDescending.GamePlay;

public interface Combat {
    void setCoolingDown(boolean newState);
    int getAttackCoolDown();
    void doeDamage(int attackStrength);
}