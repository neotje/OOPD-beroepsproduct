package com.github.neotje.DepthsDescending.GamePlay;

public interface Combat {
    void setCoolingDown(boolean newState);
    int getAttackCoolDown();

    /**
     * Via deze functie krijg je damage van een aanvallende entity.
     * @author Neo Hop
     * @param attackStrength aanvals sterkte.
     */
    void doeDamage(int attackStrength);
}