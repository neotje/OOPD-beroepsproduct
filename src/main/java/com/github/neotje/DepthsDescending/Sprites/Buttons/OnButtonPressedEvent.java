package com.github.neotje.DepthsDescending.Sprites.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.neotje.DepthsDescending.DepthsDescending;
import javafx.scene.input.MouseButton;

public interface OnButtonPressedEvent {
    void onClicked(Button button, MouseButton mouseButton, Coordinate2D mouseCoordinate, DepthsDescending depthsDescending);
}
