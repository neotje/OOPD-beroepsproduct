package com.github.neotje.DepthsDescending.Scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Entities.Door;
import com.github.neotje.DepthsDescending.Entities.Dragon;
import com.github.neotje.DepthsDescending.Entities.Goblin;
import com.github.neotje.DepthsDescending.Entities.Skeleton;
import com.github.neotje.DepthsDescending.Sprites.Icons.Icons;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameScene extends DynamicScene {
    protected String location;
    protected DepthsDescending depthsDescending;


    public GameScene(String location, DepthsDescending depthsDescending){
        this.location = location;
        this.depthsDescending = depthsDescending;
    }
    @Override
    public void setupScene() {
        setBackgroundImage(location);

    }

    @Override
    public void setupEntities() {
        // var for the doors
        var doorLeft = new Door(new Coordinate2D((getWidth()/2)-230, (getHeight()/2)-40), 50, 20, depthsDescending, 1);
        var doorRight = new Door(new Coordinate2D((getWidth()/2)+230, (getHeight()/2)-40), 50, 20, depthsDescending, 2);
        var bossGate = new Door(new Coordinate2D(getWidth()/2, (getHeight()/2)-160),20, 100, depthsDescending);

        //add the player to the scene
        addEntity(depthsDescending.player1);

        //add the roomnr to the scene

        var roomText = new TextEntity(new Coordinate2D(0, 0), "Room " + depthsDescending.player1.roomNR);
        roomText.setFill(Color.WHITE);
        roomText.setFont(depthsDescending.ringbearerParagraph);
        addEntity(roomText);

        // add Attack and Toughness to scene

        var attackIcon = new Icons("textures/sword.png", new Coordinate2D(getWidth()-getWidth(), getHeight()-60));
        addEntity(attackIcon);

        var attackText = new TextEntity(new Coordinate2D(getWidth()-getWidth() + 20, getHeight()-60), "" + depthsDescending.player1.getAttack());
        attackText.setFill(Color.WHITE);
        attackText.setFont(depthsDescending.ringbearerStats);
        addEntity(attackText);

        var toughnessIcon = new Icons("textures/shield.png", new Coordinate2D(getWidth()-getWidth(), getHeight()-40));
        addEntity(toughnessIcon);

        var toughnessText = new TextEntity(new Coordinate2D(getWidth()-getWidth()+20, getHeight()-40), "" + depthsDescending.player1.getToughness());
        toughnessText.setFill(Color.WHITE);
        toughnessText.setFont(depthsDescending.ringbearerStats);
        addEntity(toughnessText);

        // add enemy entities
        if(depthsDescending.player1.roomNR != 10 && depthsDescending.player1.roomNR != 9){
            addEntity(doorLeft);
            addEntity(doorRight);
            var goblin = new Goblin(new Coordinate2D(getWidth()/2, getHeight()/2) , 1, 10);
            addEntity(goblin);
        }
        if(depthsDescending.player1.roomNR == 9){
            addEntity(bossGate);
            var skeleton1 = new Skeleton(new Coordinate2D(getWidth()/2, getHeight()/2) , 10, 10);
            var skeleton2 = new Skeleton(new Coordinate2D(getWidth()/2, getHeight()/2) , 10, 10);
            //addEntity(skeleton1);
            //addEntity(skeleton2);
        }
        if(depthsDescending.player1.roomNR == 10) {
            var dragon = new Dragon(new Coordinate2D(getWidth()/2, getHeight()/2) , 100, 100);
            addEntity(dragon);
        }
    }
    /*
    @Override
    public void onMouseMoved(Coordinate2D coordinate2D){
        System.out.println(coordinate2D);
    }
     */
}
