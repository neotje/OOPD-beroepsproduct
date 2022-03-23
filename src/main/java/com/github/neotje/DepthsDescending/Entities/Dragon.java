package com.github.neotje.DepthsDescending.Entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.neotje.DepthsDescending.Sprites.DragonClaw;
import com.github.neotje.DepthsDescending.Sprites.DragonHead;
import com.github.neotje.DepthsDescending.Sprites.DragonNeck;

public class Dragon extends Enemy{
    public Dragon(Coordinate2D location, int Attack, int Toughness) {
        super(location, Attack, Toughness);
    }

    @Override
    protected void setupEntities(){
        var dragonNeckSegment1 = new DragonNeck(new Coordinate2D(0, -160), "textures/dragon/DragonNeckSegment.png");
        dragonNeckSegment1.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var dragonNeckSegment2 = new DragonNeck(new Coordinate2D(0, -140), "textures/dragon/DragonNeckSegment.png");
        dragonNeckSegment2.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var dragonNeckSegment3 = new DragonNeck(new Coordinate2D(0, -120), "textures/dragon/DragonNeckSegment.png");
        dragonNeckSegment3.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var dragonNeckSegment4 = new DragonNeck(new Coordinate2D(0, -100), "textures/dragon/DragonNeckSegment.png");
        dragonNeckSegment4.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var dragonHead = new DragonHead(new Coordinate2D(0, -60), "textures/dragon/DragonHead.png");
        dragonHead.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var dragonClawR = new DragonClaw(new Coordinate2D(-150, -130) , "textures/dragon/DragonClawR.png");
        dragonClawR.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var dragonClawL = new DragonClaw(new Coordinate2D(150, -130) , "textures/dragon/DragonClawL.png");
        dragonClawL.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(dragonNeckSegment1);
        addEntity(dragonNeckSegment2);
        addEntity(dragonNeckSegment3);
        addEntity(dragonNeckSegment4);
        addEntity(dragonHead);
        addEntity(dragonClawR);
        addEntity(dragonClawL);
    }
}
