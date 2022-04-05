package com.github.neotje.DepthsDescending.Sprites.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.neotje.DepthsDescending.DepthsDescending;
import javafx.scene.input.MouseButton;

public interface OnButtonPressedEvent {
    /**
     * Wordt aangeroepen op het moment
     * @author Neo Hop
     * @param button ingedrukte knop.
     * @param mouseButton de muisknop die gebruikt werdt om de knop in te drukken.
     * @param mouseCoordinate coordinaten van de muis.
     * @param depthsDescending Game object.
     */
    void onClicked(Button button, MouseButton mouseButton, Coordinate2D mouseCoordinate, DepthsDescending depthsDescending);
}
