package com.github.neotje.DepthsDescending.GamePlay;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.neotje.DepthsDescending.DepthsDescending;
import com.github.neotje.DepthsDescending.Sprites.Buttons.Button;
import com.github.neotje.DepthsDescending.Sprites.Buttons.OnButtonPressedEvent;
import javafx.scene.input.MouseButton;

public class OnEndButton implements OnButtonPressedEvent {
    @Override
    public void onClicked(Button button, MouseButton mouseButton, Coordinate2D mouseCoordinate, DepthsDescending depthsDescending) {
        depthsDescending.gameReset();
    }
}
