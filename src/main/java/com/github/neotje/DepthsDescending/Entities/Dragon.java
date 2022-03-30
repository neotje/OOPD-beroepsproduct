package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.GamePlay.Combat;
import com.github.neotje.DepthsDescending.Sprites.DragonHead;
import com.github.neotje.DepthsDescending.Sprites.DragonNeck;
import com.github.hanyaeger.api.UpdateExposer;

public class Dragon extends Enemy implements UpdateExposer{

    DragonHead dragonHead;
    DragonNeck dragonNeck1;
    DragonNeck dragonNeck2;
    DragonNeck dragonNeck3;
    DragonNeck dragonNeck4;
    boolean[] headDirection = {false, false};
    double[] headPosition = {0, -60};
    double[] neckPosition1 = {0, -160};
    double[] neckPosition2 = {0, -140};
    double[] neckPosition3 = {0, -120};
    double[] neckPosition4 = {0, -100};

    public Dragon(Coordinate2D location, int attack, int toughness, DepthsDescending depthsDescending) {
        super(location, attack, toughness, 3000, depthsDescending);
    }

    @Override
    protected void setupEntities(){
        dragonNeck1 = new DragonNeck(new Coordinate2D(neckPosition1[0], neckPosition1[1]), "textures/dragon/DragonNeckSegment.png");
        dragonNeck1.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        dragonNeck2 = new DragonNeck(new Coordinate2D(neckPosition2[0], neckPosition2[1]), "textures/dragon/DragonNeckSegment.png");
        dragonNeck2.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        dragonNeck3 = new DragonNeck(new Coordinate2D(neckPosition3[0], neckPosition3[1]), "textures/dragon/DragonNeckSegment.png");
        dragonNeck3.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        dragonNeck4 = new DragonNeck(new Coordinate2D(neckPosition4[0], neckPosition4[1]), "textures/dragon/DragonNeckSegment.png");
        dragonNeck4.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        dragonHead = new DragonHead(new Coordinate2D(headPosition[0], headPosition[1]), "textures/dragon/DragonHead.png");
        dragonHead.setAnchorPoint(AnchorPoint.CENTER_CENTER);


        addEntity(dragonNeck1);
        addEntity(dragonNeck2);
        addEntity(dragonNeck3);
        addEntity(dragonNeck4);
        addEntity(dragonHead);
    }

    @Override
    public void doeDamage(int attack) {
        this.toughness -= attack;

        if (this.toughness <= 0) {
            depthsDescending.player1.setEnemiesSlain();
            this.remove();
        }
    }

    @Override
    public void onAttack(Player player) {
        player.doeDamage(this.attack);
    }

    @Override
    public void explicitUpdate(long l) {
        headMovement();
        neckMovement(-5, 5, -160,-155, neckPosition1, dragonNeck1, 0.2);
        neckMovement(-12, 12, -140,-132, neckPosition2, dragonNeck2, 0.4);
        neckMovement(-22, 22, -120,-112, neckPosition3, dragonNeck3, 0.6);
        neckMovement(-32, 32, -100,-92, neckPosition4, dragonNeck4, 0.8);
    }

    void headMovement(){
        if(headPosition[0] >= -40 && !headDirection[0]){
            headPosition[0]--;
            if(headPosition[0] <= -40){
                headDirection[0] = true;
            }
        } else if (headPosition[0] <= 40 && headDirection[0])
        {
            headPosition[0]++;
            if(headPosition[0] >= 40){
                headDirection[0] = false;
            }
        }

        if(headPosition[1] >= -60 && !headDirection[1]){
            headPosition[1] -= 0.2;
            if(headPosition[1] <= -60){
                headDirection[1] = true;
            }
        } else if (headPosition[1] <= -50 && headDirection[1])
        {
            headPosition[1] += 0.2;
            if(headPosition[1] >= -50){
                headDirection[1] = false;
            }
        }
        dragonHead.setAnchorLocationX(headPosition[0]);
        dragonHead.setAnchorLocationY(headPosition[1]);
    }

    void neckMovement(double minX, double maxX, double minY, double maxY, double[] position, DragonNeck neck, double speed){
        if(position[0] >= minX && !headDirection[0]){
            position[0] -= speed;
        } else if (position[0] <= maxX && headDirection[0])
        {
            position[0] += speed;
        }

        if(position[1] >= minY && !headDirection[1]){
            position[1] -= 0.2;
        } else if (position[1] <= maxY && headDirection[1])
        {
            position[1] += 0.2;
        }
        neck.setAnchorLocationX(position[0]);
        neck.setAnchorLocationY(position[1]);
    }

}
