package com.github.neotje.DepthsDescending.Sprites.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.neotje.DepthsDescending.DepthsDescending;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Button extends TextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {
    public DepthsDescending depthsDescending;
    private int changeToScene;

    public Button(Coordinate2D initialLocation, DepthsDescending depthsDescending, int changeToScene, String buttontext){
        super(initialLocation, buttontext);
        this.changeToScene = changeToScene;
        this.depthsDescending = depthsDescending;
        setFill(Color.SADDLEBROWN);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        depthsDescending.setActiveScene(changeToScene);

    }

    @Override
    public void onMouseEntered() {
        setFill(Color.BLACK);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.BROWN);
        setCursor(Cursor.DEFAULT);

    }
}