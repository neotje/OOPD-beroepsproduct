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

public class StartButton extends TextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {
    public DepthsDescending depthsDescending;

    public StartButton(Coordinate2D initialLocation, DepthsDescending depthsDescending){
        super(initialLocation, "Start Game");
        this.depthsDescending = depthsDescending;
        setFill(Color.PURPLE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        depthsDescending.setActiveScene(1);

    }

    @Override
    public void onMouseEntered() {
        setFill(Color.DEEPSKYBLUE);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.DEEPPINK);
        setCursor(Cursor.DEFAULT);

    }
}
